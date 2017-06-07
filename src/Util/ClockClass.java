/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Nikos
 */
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
 
public class ClockClass extends JFrame implements ActionListener
{
  public Timer clock;
  public int secs = 0;
  public int mins = 0;
  public int hrs = 0;
  public JLabel display;
  private DecimalFormat dFormat = new DecimalFormat("00");
 
  public ClockClass()
  {
    setTitle("My Clock");
    setLocation(20, 20);
    setSize(400, 400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    FlowLayout layout = new FlowLayout();
    setLayout(layout);
 
    display = new JLabel();
    add(display);
 
    clock = new Timer(1000, this);
    clock.setInitialDelay(0);  
    clock.start();
 
    setVisible(true);
  }
 
  public void actionPerformed(ActionEvent e)
  {
     
    if (e.getSource() == clock)
    {
      secs++;
    }
 
    if (secs == 60)
    {
      mins++;
      secs = 0;
      
    }
 
    if (mins == 60)
    {
      hrs++;
      mins = 0;
      secs = 0;
    }
 
    if (hrs == 24)
    {
      hrs = 0;
      mins = 0;
      secs = 0;
    }
    display.setText(
        dFormat.format(hrs) + ":" + 
        dFormat.format(mins) + ":" + 
        dFormat.format(secs));
  }
   
}