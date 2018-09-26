import java.io.*;

public class Exercise{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      System.out.println("xの値を入力してください");
      String s = br.readLine();
      int x = Integer.parseInt(s);

      System.out.println("yの値を入力してください");
      String t = br.readLine();
      int y = Integer.parseInt(t);

      System.out.println("和 "+(x+y)+" 差 "+(x-y)+" 積 "+(x*y)+" 商 "+(x/y)+" 余 "+(x%y));

      System.out.println("続ける？(y/n)");
      String ans = br.readLine();
      if (ans.equals("n")) {
        break;
      }
    }
  }
}
