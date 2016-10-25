package imagehandlers;
import java.awt.image.BufferedImage;

/**
 * @author Anthony Harris
 * @repository https://github.com/94aharris/MiniPicEditor
 */
public class ImageObject {
  
  BufferedImage bimg;
  String fileName;
  
  ImageObject (BufferedImage buffer, String name) {
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


