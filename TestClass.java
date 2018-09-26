class Car{
  private int num;
  private double gas;

  int getNum(){
    System.out.println("ナンバーを調べました");
    return num;
  }
  double getGas(){
    System.out.println("ガソリン量を調べました");
    return gas;
  }

  public void setNumGas(int n,double g){
    if (g > 0 && g < 1000) {
      num = n;
      gas = g;
      System.out.println("車のナンバーを"+num+"，ガソリン量を"+gas+"にしました");
    }
    else {
      System.out.println(g+"は正しいガソリン量ではありません");
      System.out.println("ガソリン量を変更できませんでした．");
    }
  }

  public void show(){
    System.out.println("車のナンバーは"+ num);
    System.out.println("ガソリン量は"+ gas);
  }
}

class TestClass{
  public static void main(String[] args) {
    Car car1 = new Car();

    car1.setNumGas(1234,32.0);
    //car1.num = 1234;
    //car1.gas = -10.0;
    car1.show();

    System.out.println("正しくないガソリン量(-10.0)を代入してみる");
    car1.setNumGas(1234,-10.0);
    car1.show();

    //System.out.println("サンプルから車を調べたところ");
    //System.out.println("ナンバーは"+number+"，ガソリン量は"+gasoline+"でした");
  }
}
