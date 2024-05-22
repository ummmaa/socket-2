import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckLocalAddress {
    public static void main(String[] args) {
        try {
            // ホスト名を取得
            String hostname = InetAddress.getLocalHost().getHostName();
            // ホスト名に関連するすべてのIPアドレスを取得
            InetAddress[] allAddresses = InetAddress.getAllByName(hostname);

            for (InetAddress address : allAddresses) {
                // IPv4アドレスのみを表示
                if (address instanceof java.net.Inet4Address) {
                    System.out.println("IPv4 Address: " + address.getHostAddress());
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("ローカルホストのIPアドレスを取得できませんでした: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
