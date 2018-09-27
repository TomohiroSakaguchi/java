import java.io.*;

class FileReaderSample{
  public static void main(String[] args) {
    try {
      //FileReaderオブジェクトの生成
      FileReader fr = new FileReader(args[0]);
      System.out.println("-----Start-----");
      int i;
      while ((i = fr.read()) != -1) {
        if (i == 'の') {
          continue;
        }
        System.out.println((char)i);
      }
      System.out.println("-----Done-----");
      fr.close();
    }
    catch(Exception e) {
      System.err.println("Exception: "+e);
    }
  }
}
