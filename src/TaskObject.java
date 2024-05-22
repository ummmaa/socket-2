import java.io.Serializable;

public class TaskObject implements ITask,Serializable {
    int execNum;
    int result;

    public void setExecNumber(int x){
        this.execNum = x;
    }

    public void exec(){
        result = 0;
        for(int i = 1; i <= execNum; i ++){
            if(isPrime(i)){
                result = i;
            }
        }
    }

    public static boolean isPrime(int n){
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        
        // 2と3の倍数以外の奇数を確認
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        
        // 6k ± 1の形の数のみを確認
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        
        return true;
    }

    public void setResult(int x){
        this.result = x;
    }

    public int getExecNum(){
        return execNum;
    }

    public int getResult(){
        return result;
    }

}
