public class Cult {
  public static void main(String[] args) {
    int x,y;
    x = 3;
    y = 7;
    System.out.println("bofore x = " + x + ", y = " + y);

    int tmp;
    tmp = x;
    x = y;
    y = tmp;
    System.out.println("after x = " + x + ", y = " + y);
  }
}
