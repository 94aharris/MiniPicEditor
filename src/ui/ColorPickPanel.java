package ui;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;


public class ColorPickPanel extends JPanel {
  
  private static int prefW = 200;
  private static int prefH = 200;
  BufferedImage backgroundImg;
  BufferedImage rawImage;
  
  public ColorPickPanel() {
     this(new BufferedImage(prefW, prefH, BufferedImage.TYPE_INT_ARGB));
  }

  public ColorPickPanel(BufferedImage image) {
   rawImage = image;
   if (image.getWidth() > 600 || image.getHeight() > 600) {
     prefW = 600;
     prefH = 600;
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
  }
}

