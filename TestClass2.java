class Car{
  public static int sum = 0;

  private int num;
  private double gas;

  public Car(){
    num = 0;
    gas = 0.0;
    //sum++;
    System.out.println("車を作成しました");
  }
  public void setCar(int n,double g){
    num = n;
    gas = g;
    System.out.println("ナンバーを"+num+"にガソリン量を"+gas+"にしました");
  }
  /*
  public static void showSum(){
    System.out.println("車は全部で"+sum+"台あります");
  }
  */
  public void show(){
    System.out.println("車のナンバーは"+num+"です");
    System.out.println("ガソリン量は"+gas+"です");
  }
}

class TestClass2{
  public static void main(String[] args) {

    Car car1;
    System.out.println("car1を宣言しました");
    car1 = new Car();
    car1.setCar(1234,20.5);

    Car car2;
    System.out.println("car2を宣言しました");

    car2 = car1;
    System.out.println("car2にcar1を代入しました");

    System.out.println("car1がさす");
    car1.show();
    System.out.println("car2がさす");
    car2.show();

    System.out.println("car1がさす車に変更を加える");
    car1.setCar(2345,33.4);

    System.out.println("car1がさす");
    car1.show();
    System.out.println("car2がさす");
    car2.show();
    /*
    Car.showSum();

    Car car1 = new Car();
    car1.setCar(124,23.4);


    Car.showSum();

    Car car2 = new Car();
    car2.setCar(4567,33.4);

    Car.showSum();
    */
  }
}
