package minipicprogram;

import ui.MiniPicGUI;

public class MiniPicProgram {

  public static void main(String[] args) {
    
    // Should place in try.. catch block with pop-up to indicate reson for
    // exception if one occurs
    MiniPicGUI startGui = new MiniPicGUI();
    startGui.setVisible(true);
  }
  
}
