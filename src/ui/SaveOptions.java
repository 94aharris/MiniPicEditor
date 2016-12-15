package ui;

import handler.file.SaveType;
import java.io.File;
import javax.swing.JFileChooser;

public class SaveOptions {
  private JFileChooser saveDialog;
  private SaveType outputType;
  private final int selectionMode = JFileChooser.DIRECTORIES_ONLY;
  private File saveLocation;
  
  public SaveOptions() {
    saveDialog = new JFileChooser(".");
    saveDialog.setFileSelectionMode(selectionMode);
    saveDialog.setAcceptAllFileFilterUsed(false);
    saveDialog.setDialogTitle("Select Save Location");
    outputType = SaveType.NATIVE;
  }
  
  public String selectDestination() {
    int dialogResult = saveDialog.showOpenDialog(saveDialog);
    if (dialogResult == JFileChooser.APPROVE_OPTION) {
      saveLocation = saveDialog.getSelectedFile();
      saveDialog.setCurrentDirectory(saveLocation);
    }
    if (saveLocation == null) {
      return saveDialog.getCurrentDirectory().getPath();
    }
    return saveLocation.getPath();
  }
  
  public String selectDestination(File defaultFolder) {
    if(!defaultFolder.isDirectory()) {
      saveLocation = new File(".");
      return saveLocation.getPath();
    }
    saveLocation = defaultFolder;
    saveDialog.setCurrentDirectory(saveLocation);
    return selectDestination();
  }
  
  public boolean isSaveLocationSet() {
    if (saveLocation == null) {
      return false;
    }
    return true;
  }
  
  // Optimally all setters and getter should be removed
  public String getSavePath() {
    return saveLocation.getPath();
  }
  
  public void setSaveType(SaveType type) {
    outputType = type;
  }
  
  public SaveType getSaveType() {
    return outputType;
  }
  
  
}
