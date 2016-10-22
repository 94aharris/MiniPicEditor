/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagehandlers;

import java.awt.image.BufferedImage;

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


