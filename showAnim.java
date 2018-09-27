import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

class showAnim{
  public static void main(String[] args) {
    AppFrame f = new AppFrame();
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
  ImageFile imagefile;
  AppFrame(){ imagefile = new ImageFile("bane.raw");}
  @Override public void update(Graphics g){paint(g);}
  @Override public void paint(Graphics g){
    Image img = imagefile.loadNextFrame();
    if (img != null) {
      g.drawImage(img,10,50,480,360,this);
      repaint(1);
    }
  }
}

class ImageFile{
  BufferedInputStream biStream;
  BufferedImage bImage;
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
  Image loadNextFrame(){
    try {
      biStream.read(buf,0,160*120);
      int x,y,pixel;
      for (y=0; y<120; y++) {
        for (x=0; x<160; x++) {
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
