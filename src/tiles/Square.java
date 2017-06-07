/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;

/**
 * Represents a square on the board used in the game
 * @author Nikos Pyrgiotis
 */
public class Square extends JPanel
{
    
    private int num;            //the number of the square 
    private final JLabel label;       //the label of the square
    
    /**Constructs a new Square
     * 
     * @param num Sets the number of te square with the value num, 0 <= num >=dimension -1
     * @param width Sets the width of the JPanel = width
     * @param height Sets the height of the JPanel = width
     */
    protected Square(int num, int width , int height)
    {        
       this.num = num;
       super.setLayout(new BorderLayout());
       super.setBounds(0,0, width, height);
       super.setPreferredSize(new Dimension(width, height));     
       label = new JLabel();            
       label.setForeground(new Color(241, 184, 45)); //Χρυσό Χρώμα το Text της JLabel
       label.setFont(new Font("Serif", Font.ITALIC, height/2));  //Font 
       label.setHorizontalAlignment(JLabel.CENTER); //  Ουσιαστικά το βάζει στο 
       label.setVerticalAlignment(JLabel.CENTER);   // κέντρο του JLabel το Text του JLabel
              
        if(num != 0)
        {   
            label.setText(String.valueOf(num)); //sets the Text of the JLabel
            //mona => aspra
            //zuga => kokkina
            
            if(num %2 == 0)
            {
                super.setBackground(new Color(100,0,0));
            }
            else
            {
                super.setBackground(new Color(250, 235, 215));
            }         
        }
        else
        {
            //kena mauro
            super.setBackground(Color.BLACK);
        }
         super.add(label);
    }
    
    /**
     * this swaps properties with aSquare Used when 
     * we "move" a square on the board
     * @param aSquare The Square that this swaps properties
     */
    public void swapProperties(Square aSquare)
    {                
        int temp = this.num;
        Color color = this.getBackground();        
        this.setBackground(aSquare.getBackground());
        this.setNum(aSquare.getNum());   
        
        if(this.num == 0)            
            this.setLabelText("");
        else 
            this.setLabelText(String.valueOf(num));  
        
        aSquare.setBackground(color);
        aSquare.setNum(temp);
        if(temp == 0) 
            aSquare.setLabelText("");
        else
            aSquare.setLabelText(String.valueOf(temp));
    }
    
    /**
     * Sets JLabel Text with the value of the param
     * @param aString The new value of the Text
     */
    public void setLabelText(String aString)
    {
        this.label.setText(aString);
    }
    
    /**
     * 
     * @return  the number of this square
     */
    public int getNum()
    {
        return this.num;
    }
    
    /**
     * Sets the number of the Square with the specified value
     * @param num the specified value :P
     */
    public void setNum(int num)
    {
        if(num == 0)
        {
            this.setBackground(Color.BLACK);
        }
        else if(num %2 == 0)
        {
            this.setBackground(new Color(100,0,0));
        }
        else
        {
            this.setBackground(new Color(250, 235, 215));
        }                 
        this.num = num;
    }           
    
}
