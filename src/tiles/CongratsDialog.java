/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A dialog popped up at the end of the game
 * @author Nikos Pyrgiotis
 */
public class CongratsDialog extends JDialog {

    /**
     * 
     * @param relativeFrame the frame from which the dialog pops up
     */
    CongratsDialog(JFrame relativeFrame)
    {
        super(relativeFrame, "Congratulations!!!", false);                
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //it deletes the dialog        
       
       
        JPanel mainPanel = new JPanel(new BorderLayout());// the main Panel , contains the Panel that contains the JLabel and the Panel that contains the message
        mainPanel.setPreferredSize(new Dimension(440 , 352)); // pack method uses this to set the bounds of the frame or dialog(here dialog)
        
        JPanel iconPanel = new JPanel(new BorderLayout());
        ImageIcon icon = new ImageIcon("Images\\congrats.gif"); //the icon of the label
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setBounds(0, 0, 440, 302);
        iconPanel.add(iconLabel);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.BLACK);
        JLabel textLabel = new JLabel("Congratulations !!! You have WON !!!");        
        textLabel.setForeground(new Color(241, 184, 45));
        textLabel.setFont(new Font("Serif", Font.ITALIC, 25)); 
        
        panel.add(textLabel, BorderLayout.LINE_START);               
        mainPanel.add(iconPanel, BorderLayout.CENTER);
        mainPanel.add(panel, BorderLayout.SOUTH);
        super.add(mainPanel);
        
        super.pack();    //sets the dialog bounds to the specified dimension by mainPanel.PrefferedSize method
        super.setLocationRelativeTo(relativeFrame); //the dialog is shown near the frame from which we we called
        super.setResizable(false);
        super.setVisible(true);        
    }
    /**
     * It is not used. We could maybe add an Ok button
     * @param e the Action event which occured
     */    
}
