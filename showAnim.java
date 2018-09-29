import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

class showAnim{
  public static void main(String[] args) {
    AppFrame f = new AppFrame(args[0]);
    f.setSize(640,480);
    f.addWindowListener(new WindowAdapter(){
      @Override public void windowClosing(WindowEvent e){
        System.exit(0);
      }
    });
    f.setVisible(true);
  }
}

class AppFrame extends Frame{
  private ImageFile imgfile;
  private ImageFile imgfile2;
  int num = 0;
  public AppFrame(String fname){ imgfile = new ImageFile(fname);
    imgfile2 = imgfile;
  }
  @Override public void update(Graphics g){paint(g);}
  @Override public void paint(Graphics g){
    Image img = imgfile2.loadNextFrame();
    if (img != null) {
      g.drawImage(img,10,100,480,360/2,this);
      repaint(1);
      num++;
    }
    else {
      System.out.println(num);
      System.exit(0);//流し終わったら終了
    }
  }
}

class ImageFile{
  private BufferedInputStream biStream;
  private BufferedImage bImage;
  byte buf[];
  ImageFile(String fname){
    buf = new byte[160*120];
    bImage = new BufferedImage(160,120,BufferedImage.TYPE_BYTE_GRAY);
    try {
      biStream = new BufferedInputStream(new FileInputStream(fname));
    }
    catch(Exception e) {
      System.err.println("Exception:"+e);
    }
  }
  public Image loadNextFrame(){
    try {
      biStream.read(buf,0,160*120);
      int x,y,pixel;
      for (y=(120-1); y>=0; y--) {
        for (x=(160-1); x>=0; x--) {
          pixel = (int)buf[y*160+x]*2;
          if (pixel < 0) {
            biStream.close();
            System.out.println("Done.");
            return null;
          }
          pixel = new Color(pixel,pixel,pixel).getRGB();
          bImage.setRGB(x,y,pixel);
        }
      }
    }
    catch(Exception e) {
      System.err.println("Exception:"+e);
    }
    return bImage;
  }
}
