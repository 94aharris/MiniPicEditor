package handler.image;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ImageResizer {
  
  public ImageResizer() {
    
  }
  
  public BufferedImage resizeImage(BufferedImage img, int newWidth, int newHeight) {
    int oldWidth = img.getWidth();
    int oldHeight = img.getHeight();
    BufferedImage dimg = new BufferedImage(newWidth, newHeight, img.getType());
    Graphics2D g = dimg.createGraphics();  
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
    g.drawImage(img, 0, 0, newWidth, newHeight, 0, 0, oldWidth, oldHeight, null);  
    g.dispose();  
    return dimg;
  }
  
  public BufferedImage resizeImage (BufferedImage img, int percent) {
    int newHeight = (img.getHeight() * percent) / 100;
    int newWidth = (img.getWidth() * percent) / 100;
    return resizeImage(img, newWidth, newHeight);
  }
  
  public BufferedImage resizeImage (ImageObject img, int percent) {
    return resizeImage(img.getImage(), percent);
  }
  
  public BufferedImage resizeImage (ImageObject img, int width, int height) {
    return resizeImage(img.getImage(), width, height);
  }
}
