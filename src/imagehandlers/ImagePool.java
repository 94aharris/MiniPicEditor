/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagehandlers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author aharris
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
    return dimg;
  }
  
  public BufferedImage resizeImage (BufferedImage img, int percent) {
    int newHeight = (img.getHeight() * percent) / 100;
    int newWidth = (img.getWidth() * percent) / 100;
    return resizeImage(img, newHeight, newWidth);
  }
  
  public void saveImage(BufferedImage img, String saveLocation, String fileName) {
    try {
      System.out.println("Whut");
      String format = (fileName.endsWith(".png")) ? "png" : "jpg";
      String[] splits = fileName.split( "\\." );
      fileName = splits[0] + "_resized" + splits[1];
      ImageIO.write(img, format, new File(saveLocation + "\\" + fileName));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
