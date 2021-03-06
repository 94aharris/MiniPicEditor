
package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author aharris
 */
public class CropPanel extends JPanel{
  private static int prefW = 200;
  private static int prefH = 200;
  private static final Color DRAWING_COLOR = new Color(255, 100, 200);
  private static final Color FINAL_DRAWING_COLOR = Color.red;
  BufferedImage backgroundImg;
  BufferedImage rawImage;
  private String imageName = "empty";
  private Point startPt = null;
  private Point endPt = null;
  private Point currentPt = null;

  public CropPanel() {
     this(new BufferedImage(prefW, prefH, BufferedImage.TYPE_INT_ARGB));
  }

  public CropPanel(BufferedImage image) {
   rawImage = image;
   if (image.getWidth() > 600 || image.getHeight() > 600) {
     if (image.getWidth() >= image.getHeight()) {
       prefW = 600;
       prefH = (image.getHeight() * 600) / image.getWidth();
     }
     else {
       prefH = 600;
       prefW = (image.getWidth() * 600) / image.getHeight();
     }
   }
   else {
    prefW = image.getWidth();
    prefH = image.getHeight();
   }
   backgroundImg = new BufferedImage(prefW, prefH, image.getType());
   Graphics2D g = backgroundImg.createGraphics();  
   g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
   g.drawImage(image, 0, 0, prefW, prefH, 0, 0, image.getWidth(), image.getHeight(), null);
   g.dispose();

  MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
  addMouseMotionListener(myMouseAdapter);
  addMouseListener(myMouseAdapter);
  }

  @Override
  protected void paintComponent(Graphics g) {
     super.paintComponent(g);
     g.drawImage(backgroundImg, 0, 0, this);


     if (startPt != null && currentPt != null) {
        int x = Math.min(startPt.x, currentPt.x);
        int y = Math.min(startPt.y, currentPt.y);
        int width = Math.abs(startPt.x - currentPt.x);
        int height = Math.abs(startPt.y - currentPt.y);
        g.drawRect(x, y, width, height);
     }
  }
   

  @Override
  public Dimension getPreferredSize() {
     return new Dimension(prefW, prefH);
  }
   

  public void drawToBackground() {
     Graphics g = backgroundImg.getGraphics();
     if ((startPt.x > 0 && startPt.y > 0) && (endPt.x < 250 && endPt.y < 250)) {
       int x = Math.min(startPt.x, endPt.x);
       int y = Math.min(startPt.y, endPt.y);
       int width = Math.abs(startPt.x - endPt.x);
       int height = Math.abs(startPt.y - endPt.y);
       g.drawRect(x, y, width, height); 
     }
     g.dispose();

     startPt = null;
     repaint();
  }
  
  public void setFileName(String name) {
    imageName = name;
  }
  
  public String getImageName() {
    int lastDot = imageName.lastIndexOf('.');
    return (imageName.substring(0, lastDot) + "_cropped" + imageName.substring(lastDot));
  }
   
  public BufferedImage getCroppedImage() {
    if (rawImage == null || startPt == null) {
      return null;
    }
    int drawnX = Math.min(startPt.x, endPt.x);
    int drawnY = Math.min(startPt.y, endPt.y);
    int drawnWidth = Math.abs(startPt.x - endPt.x);
    int drawnHeight = Math.abs(startPt.y - endPt.y);

    double ratioX = rawImage.getWidth() / (double)backgroundImg.getWidth();
    double ratioY = rawImage.getHeight() / (double)backgroundImg.getHeight();

    int trueX = (int)(drawnX * ratioX);
    int trueY = (int)(drawnY * ratioY);
    int trueWidth = (int)(drawnWidth * ratioX);
    int trueHeight = (int)(drawnHeight * ratioY);
    BufferedImage subImg = rawImage.getSubimage(trueX, trueY, trueWidth, trueHeight);
    BufferedImage returnImage = new BufferedImage(subImg.getWidth(), subImg.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics g = returnImage.createGraphics();  
    g.drawImage(subImg, 0, 0, null);
    return returnImage; 
  }
   
   private class MyMouseAdapter extends MouseAdapter {
      @Override
      public void mouseDragged(MouseEvent mEvt) {
         currentPt = mEvt.getPoint();
         CropPanel.this.repaint();
      }

      @Override
      public void mouseReleased(MouseEvent mEvt) {
         endPt = mEvt.getPoint();
         currentPt = null;
         //drawToBackground();
      }

      @Override
      public void mousePressed(MouseEvent mEvt) {
         startPt = mEvt.getPoint();
      }
   }
}