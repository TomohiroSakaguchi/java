/*
Copyright Sakaguchi Tomohiro
*/

import java.io.*;

public class Prime{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //素数を判定するプログラム
    while(true){
      System.out.println("数を入力してください");
      String s = br.readLine();//コマンド上で数を入力
      int n = Integer.parseInt(s);

      int cnt = 2;//割る数の変数
      boolean flg = true;
      while(flg){//cntを増やしてnを割り切れるか判定していく
        if (n == cnt || n == 2) {//入力した数とcntが同じor2が入力された場合は素数
          System.out.println(n+"素数です");
          break;
        }
        if (n == 1) {//1が入力された場合
          System.out.println(n+"は素数ではない");
          break;
        }
        if (n%cnt == 0) {//nをcntで割って余りが0
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
