/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author aharris
 */
public class CropPanel extends JPanel{
  private static final int PREF_W = 200;
  private static final int PREF_H = 200;
  private static final Color DRAWING_COLOR = new Color(255, 100, 200);
  private static final Color FINAL_DRAWING_COLOR = Color.red;
   BufferedImage backgroundImg;
   private Point startPt = null;
   private Point endPt = null;
   private Point currentPt = null;

   public CropPanel() {
      this(new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB));
   }
   
   public CropPanel(BufferedImage image) {
    backgroundImg = new BufferedImage(200, 200, image.getType());
    Graphics2D g = backgroundImg.createGraphics();  
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
    g.drawImage(image, 0, 0, 200, 200, 0, 0, image.getWidth(), image.getHeight(), null);
    g.dispose();

      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      addMouseMotionListener(myMouseAdapter);
      addMouseListener(myMouseAdapter);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(backgroundImg, 0, 0, this);
      

      if (startPt != null && currentPt != null) {
         int x = Math.min(startPt.x, currentPt.x);
         int y = Math.min(startPt.y, currentPt.y);
         int width = Math.abs(startPt.x - currentPt.x);
         int height = Math.abs(startPt.y - currentPt.y);
         g.drawRect(x, y, width, height);
      }
   }
   

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
   

   public void drawToBackground() {
      Graphics g = backgroundImg.getGraphics();
      if ((startPt.x > 0 && startPt.y > 0) && (endPt.x < 250 && endPt.y < 250)) {
        int x = Math.min(startPt.x, endPt.x);
        int y = Math.min(startPt.y, endPt.y);
        int width = Math.abs(startPt.x - endPt.x);
        int height = Math.abs(startPt.y - endPt.y);
        g.drawRect(x, y, width, height); 
      }
      g.dispose();

      startPt = null;
      repaint();
   }
   
   private class MyMouseAdapter extends MouseAdapter {
      @Override
      public void mouseDragged(MouseEvent mEvt) {
         currentPt = mEvt.getPoint();
         CropPanel.this.repaint();
      }

      @Override
      public void mouseReleased(MouseEvent mEvt) {
         endPt = mEvt.getPoint();
         currentPt = null;
         //drawToBackground();
      }

      @Override
      public void mousePressed(MouseEvent mEvt) {
         startPt = mEvt.getPoint();
      }
   }
}