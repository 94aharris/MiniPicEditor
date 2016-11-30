package handler.image;
import java.awt.image.BufferedImage;

public class ImageObject {
  
  BufferedImage bimg;
  String fileName;
  
  public ImageObject (BufferedImage buffer, String name) {
    bimg = buffer;
    fileName = name;
  }
  
  public String toString() {
    return fileName;
  }
  
  public int getHeight () {
    return bimg.getHeight();
  }
  
  public int getWidth () {
    return bimg.getWidth();
  }
  
  public BufferedImage getImage() {
    return bimg;
  }
}


