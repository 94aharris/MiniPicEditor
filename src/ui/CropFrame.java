/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import java.awt.Color;
import java.awt.Graphics; 
import java.awt.Rectangle; 
import java.awt.Robot; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
import java.awt.event.MouseMotionListener; 
import javax.swing.JFrame;
import javax.swing.JInternalFrame;


/**
 *
 * @author aharris
 */
public class CropFrame extends JInternalFrame implements MouseListener, MouseMotionListener{
  
  private int startX, startY, endX, endY;
  CropFrame () {
    addMouseListener(this);
    addMouseMotionListener(this);
  }
  
  @Override
  public void mouseClicked(MouseEvent e) {
    
  }

  @Override
  public void mousePressed(MouseEvent e) {
    startX = e.getX();
    startY = e.getY();
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    endX = e.getX();
    endY = e.getY();
    repaint();
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    
  }

  @Override
  public void mouseExited(MouseEvent e) {
    
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    endX = e.getX();
    endY = e.getY();
    repaint();
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    
  }
  
  @Override
  public void paintComponent (Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.red);
    int x = (startX < endX) ? startX : endX;
    int y = (startY < endY) ? startY : endY;
    int width = endX - startX + 1;
    if (width < 0) {
      width = -width;
    }
    int height = endY - startY + 1;
    if (height < 0) {
      height = -height;
    }
    g.drawRect(x, y, width, height);
    System.out.println("Drawing");
  }
}
