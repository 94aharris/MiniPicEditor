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
}
