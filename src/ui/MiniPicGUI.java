package ui;

import handler.image.ImageObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import handler.image.ImagePool;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import handler.file.SaveType;


/**
 * @author Anthony Harris
 * @repository https://github.com/94aharris/MiniPicEditor
 */

public class MiniPicGUI extends javax.swing.JFrame {
  
  ImagePool imagePool;
  int percentScale;
  int heightPx;
  int widthPx;
  boolean rescaleInterrupt;
  File saveLocation;
  SaveType selectedSave;
  CropPanel cropPanel;
  
  public MiniPicGUI() {
    imagePool = new ImagePool();
    percentScale = 100;
    heightPx = 0;
    widthPx = 0;
    initComponents();
    rescaleInterrupt = false;
    selectedSave = SaveType.NATIVE;
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    editedPreviewDiag = new javax.swing.JDialog();
    saveFormatBtnGroup = new javax.swing.ButtonGroup();
    cropEditDiag = new javax.swing.JDialog();
    acceptCropBtn = new java.awt.Button();
    cancelCropBtn = new java.awt.Button();
    cropEditFrame = new javax.swing.JInternalFrame();
    jProgressBar1 = new javax.swing.JProgressBar();
    photoScroll = new javax.swing.JScrollPane();
    photoList = new javax.swing.JList();
    saveLabel = new javax.swing.JLabel();
    saveTextField = new javax.swing.JTextField();
    savePathButton = new javax.swing.JButton();
    resizeSlider = new javax.swing.JSlider();
    resizeOptionsLabel = new javax.swing.JLabel();
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
    hgtSpinner = new javax.swing.JSpinner();
    wdtSpinner = new javax.swing.JSpinner();
    importedLabel = new javax.swing.JLabel();
    previewFrame = new javax.swing.JInternalFrame();
    previewResizeBtn = new javax.swing.JButton();
    saveOriginalBtn = new javax.swing.JRadioButton();
    savePngBtn = new javax.swing.JRadioButton();
    saveJpgBtn = new javax.swing.JRadioButton();
    selectedLabel = new javax.swing.JLabel();
    getCropBtn = new javax.swing.JButton();

    javax.swing.GroupLayout editedPreviewDiagLayout = new javax.swing.GroupLayout(editedPreviewDiag.getContentPane());
    editedPreviewDiag.getContentPane().setLayout(editedPreviewDiagLayout);
    editedPreviewDiagLayout.setHorizontalGroup(
      editedPreviewDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    editedPreviewDiagLayout.setVerticalGroup(
      editedPreviewDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
    );

    acceptCropBtn.setActionCommand("Accept Crop");
    acceptCropBtn.setLabel("Accept Crop");
    acceptCropBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        acceptCropBtnActionPerformed(evt);
      }
    });

    cancelCropBtn.setLabel("Cancel Crop");
    cancelCropBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelCropBtnActionPerformed(evt);
      }
    });

    cropEditFrame.setVisible(true);

    javax.swing.GroupLayout cropEditFrameLayout = new javax.swing.GroupLayout(cropEditFrame.getContentPane());
    cropEditFrame.getContentPane().setLayout(cropEditFrameLayout);
    cropEditFrameLayout.setHorizontalGroup(
      cropEditFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    cropEditFrameLayout.setVerticalGroup(
      cropEditFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 157, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout cropEditDiagLayout = new javax.swing.GroupLayout(cropEditDiag.getContentPane());
    cropEditDiag.getContentPane().setLayout(cropEditDiagLayout);
    cropEditDiagLayout.setHorizontalGroup(
      cropEditDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(cropEditDiagLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(cropEditDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(cropEditFrame)
          .addGroup(cropEditDiagLayout.createSequentialGroup()
            .addComponent(acceptCropBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
            .addComponent(cancelCropBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    cropEditDiagLayout.setVerticalGroup(
      cropEditDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cropEditDiagLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(cropEditFrame)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(cropEditDiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(cancelCropBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(acceptCropBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("MiniPic - LightWeight Photo Resize Tool");
    setBackground(java.awt.Color.lightGray);
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    setForeground(java.awt.Color.lightGray);
    setResizable(false);

    photoScroll.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

    photoList.setBorder(new javax.swing.border.MatteBorder(null));
    photoList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        photoListValueChanged(evt);
      }
    });
    photoScroll.setViewportView(photoList);

    saveLabel.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
    saveLabel.setText("Save To");

    saveTextField.setEditable(false);
    saveTextField.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N

    savePathButton.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
    savePathButton.setText("...");
    savePathButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        savePathButtonActionPerformed(evt);
      }
    });

    resizeSlider.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
    resizeSlider.setValue(percentScale);
    resizeSlider.setEnabled(false);
    resizeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        resizeSliderStateChanged(evt);
      }
    });

    resizeOptionsLabel.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
    resizeOptionsLabel.setText("Resize Image Options");

    percLbl.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
    percLbl.setText("Percentage");

    widthLbl.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
    widthLbl.setText("Width");

    heightLbl.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
    heightLbl.setText("Height");

    percSigLbl.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
    percSigLbl.setText("%");

    hgtPxLbl.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
    hgtPxLbl.setText("px");

    wdtPxLbl.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
    wdtPxLbl.setText("px");

    resizeBtn.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
    resizeBtn.setText("Resize and Save");
    resizeBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        resizeBtnActionPerformed(evt);
      }
    });

    aspectRatioChkBox.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
    aspectRatioChkBox.setSelected(true);
    aspectRatioChkBox.setText("Keep Aspect Ratio");
    aspectRatioChkBox.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        aspectRatioChkBoxStateChanged(evt);
      }
    });

    percentSpinner.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
    percentSpinner.setEnabled(false);
    percentSpinner.setRequestFocusEnabled(false);
    percentSpinner.setValue(percentScale);
    percentSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        percentSpinnerStateChanged(evt);
      }
    });

    importImagesBtn.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
    importImagesBtn.setText("Import Images");
    importImagesBtn.setInheritsPopupMenu(true);
    importImagesBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        importImagesBtnActionPerformed(evt);
      }
    });

    clearListBtn.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
    clearListBtn.setText("Clear Images");
    clearListBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        clearListBtnActionPerformed(evt);
      }
    });

    hgtSpinner.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
    hgtSpinner.setEnabled(false);
    hgtSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        hgtSpinnerStateChanged(evt);
      }
    });

    wdtSpinner.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
    wdtSpinner.setEnabled(false);
    wdtSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        wdtSpinnerStateChanged(evt);
      }
    });

    importedLabel.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
    importedLabel.setText("Imported Images");

    previewFrame.setPreferredSize(new java.awt.Dimension(250, 250));
    previewFrame.setVisible(true);

    javax.swing.GroupLayout previewFrameLayout = new javax.swing.GroupLayout(previewFrame.getContentPane());
    previewFrame.getContentPane().setLayout(previewFrameLayout);
    previewFrameLayout.setHorizontalGroup(
      previewFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 290, Short.MAX_VALUE)
    );
    previewFrameLayout.setVerticalGroup(
      previewFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 216, Short.MAX_VALUE)
    );

    previewResizeBtn.setText("Preview Resized Image");
    previewResizeBtn.setEnabled(false);
    previewResizeBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        previewResizeBtnActionPerformed(evt);
      }
    });

    saveFormatBtnGroup.add(saveOriginalBtn);
    saveOriginalBtn.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
    saveOriginalBtn.setSelected(true);
    saveOriginalBtn.setText("Original Format");
    saveOriginalBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveOriginalBtnActionPerformed(evt);
      }
    });

    saveFormatBtnGroup.add(savePngBtn);
    savePngBtn.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
    savePngBtn.setText(".png");
    savePngBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        savePngBtnActionPerformed(evt);
      }
    });

    saveFormatBtnGroup.add(saveJpgBtn);
    saveJpgBtn.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
    saveJpgBtn.setText(".jpg");
    saveJpgBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveJpgBtnActionPerformed(evt);
      }
    });

    selectedLabel.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
    selectedLabel.setText("Selected Image");

    getCropBtn.setText("Crop Image");
    getCropBtn.setEnabled(false);
    getCropBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        getCropBtnActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(heightLbl)
              .addComponent(percLbl)
              .addComponent(widthLbl))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(percentSpinner)
              .addComponent(hgtSpinner)
              .addComponent(wdtSpinner))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(percSigLbl)
              .addComponent(hgtPxLbl)
              .addComponent(wdtPxLbl))
            .addGap(346, 346, 346))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(photoScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(importedLabel)
              .addGroup(layout.createSequentialGroup()
                .addComponent(importImagesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clearListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(resizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addComponent(aspectRatioChkBox)
                .addGap(18, 18, 18)
                .addComponent(previewResizeBtn))
              .addComponent(resizeOptionsLabel))
            .addGap(29, 29, 29)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(saveOriginalBtn)
                .addGap(18, 18, 18)
                .addComponent(savePngBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveJpgBtn))
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                  .addComponent(saveLabel)
                  .addGap(18, 18, 18)
                  .addComponent(saveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(savePathButton))
                .addComponent(selectedLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(getCropBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addComponent(previewFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(17, Short.MAX_VALUE))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(importedLabel)
          .addComponent(selectedLabel))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(photoScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(previewFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(importImagesBtn)
          .addComponent(clearListBtn)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(getCropBtn)
            .addComponent(resizeBtn)))
        .addGap(18, 18, 18)
        .addComponent(resizeOptionsLabel)
        .addGap(7, 7, 7)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(resizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(percLbl)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(percentSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(percSigLbl)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(heightLbl)
                .addGap(16, 16, 16))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(hgtSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(hgtPxLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(widthLbl)
              .addComponent(wdtSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(wdtPxLbl))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(aspectRatioChkBox)
              .addComponent(previewResizeBtn)))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(saveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(saveLabel)
              .addComponent(savePathButton))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(saveOriginalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(savePngBtn)
              .addComponent(saveJpgBtn))))
        .addGap(5, 5, 5))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void savePathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePathButtonActionPerformed
    JFileChooser folderChooser;
    if (saveTextField.equals("")) {
      folderChooser = new JFileChooser(".");
    }
    else {
      folderChooser = new JFileChooser(saveTextField.getText());
    }
    folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    folderChooser.setAcceptAllFileFilterUsed(false);
    int result = folderChooser.showOpenDialog(folderChooser);
    if (result == JFileChooser.APPROVE_OPTION) {
      saveTextField.setText(folderChooser.getSelectedFile().getPath());
      saveLocation = folderChooser.getSelectedFile();
    }
  }//GEN-LAST:event_savePathButtonActionPerformed

  private void importImagesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importImagesBtnActionPerformed
    JFileChooser fileChooser = new JFileChooser(".");
    fileChooser.setMultiSelectionEnabled(true);
    FileFilter imageFilter = new FileNameExtensionFilter("Image Files", ImageIO.getReaderFileSuffixes());
    fileChooser.addChoosableFileFilter(imageFilter);
    fileChooser.setAcceptAllFileFilterUsed(false);
    
    int result = fileChooser.showOpenDialog(fileChooser);
    if (result == JFileChooser.APPROVE_OPTION) {
      editingEnabled(true);
      File [] selectedFiles = fileChooser.getSelectedFiles();
      try(Scanner sc = new Scanner(selectedFiles[0])) {
        imagePool.addImage(selectedFiles);
        photoList.setModel(new javax.swing.AbstractListModel () {
          ImageObject[] imageListArray = imagePool.getImages().toArray(new ImageObject [imagePool.getImages().size()]);
          public int getSize() { return imageListArray.length; }
          public Object getElementAt(int i) { return imageListArray[i]; }          
        });
        if (saveTextField.getText().equals("")) {
          saveTextField.setText(selectedFiles[0].getParent());
          saveLocation = selectedFiles[0].getParentFile();
        }
      }  catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Image can not be opened", "File Open Error", JOptionPane.ERROR_MESSAGE);
      } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Image can not be opened", "File Open Error", JOptionPane.ERROR_MESSAGE);
      } catch (NullPointerException e) {
        JOptionPane.showMessageDialog(null, "Error Pointing to File", "Image Open Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }//GEN-LAST:event_importImagesBtnActionPerformed

  private void clearListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearListBtnActionPerformed
    imagePool = new ImagePool();
    photoList.setModel(new javax.swing.AbstractListModel() {
      String[] strings = {};
      public int getSize() { return strings.length; }
      public Object getElementAt(int i) { return strings[i]; }
    });
    heightPx = 0;
    widthPx = 0;
    wdtSpinner.setValue(widthPx);
    hgtSpinner.setValue(heightPx);
    editingEnabled(false);
  }//GEN-LAST:event_clearListBtnActionPerformed

  private void resizeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_resizeSliderStateChanged
    percentScale = resizeSlider.getValue();
    percentSpinner.setValue(percentScale);
    
    if (photoList.getSelectedIndices().length == 1 && !rescaleInterrupt) {
      ImageObject selectedImage = (ImageObject) photoList.getSelectedValue();
      heightPx = (selectedImage.getHeight() * percentScale) / 100;
      widthPx = (selectedImage.getWidth() * percentScale) / 100;
      hgtSpinner.setValue(heightPx);
      wdtSpinner.setValue(widthPx);
    }
  }//GEN-LAST:event_resizeSliderStateChanged

  private void photoListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_photoListValueChanged
    resizeSlider.setValue(100);
    percentSpinner.setValue(100);
    previewResizeBtn.setEnabled(false);
    getCropBtn.setEnabled(false);
    
    int [] selectedImages = photoList.getSelectedIndices();
    if (selectedImages.length > 1) {
      aspectRatioChkBox.getModel().setSelected(true);
      aspectRatioChkBox.getModel().setEnabled(false);
      hgtSpinner.setEnabled(false);
      wdtSpinner.setEnabled(false);
    }
    else if (selectedImages.length == 1) 
    {
      previewResizeBtn.setEnabled(true);
      getCropBtn.setEnabled(true);
      ImageObject selectedImage = (ImageObject)photoList.getSelectedValue();
      aspectRatioChkBox.getModel().setEnabled(true);
      aspectRatioChkBox.getModel().setPressed(true);
      hgtSpinner.setEnabled(true);
      hgtSpinner.setValue(selectedImage.getHeight());
      wdtSpinner.setEnabled(true);
      wdtSpinner.setValue(selectedImage.getWidth());
      
      previewImage(selectedImage);
    }
    
  }//GEN-LAST:event_photoListValueChanged

  private void percentSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_percentSpinnerStateChanged
    if (rescaleInterrupt) {
      return;
    }
    
    rescaleInterrupt = true;
    if ((int)percentSpinner.getModel().getValue() < 100 && (int)percentSpinner.getModel().getValue() > 0) {
      percentScale = (int)percentSpinner.getModel().getValue();  
    }
    percentSpinner.setValue((int)percentScale);
    resizeSlider.setValue((int)percentScale);
    
    if (photoList.getSelectedIndices().length == 1) {
      ImageObject selectedImage = (ImageObject) photoList.getSelectedValue();
      heightPx = (selectedImage.getHeight() * percentScale) / 100;
      widthPx = (selectedImage.getWidth() * percentScale) / 100;
      hgtSpinner.setValue(heightPx);
      wdtSpinner.setValue(widthPx);
    }
    rescaleInterrupt = false;
  }//GEN-LAST:event_percentSpinnerStateChanged
  
  private void aspectRatioChkBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_aspectRatioChkBoxStateChanged
    resizeSlider.setEnabled(aspectRatioChkBox.getModel().isSelected());
    percentSpinner.setEnabled(aspectRatioChkBox.getModel().isSelected());
  }//GEN-LAST:event_aspectRatioChkBoxStateChanged

  private void resizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resizeBtnActionPerformed
    
    if (photoList.getSelectedIndices().length == 0) {
      JOptionPane.showMessageDialog(null, "Please Select A Photo", "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }
    
    if (heightPx == 0 || widthPx == 0) {
      JOptionPane.showMessageDialog(null, "Height and Width must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }
    
    for (Object item : photoList.getSelectedValuesList()) {
      BufferedImage newBimg = ((ImageObject)item).getImage();
      BufferedImage resizeImage;
      if (photoList.getSelectedIndices().length == 1) {
        resizeImage = imagePool.resizeImage(newBimg, widthPx, heightPx);
      }
      else {
        resizeImage = imagePool.resizeImage(newBimg, percentScale);
      }
      try {
        imagePool.saveImage(resizeImage, saveLocation.getPath(), ((ImageObject)item).toString(), selectedSave);
        JOptionPane.showMessageDialog(null, "Sucessfully Resized and Saved", "Success", JOptionPane.PLAIN_MESSAGE);
      } catch (NullPointerException e) {
        JOptionPane.showMessageDialog(null, "Invalid save file location", "File Save Error", JOptionPane.ERROR_MESSAGE);
      } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error during file saving", "File Save Error/n" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
      }
    }
  }//GEN-LAST:event_resizeBtnActionPerformed

  private void hgtSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hgtSpinnerStateChanged
    if (rescaleInterrupt) {
      return;
    }
    if ((int)hgtSpinner.getValue() < 1 || photoList.getSelectedIndices().length != 1) {
      hgtSpinner.setValue(heightPx);
      return;
    }
    
    heightPx = (int)hgtSpinner.getValue();
    if (aspectRatioChkBox.isSelected()) {
      ImageObject selectedImage = (ImageObject)photoList.getSelectedValue();
      rescaleInterrupt = true;
      percentSpinner.setValue((heightPx * 100) / selectedImage.getHeight());
      resizeSlider.setValue((int)percentSpinner.getValue());
      widthPx = (selectedImage.getWidth() * heightPx) / selectedImage.getHeight();
      wdtSpinner.setValue(widthPx);
      rescaleInterrupt = false;
    }
  }//GEN-LAST:event_hgtSpinnerStateChanged

  private void wdtSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_wdtSpinnerStateChanged
    if (rescaleInterrupt) {
      return;
    }
    
    if ((int)wdtSpinner.getValue() < 1 || photoList.getSelectedIndices().length != 1) {
      wdtSpinner.setValue(widthPx);
      return;
    }
    
    widthPx = (int)wdtSpinner.getValue();
    if (aspectRatioChkBox.isSelected()) {
      ImageObject selectedImage = (ImageObject)photoList.getSelectedValue();
      rescaleInterrupt = true;
      percentSpinner.setValue((widthPx * 100) / selectedImage.getWidth());
      resizeSlider.setValue((int)percentSpinner.getValue());
      heightPx = (selectedImage.getHeight() * widthPx) / selectedImage.getWidth();
      hgtSpinner.setValue(heightPx);
      rescaleInterrupt = false;
    }
  }//GEN-LAST:event_wdtSpinnerStateChanged

  private void previewResizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewResizeBtnActionPerformed
    ImageObject selectedImage = (ImageObject)photoList.getSelectedValue();
    BufferedImage previewImage = imagePool.resizeImage(selectedImage.getImage(), widthPx, heightPx);
    editedPreviewDiag.getContentPane().removeAll();
    editedPreviewDiag.getContentPane().setLayout(new BorderLayout());
    editedPreviewDiag.getContentPane().add(new JLabel(new ImageIcon(previewImage)));
    editedPreviewDiag.pack();
    editedPreviewDiag.setVisible(true);
  }//GEN-LAST:event_previewResizeBtnActionPerformed

  private void saveOriginalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveOriginalBtnActionPerformed
    selectedSave = SaveType.NATIVE;
  }//GEN-LAST:event_saveOriginalBtnActionPerformed

  private void savePngBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePngBtnActionPerformed
    selectedSave = SaveType.PNG;
  }//GEN-LAST:event_savePngBtnActionPerformed

  private void saveJpgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJpgBtnActionPerformed
    selectedSave = SaveType.JPEG;
  }//GEN-LAST:event_saveJpgBtnActionPerformed

  private void getCropBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getCropBtnActionPerformed
    ImageObject selectedImage = (ImageObject)photoList.getSelectedValue();
    cropPanel = new CropPanel(selectedImage.getImage());
    cropPanel.setFileName(selectedImage.toString());
    cropEditFrame.setContentPane(cropPanel);
    cropEditDiag.pack();
    cropEditDiag.setVisible(true);
  }//GEN-LAST:event_getCropBtnActionPerformed

  private void cancelCropBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelCropBtnActionPerformed
    cropEditDiag.setVisible(false);
  }//GEN-LAST:event_cancelCropBtnActionPerformed

  private void acceptCropBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptCropBtnActionPerformed
    BufferedImage croppedImage = cropPanel.getCroppedImage();
    ImageObject newImage = new ImageObject(croppedImage, cropPanel.getImageName());
    imagePool.addImage(newImage);
    photoList.setModel(new javax.swing.AbstractListModel () {
          ImageObject[] imageListArray = imagePool.getImages().toArray(new ImageObject [imagePool.getImages().size()]);
          public int getSize() { return imageListArray.length; }
          public Object getElementAt(int i) { return imageListArray[i]; }          
    });
    photoList.setSelectedIndex(photoList.getModel().getSize() -1);
  }//GEN-LAST:event_acceptCropBtnActionPerformed
  
  private void editingEnabled(boolean option) {
    wdtSpinner.setEnabled(option);
    hgtSpinner.setEnabled(option);
    resizeSlider.setEnabled(option);
    percentSpinner.setEnabled(option);
  }
  
  private void previewImage(ImageObject selectedImage) {
    previewFrame.getContentPane().removeAll();
    previewFrame.getContentPane().setLayout(new BorderLayout());
    previewFrame.getContentPane().add(new JLabel(new ImageIcon(selectedImage.getImage())));
    previewFrame.pack();
    previewFrame.setVisible(true);
  }
  
  
  
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
  private java.awt.Button acceptCropBtn;
  private javax.swing.JCheckBox aspectRatioChkBox;
  private java.awt.Button cancelCropBtn;
  private javax.swing.JButton clearListBtn;
  private javax.swing.JDialog cropEditDiag;
  private javax.swing.JInternalFrame cropEditFrame;
  private javax.swing.JDialog editedPreviewDiag;
  private javax.swing.JButton getCropBtn;
  private javax.swing.JLabel heightLbl;
  private javax.swing.JLabel hgtPxLbl;
  private javax.swing.JSpinner hgtSpinner;
  private javax.swing.JButton importImagesBtn;
  private javax.swing.JLabel importedLabel;
  private javax.swing.JProgressBar jProgressBar1;
  private javax.swing.JLabel percLbl;
  private javax.swing.JLabel percSigLbl;
  private javax.swing.JSpinner percentSpinner;
  private javax.swing.JList photoList;
  private javax.swing.JScrollPane photoScroll;
  private javax.swing.JInternalFrame previewFrame;
  private javax.swing.JButton previewResizeBtn;
  private javax.swing.JButton resizeBtn;
  private javax.swing.JLabel resizeOptionsLabel;
  private javax.swing.JSlider resizeSlider;
  private javax.swing.ButtonGroup saveFormatBtnGroup;
  private javax.swing.JRadioButton saveJpgBtn;
  private javax.swing.JLabel saveLabel;
  private javax.swing.JRadioButton saveOriginalBtn;
  private javax.swing.JButton savePathButton;
  private javax.swing.JRadioButton savePngBtn;
  private javax.swing.JTextField saveTextField;
  private javax.swing.JLabel selectedLabel;
  private javax.swing.JLabel wdtPxLbl;
  private javax.swing.JSpinner wdtSpinner;
  private javax.swing.JLabel widthLbl;
  // End of variables declaration//GEN-END:variables

}
