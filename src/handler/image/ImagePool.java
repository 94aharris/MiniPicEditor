package handler.image;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import handler.file.SaveType;

/**
 * @author Anthony Harris
 * @repository https://github.com/94aharris/MiniPicEditor
 */

public class ImagePool {
  ArrayList <ImageObject> images;
  public ImagePool() {
    images = new ArrayList<>();
  }
  
  public void addImage(File [] imageFiles) throws IOException {
    BufferedImage bimg = null;
    for (File file : imageFiles) {
      images.add(new ImageObject(ImageIO.read(file), file.getName()));
    }
  }
  
  public ArrayList<ImageObject> getImages() {
    return images;
}
  
  // Image manipulation code utilized from 
  // http://www.javalobby.org/articles/ultimate-image/#1
  // Originally Written by Josiah Hester (Java Lobby)
  public BufferedImage resizeImage(BufferedImage img, int newWidth, int newHeight) {
    int oldWidth = img.getWidth();
    int oldHeight = img.getHeight();
    BufferedImage dimg = dimg = new BufferedImage(newWidth, newHeight, img.getType());
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
  
  public void saveImage(BufferedImage img, String saveLocation, String fileName, SaveType saveFormat) throws IOException {
    String extension = "";
    switch(saveFormat) {
      case NATIVE : extension = (fileName.endsWith(".png")) ? "png" : "jpg";
        break;
      case PNG : extension = "png";
        break;
      case JPEG : extension = "jpg";
    }
    
    String[] splits = fileName.split("\\.");
    fileName = splits[0] + "_edited." + extension;
    ImageIO.write(img, extension, new File(saveLocation + "/" + fileName));
  }
  
  public void saveImage(BufferedImage img, String saveLocation, String fileName) throws IOException {
    saveImage(img, saveLocation, fileName, SaveType.NATIVE);
  }
}
