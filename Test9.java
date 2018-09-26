import java.io.*;

class Test9{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //上の一文で標準入力を利用するための準備

    int[] test = new int[5];
    System.out.println(test.length + "人の点数を入力してください");

    for (int i = 0; i < test.length; i++) {
      String str = br.readLine();//入力されたものを文字列として格納
      test[i] = Integer.parseInt(str);//配列の要素に文字列から整数型に変換したものを代入
    }

    for (int s = 0; s<test.length-1; s++) {
      for (int t=s+1; t<test.length; t++) {
        if (test[t] > test[s]) {
          int tmp = test[t];
          test[t] = test[s];
          test[s] = tmp;
        }
      }
    }

    for (int j=0; j<test.length; j++) {
      System.out.println((j+1)+"番目の人の点数は"+test[j]+"です．");
    }
  }
}
