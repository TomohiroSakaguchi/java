import java.io.*;

public class Prime{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //素数を判定するプログラム
    while(true){
      System.out.println("数を入力してください");
      String s = br.readLine();
      int n = Integer.parseInt(s);

      /*for (int cnt = 2; cnt<n-1; cnt++) {
      }
      */
      int cnt = 2;
      boolean flg = true;
      while(flg){
        if (n == cnt) {
          System.out.println(n+"素数です");
          break;
        }
        if (n%cnt == 0) {
          System.out.println(n+"は素数ではない");
          System.out.println(cnt+" と "+(n/cnt)+" で割れます");
          break;
        }
        cnt++;
      }
      System.out.println("続ける？(y/n)");
      String ans = br.readLine();
      if (ans.equals("n")) {
        System.out.println("プログラムは終了しました");
        break;
      }
      else {
        flg = true;
        System.out.println();
      }
    }
  }
}
