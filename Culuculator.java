import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.color.*; //ここで色の情報を追加した。
@SuppressWarnings("unchecked")

class Culuculator extends Frame implements MouseListener,MouseMotionListener,ActionListener {
  int x,y;
  int t,select;
  Vector<Figure> objList;
  CheckboxGroup cbg,cbg2; //色のチェックボックスを新たに追加したので２こ用意した。
  Checkbox c1,c2,c3,c4,c5,c6,c7,c8;
  Button end,reset; //リセットボタンを用いる
  int mode=0;
  Figure obj;
  public static void main(String args[]){
    Paint4 f=new Paint4();
    f.setSize(640,480);
    f.setTitle("Culuculator");
    f.addWindowListener(new WindowAdapter(){
      @Override public void windowClosing(WindowEvent e){
        System.exit(0);
      }});
    f.setVisible(true);

    if(args.length==1) f.load(args[0]);
  }
  Paint4(){
    objList=new Vector<Figure>();
    //
    cbg=new CheckboxGroup();
    c1=new Checkbox("丸",cbg,true);
    c2=new Checkbox("円",cbg,false);
    c3=new Checkbox("四角",cbg,false);
    c4=new Checkbox("線",cbg,false);
    cbg2=new CheckboxGroup(); //新規のチェックボックスを作成
    c5=new Checkbox("黒",cbg2,true);
    c6=new Checkbox("青",cbg2,false);
    c7=new Checkbox("黄色",cbg2,false);
    c8=new Checkbox("赤",cbg2,false);
    end=new Button("終了");
    reset=new Button("初期化");
    c1.setBounds(560,30,60,30);
    c2.setBounds(560,60,60,30);
    c3.setBounds(560,90,60,30);
    c4.setBounds(560,120,60,30);
    c5.setBounds(560,170,60,30);
    c6.setBounds(560,200,60,30);
    c7.setBounds(560,230,60,30);
    c8.setBounds(560,260,60,30);
    end.setBounds(560,330,60,30);
    reset.setBounds(560,360,60,30);
    setLayout(null);
    add(c1);
    add(c2);
    add(c3);
    add(c4);
    add(c5);
    add(c6);
    add(c7);
    add(c8);
    add(end);
    add(reset);
    //
    addMouseListener(this);
    addMouseMotionListener(this);
    //
    end.addActionListener(this);
    reset.addActionListener(this); //初期化ボタンを有効にするため追加
  }

  public void save(String fname){
		try{
			FileOutputStream fos=new FileOutputStream(fname);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(objList);
			oos.close();
			fos.close();
		} catch(IOException e){
		}
	}
	public void load(String fname){
		try{
			FileInputStream fis=new FileInputStream(fname);
			ObjectInputStream ois=new ObjectInputStream(fis);
			objList=(Vector<Figure>)ois.readObject();
			ois.close();
			fis.close();
		} catch(IOException e){
		} catch(ClassNotFoundException e){
		}
		repaint();
	}
	@Override public void paint(Graphics g){
		Figure f;
		for(int i=0; i<objList.size();i++){
			f=(Figure)objList.elementAt(i);
			f.paint(g);
		}
		if(mode>=1) obj.paint(g);
	}
	@Override public void actionPerformed(ActionEvent e){
		Object obj=e.getSource();
		if(obj==end){ //終了ボタンが押された時の挙動
			save("paint.dat"); //paint.datに今まで描画した図形を保存
			System.exit(0);
		}
		else if(obj==reset){ //初期化ボタンが押された時の挙動
			objList.clear();
			obj=null;
			repaint();
		}
	}
	public void mousePressed(MouseEvent e){
		Checkbox c;
		x=e.getX();
		y=e.getY();
		c=cbg2.getSelectedCheckbox(); //色を変えるための条件
		if(c==c5){
			t=1;
		} else if(c==c6){
			t=2;
		} else if(c==c7){
			t=3;
		} else if(c==c8){
			t=4;
		}
		obj=null;
		x=e.getX();
		y=e.getY();
		c=cbg.getSelectedCheckbox();
		obj=null;
		if(c==c1){
			mode=1;
			obj=new Ring(t); //色の引数tを代入
		} else if(c==c2){
			mode=2;
			obj=new Circle(t); //色の引数tを代入
		} else if(c==c3){
			mode=2;
			obj=new Box(t); //色の引数tを代入
		} else if(c==c4){
			mode=2;
			obj=new Line(t); //色の引数tを代入
		} if(obj != null){
			obj.moveto(x,y);
			repaint();
		}
	}
	public void mouseClicked(MouseEvent e){}
}
