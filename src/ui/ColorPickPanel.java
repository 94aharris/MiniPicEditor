package ui;

import java.awt.Dimension;
import java.awt.Graphics;
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
    prefW = image.getWidth();
    prefH = image.getHeight();
   backgroundImg = new BufferedImage(prefW, prefH, image.getType());
   Graphics2D g = backgroundImg.createGraphics();  
   g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
   g.drawImage(image, 0, 0, prefW, prefH, 0, 0, image.getWidth(), image.getHeight(), null);
   g.dispose();
   System.out.println("Making");
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(backgroundImg, 0, 0, this); 
    System.out.println("Painting");
  }
  
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(prefW, prefH);
  }
  
  public void drawToBackground() {
    Graphics g = backgroundImg.getGraphics();
    g.dispose();
    repaint();
  }
}

