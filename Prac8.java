class MyPoint{
  int x;
  int y;

  void setX(int px){
    x = px;
    System.out.println("xの座標を"+x+"にしました");
  };

  void setY(int py){
    y = py;
    System.out.println("yの座標を"+y+"にしました");
  };

  int getX(){
    return x;
  };

  int getY(){
    return y;
  };
}

class Prac8{
  public static void main(String[] args) {
    int x,y,gx,gy;

    MyPoint mp = new MyPoint();

    x = 5;
    y = 7;

    mp.setX(x);
    mp.setY(y);

    gx = mp.getX();
    gy = mp.getY();

    System.out.println("xの値は"+gx+"，yの値は"+gy+"です．");
  }
}
