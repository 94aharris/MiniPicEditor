package ui;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PhotoImporter {
  private JFileChooser importDialog;
  private FileFilter imageFilter;
  
  public PhotoImporter() {
    imageFilter = new FileNameExtensionFilter("Image Files", ImageIO.getReaderFileSuffixes());
    importDialog = new JFileChooser(".");
    importDialog.setMultiSelectionEnabled(true);
    importDialog.addChoosableFileFilter(imageFilter);
    importDialog.setAcceptAllFileFilterUsed(false);
  }
  
  public File[] importPhotos() {
    int importResult = importDialog.showDialog(importDialog, "Import Photos");
    if (!(importResult == JFileChooser.APPROVE_OPTION)) {
      return new File[0];
    }
    File[] selectedFiles = importDialog.getSelectedFiles();
    importDialog.setCurrentDirectory(selectedFiles[0].getParentFile());
    return selectedFiles;
  }
}
