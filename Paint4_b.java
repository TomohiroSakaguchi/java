import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.color.*; //ここで色の情報を追加した。
@SuppressWarnings("unchecked")

class Paint4 extends Frame implements MouseListener,MouseMotionListener,ActionListener{
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
		f.setTitle("Paint Sample");
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
		reset.setBounds(560,360,60,35);
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
    System.out.println("色のデータ"+c);
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
    System.out.println("図形データ"+c);
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
	public void mouseReleased(MouseEvent e){
// 		if(obj==reset){ //初期化ボタンが押されたときにすぐ消えるように条件分岐をいれた
// 			repaint();
// 		}
// 		else{
			x=e.getX();
			y=e.getY();
			if(mode==1)		obj.moveto(x,y);
			else if(mode==2)	obj.setWH(x-obj.x,y-obj.y);
			if(mode>=1){
				objList.add(obj);
				obj=null;
			}
			mode=0;
			repaint();
// 		}
	}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseDragged(MouseEvent e){
		x=e.getX();
		y=e.getY();
		if(mode==1){
			obj.moveto(x,y);
		} else if(mode==2){
			obj.setWH(x-obj.x,y-obj.y);
		}
		repaint();
	}
	public void mouseMoved(MouseEvent e){}
}
class Coord implements Serializable{
	int x,y;
	Coord(){
		x=y=0;
	}
	public void move(int dx,int dy){
		x+=dx;
		y+=dy;
	}
	public void moveto(int x,int y){
		this.x=x;
		this.y=y;
	}
}
class Figure extends Coord implements Serializable{
	int color;
	int w,h;
	int t,select;
	Figure(){
		color=0;
		w=h=0;
	}
	public void paint(Graphics g){}
	public void setWH(int w,int h){
		this.w=w;
		this.h=h;
	}
}
class Ring extends Figure implements Serializable{ //丸を描画するclass
	int size;
	Ring(int t){ //引数tがここにくる
		size=10;
		select=t; //selectに代入してtに影響が無いようにする
	}
	@Override public void paint(Graphics g){
		if(select==1){
			g.setColor(Color.black);
		} else if(select==2){
			g.setColor(Color.blue);
		} else if(select==3){
			g.setColor(Color.yellow);
		} else
			g.setColor(Color.red);
		g.drawOval(x-size/2,y-size/2,size,size);
	}
}
class Circle extends Figure implements Serializable{ //円を描画するclass
	Circle(int t){ //引数tがここにくる
		select=t; //selectに代入してtに影響が無いようにする
	}
	@Override public void paint(Graphics g){
		if(select==1){
			g.setColor(Color.black);
		} else if(select==2){
			g.setColor(Color.blue);
		} else if(select==3){
			g.setColor(Color.yellow);
		} else
			g.setColor(Color.red);
		int r=(int)Math.sqrt((double)(w*w+h*h));
		g.drawOval(x-r,y-r,r*2,r*2);
	}
}
class Box extends Figure implements Serializable{ //四角形を描画するclass
	Box(int t){ //引数tがここにくる
		select=t; //selectに代入してtに影響が無いようにする
	}
	@Override public void paint(Graphics g){
		if(select==1){
			g.setColor(Color.black);
		} else if(select==2){
			g.setColor(Color.blue);
		} else if(select==3){
			g.setColor(Color.yellow);
		} else
			g.setColor(Color.red);
		//四角形を描画する際、どの方向にも描画できるように調整
		if(w>0){
			if(h>0)
				g.drawRect(x,y,w,h);
			else
				g.drawRect(x,y+h,w,-h);
		}
		if(w<0){
			if(h>0)
				g.drawRect(x+w,y,-w,h);
			else
				g.drawRect(x+w,y+h,-w,-h);
		}
	}
}

class Line extends Figure implements Serializable{ //線を描画するためのclass
	Line(int t){ //引数tがここにくる
		select=t; //selectに代入してtに影響が無いようにする
	}
	@Override public void paint(Graphics g){
		if(select==1){
			g.setColor(Color.black);
		} else if(select==2){
			g.setColor(Color.blue);
		} else if(select==3){
			g.setColor(Color.yellow);
		} else
			g.setColor(Color.red);
		g.drawLine(x,y,x+w,y+h);
	}
}
