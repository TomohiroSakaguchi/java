import java.io.*;

class BufferedReaderSample{
  public static void main(String[] args) {
    try {
      //FileReaderオブジェクトの生成
      BufferedReader br = new BufferedReader(new FileReader(args[0]));
      BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
      System.out.println("-----Start-----");
      String str;
      int i,col = 0;
      while ((str = br.readLine()) != null) {
        col++;
        System.out.println(col+":"+str);
        if(str == "\n"){
          bw.newLine();
        }
        else{
          bw.write(str);
        }
      }
      System.out.println("-----Done-----");
      br.close();
      bw.close();
    }
    catch(Exception e) {
      System.err.println("Exception: "+e);
    }
  }
}
