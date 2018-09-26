class MyPoint{
  private int x;
  private int y;

  public MyPoint(){
    x = 0;
    y = 0;
    System.out.println("初期座標を("+x+","+y+")にしました");
  };

  public MyPoint(int px, int py){
    if (px >= 0 && px <=100 && py >= 0 && py <=100) {
      x = px;
      y = py;
      System.out.println("初期座標を("+x+","+y+")にしました");
    }
    else{
      System.out.println("座標の指定範囲を見直してください");
    }
  }

  public void setX(int px){
    if (px >= 0 && px <=100) {
      x = px;
      System.out.println("xの座標を"+x+"にしました");
    }
    else{
      System.out.println("座標の指定範囲を見直してください");
    }
  };

  public void setY(int py){
    if (py >= 0 && py <=100) {
      y = py;
      System.out.println("yの座標を"+y+"にしました");
    }
    else{
      System.out.println("座標の指定範囲を見直してください");
    }
  };

  public int getX(){
    return x;
  };

  public int getY(){
    return y;
  };
}

class Prac9{
  public static void main(String[] args) {
    int x1,y1,x2,y2;

    MyPoint mp1 = new MyPoint();
    mp1.setX(3);
    mp1.setY(7);
    x1 = mp1.getX();
    y1 = mp1.getY();
    System.out.println("mp1("+x1+","+y1+")");

    MyPoint mp2 = new MyPoint(4,100);
    mp2.setX(10);
    mp2.setY(55);
    x2 = mp2.getX();
    y2 = mp2.getY();
    System.out.println("mp2("+x2+","+y2+")");

    /*
    x = 5;
    y = 7;

    mp.setX(x);
    mp.setY(y);

    gx = mp.getX();
    gy = mp.getY();

    System.out.println("xの値は"+gx+"，yの値は"+gy+"です．");
    */
  }
}
