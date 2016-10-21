/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import imagehandlers.ImageObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import imagehandlers.ImagePool;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author aharris
 */
public class MiniPicGUI extends javax.swing.JFrame {
  
  ImagePool imagePool;
  int percentScale;
  int heightPx;
  int widthPx;
  
  public MiniPicGUI() {
    imagePool = new ImagePool();
    percentScale = 100;
    heightPx = 0;
    widthPx = 0;
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    photoScroll = new javax.swing.JScrollPane();
    photoList = new javax.swing.JList();
    photoScrollLabel = new javax.swing.JLabel();
    saveLabel = new javax.swing.JLabel();
    saveTextField = new javax.swing.JTextField();
    savePathButton = new javax.swing.JButton();
    resizeSlider = new javax.swing.JSlider();
    resizeOptionsLabel = new javax.swing.JLabel();
    hgtTxtField = new javax.swing.JTextField();
    wdtTxtField = new javax.swing.JTextField();
    percLbl = new javax.swing.JLabel();
    widthLbl = new javax.swing.JLabel();
    heightLbl = new javax.swing.JLabel();
    percSigLbl = new javax.swing.JLabel();
    hgtPxLbl = new javax.swing.JLabel();
    wdtPxLbl = new javax.swing.JLabel();
    resizeBtn = new javax.swing.JButton();
    aspectRatioChkBox = new javax.swing.JCheckBox();
    percentSpinner = new javax.swing.JSpinner();
    importImagesBtn = new javax.swing.JButton();
    clearListBtn = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("MiniPic - LightWeight Photo Resize Tool");
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

    photoList.setBorder(new javax.swing.border.MatteBorder(null));
    photoList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        photoListValueChanged(evt);
      }
    });
    photoScroll.setViewportView(photoList);

    photoScrollLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    photoScrollLabel.setText("Imported Photos");

    saveLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    saveLabel.setText("Save To");

    savePathButton.setText("...");
    savePathButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        savePathButtonActionPerformed(evt);
      }
    });

    resizeSlider.setValue(percentScale);
    resizeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        resizeSliderStateChanged(evt);
      }
    });

    resizeOptionsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    resizeOptionsLabel.setText("Resize Image Options");

    wdtTxtField.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseExited(java.awt.event.MouseEvent evt) {
        wdtTxtFieldMouseExited(evt);
      }
    });

    percLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    percLbl.setText("Percentage");

    widthLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    widthLbl.setText("Width");

    heightLbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    heightLbl.setText("Height");

    percSigLbl.setText("%");

    hgtPxLbl.setText("px");

    wdtPxLbl.setText("px");

    resizeBtn.setText("Resize");

    aspectRatioChkBox.setSelected(true);
    aspectRatioChkBox.setText("Keep Aspect Ratio");
    aspectRatioChkBox.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        aspectRatioChkBoxStateChanged(evt);
      }
    });

    percentSpinner.setRequestFocusEnabled(false);
    percentSpinner.setValue(percentScale);
    percentSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        percentSpinnerStateChanged(evt);
      }
    });

    importImagesBtn.setText("Import...");
    importImagesBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        importImagesBtnActionPerformed(evt);
      }
    });

    clearListBtn.setText("Clear");
    clearListBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        clearListBtnActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(photoScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(photoScrollLabel)
            .addGap(6, 6, 6)
            .addComponent(importImagesBtn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(clearListBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(resizeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(resizeOptionsLabel))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(resizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(aspectRatioChkBox))
              .addGroup(layout.createSequentialGroup()
                .addComponent(saveLabel)
                .addGap(40, 40, 40)
                .addComponent(saveTextField))
              .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(heightLbl)
                  .addComponent(percLbl)
                  .addComponent(widthLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(wdtTxtField)
                  .addComponent(hgtTxtField)
                  .addComponent(percentSpinner))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(hgtPxLbl)
                  .addComponent(wdtPxLbl)
                  .addComponent(percSigLbl))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(savePathButton)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(photoScrollLabel)
          .addComponent(resizeOptionsLabel)
          .addComponent(importImagesBtn)
          .addComponent(clearListBtn))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(resizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(percSigLbl)
                .addComponent(percLbl))
              .addComponent(percentSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(hgtTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(heightLbl)
              .addComponent(hgtPxLbl))
            .addGap(12, 12, 12)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(wdtTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(wdtPxLbl)
              .addComponent(widthLbl))
            .addGap(32, 32, 32)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(resizeBtn)
              .addComponent(aspectRatioChkBox))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(saveLabel)
              .addComponent(saveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(savePathButton)))
          .addComponent(photoScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void savePathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePathButtonActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_savePathButtonActionPerformed

  private void importImagesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importImagesBtnActionPerformed
    JFileChooser fileChooser = new JFileChooser(".");
    fileChooser.setMultiSelectionEnabled(true);
    FileFilter imageFilter = new FileNameExtensionFilter("Image Files", ImageIO.getReaderFileSuffixes());
    fileChooser.addChoosableFileFilter(imageFilter);
    fileChooser.setAcceptAllFileFilterUsed(false);
    
    int result = fileChooser.showOpenDialog(fileChooser);
    if (result == JFileChooser.APPROVE_OPTION) {
      
      File [] selectedFiles = fileChooser.getSelectedFiles();
      try(Scanner sc = new Scanner(selectedFiles[0])) {
        imagePool.addImage(selectedFiles);
        photoList.setModel(new javax.swing.AbstractListModel () {
          ImageObject[] imageListArray = imagePool.getImages().toArray(new ImageObject [imagePool.getImages().size()]);
          public int getSize() { return imageListArray.length; }
          public Object getElementAt(int i) { return imageListArray[i]; }          
        });
      }  catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Image can not be opened", "File Open Error", JOptionPane.ERROR_MESSAGE);
      } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Image can not be opened", "File Open Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }//GEN-LAST:event_importImagesBtnActionPerformed

  private void clearListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearListBtnActionPerformed
    imagePool = new ImagePool();
    photoList.setModel(new javax.swing.AbstractListModel() {
      String[] strings = { "<No Files Added Yet>" };
      public int getSize() { return strings.length; }
      public Object getElementAt(int i) { return strings[i]; }
    });
  }//GEN-LAST:event_clearListBtnActionPerformed

  private void resizeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_resizeSliderStateChanged
    percentScale = resizeSlider.getValue();
    percentSpinner.setValue(percentScale);
    
    if (photoList.getSelectedIndices().length == 1) {
      ImageObject selectedImage = (ImageObject) photoList.getModel().getElementAt(0);
      heightPx = (selectedImage.getHeight() * percentScale) / 100;
      widthPx = (selectedImage.getWidth() * percentScale) / 100;
      hgtTxtField.setText(heightPx + "");
      wdtTxtField.setText(widthPx + "");
    }
  }//GEN-LAST:event_resizeSliderStateChanged

  private void photoListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_photoListValueChanged
    resizeSlider.setValue(100);
    percentSpinner.setValue(100);
    
    int [] selectedImages = photoList.getSelectedIndices();
    if (selectedImages.length > 1) {
      aspectRatioChkBox.getModel().setSelected(true);
      aspectRatioChkBox.getModel().setEnabled(false);
      hgtTxtField.setEnabled(false);
      wdtTxtField.setEnabled(false);
    }
    else if (selectedImages.length == 1) {
      aspectRatioChkBox.getModel().setEnabled(true);
      aspectRatioChkBox.getModel().setPressed(true);
      hgtTxtField.setEnabled(true);
      hgtTxtField.setText(((ImageObject)photoList.getModel().getElementAt(selectedImages[0])).getHeight() + "");
      wdtTxtField.setEnabled(true);
      wdtTxtField.setText(((ImageObject)photoList.getModel().getElementAt(selectedImages[0])).getWidth() + "");
    }
    
  }//GEN-LAST:event_photoListValueChanged

  private void percentSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_percentSpinnerStateChanged
    if ((int)percentSpinner.getModel().getValue() < 100 && (int)percentSpinner.getModel().getValue() > 0) {
      percentScale = (int)percentSpinner.getModel().getValue();  
    }
    percentSpinner.setValue((int)percentScale);
    resizeSlider.setValue((int)percentScale);
    
    if (photoList.getSelectedIndices().length == 1) {
      ImageObject selectedImage = (ImageObject) photoList.getModel().getElementAt(0);
      heightPx = (selectedImage.getHeight() * percentScale) / 100;
      widthPx = (selectedImage.getWidth() * percentScale) / 100;
      hgtTxtField.setText(heightPx + "");
      wdtTxtField.setText(widthPx + "");
    }
  }//GEN-LAST:event_percentSpinnerStateChanged

  private void aspectRatioChkBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_aspectRatioChkBoxStateChanged
    resizeSlider.setEnabled(aspectRatioChkBox.getModel().isSelected());
    percentSpinner.setEnabled(aspectRatioChkBox.getModel().isSelected());
  }//GEN-LAST:event_aspectRatioChkBoxStateChanged

  private void wdtTxtFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wdtTxtFieldMouseExited
    if (photoList.getSelectedIndices().length == 1) {
      try {
        widthPx = Integer.parseInt(wdtTxtField.getText());
        ImageObject selectedImage = (ImageObject)photoList.getModel().getElementAt(0);
        heightPx = (widthPx * selectedImage.getHeight()) / selectedImage.getWidth();
        hgtTxtField.setText(heightPx + "");
        percentScale = (heightPx / (selectedImage.getHeight() * 100));
        resizeSlider.setValue(percentScale);
        percentSpinner.getModel().setValue(percentScale);
      } catch (NumberFormatException e) {hgtTxtField.setText("");}
    }
  }//GEN-LAST:event_wdtTxtFieldMouseExited

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(MiniPicGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(MiniPicGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(MiniPicGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MiniPicGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
        //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MiniPicGUI().setVisible(true);
      }
    });
  }
  

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JCheckBox aspectRatioChkBox;
  private javax.swing.JButton clearListBtn;
  private javax.swing.JLabel heightLbl;
  private javax.swing.JLabel hgtPxLbl;
  private javax.swing.JTextField hgtTxtField;
  private javax.swing.JButton importImagesBtn;
  private javax.swing.JLabel percLbl;
  private javax.swing.JLabel percSigLbl;
  private javax.swing.JSpinner percentSpinner;
  private javax.swing.JList photoList;
  private javax.swing.JScrollPane photoScroll;
  private javax.swing.JLabel photoScrollLabel;
  private javax.swing.JButton resizeBtn;
  private javax.swing.JLabel resizeOptionsLabel;
  private javax.swing.JSlider resizeSlider;
  private javax.swing.JLabel saveLabel;
  private javax.swing.JButton savePathButton;
  private javax.swing.JTextField saveTextField;
  private javax.swing.JLabel wdtPxLbl;
  private javax.swing.JTextField wdtTxtField;
  private javax.swing.JLabel widthLbl;
  // End of variables declaration//GEN-END:variables
}
