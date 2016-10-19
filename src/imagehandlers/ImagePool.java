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
  
  public void addImage(File imageFile) throws IOException {
    BufferedImage bimg = null;
    bimg = ImageIO.read(imageFile);
    images.add(new ImageObject(bimg, imageFile.getName()));
    System.out.println("Added " + imageFile.getPath());
  }
  
  public ArrayList<ImageObject> getImages() {
    return images;
}
}
