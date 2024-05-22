import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class TaskClientWhile {
    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            System.out.println("数を送ります");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            boolean loop = true;
            while (loop) {
                System.out.println("サーバーに計算させる数を入力してください。");
                String message = scanner.next();

                if (Integer.parseInt(message) <= 1) {
                    TaskObject sendNum = new TaskObject();
                    sendNum.setExecNumber(Integer.parseInt(message));
                    oos.writeObject(sendNum);
                    oos.flush();
                    System.out.println("終了します。");

                    loop = false;
                } else {

                    TaskObject sendnum = new TaskObject();
                    sendnum.setExecNumber(Integer.parseInt(message));

                    oos.writeObject(sendnum);
                    oos.flush();

                    // サーバーから送られてくる計算結果
                    TaskObject okaeshiNum = (TaskObject) ois.readObject();

                    int replayResult = okaeshiNum.getResult();
                    System.out.println("サーバーで計算がされました。入力値以下の最大の素数は" + replayResult);
                }
            }

            ois.close();
            oos.close();
            socket.close();
            scanner.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
