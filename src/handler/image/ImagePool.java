package handler.image;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import handler.file.SaveType;
import ui.PhotoImporter;

public class ImagePool {
  private ArrayList <ImageObject> images;
  private PhotoImporter importer = new PhotoImporter();
  
  public ImagePool() {
    images = new ArrayList<>();
  }
  
  public void addImage(File [] imageFiles) throws IOException {
    for (File file : imageFiles) {
      images.add(new ImageObject(ImageIO.read(file), file.getName()));
    }
  }
  
  public void addImage(ImageObject newImage) {
    images.add(newImage);
  }
  
  public ArrayList<ImageObject> getImages() {
    return images;
}
  
  public void saveImage(BufferedImage img, String saveLocation, String fileName, SaveType saveFormat) throws IOException {
    String extension = "";
    switch(saveFormat) {
      case NATIVE : extension = (fileName.endsWith(".jpg")) ? "jpg" : "png";
        break;
      case PNG : extension = "png";
        break;
      case JPEG : extension = "jpg";
    }
    
    ImageIO.write(img, extension, new File(saveLocation + "/" + fileName));
  }
  
  public void saveImage(BufferedImage img, String saveLocation, String fileName) throws IOException {
    saveImage(img, saveLocation, fileName, SaveType.NATIVE);
  }
  
  public void importPhotos() throws IOException{
    File [] importedImages = importer.importPhotos();
    if (importedImages.length > 0) {
      addImage(importedImages);
    }
  }
  
  public javax.swing.AbstractListModel generateList() {
    return new javax.swing.AbstractListModel () {
          ImageObject[] imageListArray = images.toArray(new ImageObject [images.size()]);
          public int getSize() { return imageListArray.length; }
          public Object getElementAt(int i) { return imageListArray[i]; }          
        };
  }
  
  public void clearPool() {
    images.clear();
  }
}
