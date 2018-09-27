class Exceptiontest{
  public static void main(String[] args) {
    int i = 0, j = 0, k = 0, m[] = {1};
    try {
      System.out.println("try文中");
      //k = i/j;//0で割ろうとしている
      System.out.println("m = "+m[1]);
      System.out.println("k = "+k);
    }
    catch(ArithmeticException e){
      System.out.println("catch文中1");
      System.out.println("ArithmeticException: "+e);
    }
    catch(Exception e) {
      System.out.println("catch文中2");
      System.out.println("Exception: "+e);
    }
    finally{
      System.out.println("finally文中");
    }
    System.out.println("try/catch後");
  }
}
