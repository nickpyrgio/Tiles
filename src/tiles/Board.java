/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/** 
 * Represents a State of the game
 * @author Nikos Pyrgiotis
 */


public final class Board extends JLayeredPane // extends JLayeredPane is not needed here , could have been JPanel...it is for educational reason :P
{
    
    private final int dimension; // the dimension of the board , we use 4 for the game
    private final JPanel background; // 
    private final Square[][] tiles;  //the array of the squares(two dimensional)
    private final int[][] terminalPos;  //the array of the value of squares that is a Terminal State
    private int mode;   // the game we will play. This is applied if we play with dimension == 4
    
    /**
     * 
     * @param dimension
     * @param mode 
     */
    protected Board(int dimension, int mode)
    {        
        this.mode = mode;
        this.dimension = dimension;
        tiles = new Square[dimension][dimension];
        terminalPos = new int[dimension][dimension];
        
        this.setVisible(true);
        this.setPreferredSize(new Dimension(630, 630));    //sets the bounds of (width, height), used by pack() method(not hear)
        this.background = new JPanel();
        this.background.setBorder(BorderFactory.createLineBorder(Color.BLACK, 15)); // the black border you see. it is 15 width
        this.background.setBackground(Color.DARK_GRAY);// cannot see it, it is the color of the background, just ignore :P
        this.background.setVisible(true);
        this.background.setBounds(0, 0, 630, 630);
        this.background.setLayout(new GridLayout(dimension, dimension, 3 , 3)); //grid Layout we use to put the squares on the board with a nice εμφάniση        
        
        //adds all the squares to the background JPanel. we do this so we can see them on screen
        for(int i = 0 ; i < tiles.length; i ++)
        {
            for(int j = 0; j < dimension; j++)
            {                               
                tiles[j][i] = new Square(-1, 600/dimension, 600/dimension);
                this.background.add(tiles[j][i]);
            }
        } 
        this.add(this.background);                      
        //add the backgriund JPanel to this (JLayeredPanel)
    } 
    
    /**
     * Initalises the board due to the board`s mode
     */
    public  void init()
    {
        int k;
        if(mode == 1)
        {
            k = 1;
            for(int i = 0 ; i < tiles.length; i ++)
            {
                for(int j = 0; j < dimension; j++)
                { 
                    if(k == dimension*dimension) 
                    {
                        terminalPos[j][i] = 0; 
                        tiles[j][i].setLabelText("");
                        tiles[j][i].setNum(0);
                        
                    }
                    else 
                    {
                        terminalPos[j][i] = k; 
                        tiles[j][i].setNum(k);
                        tiles[j][i].setLabelText(String.valueOf(k));
                        k++;
                    }                        
                }
            }             
        }
        else if(mode == 2)
        {
            k = 1;
            for(int i = 0 ; i < tiles.length; i ++)
            {
                for(int j = 0; j < dimension; j++)
                { 
                    if(k == dimension*dimension) 
                    {
                        terminalPos[i][j] = 0; 
                        tiles[i][j].setLabelText("");
                        tiles[i][j].setNum(0);                        
                    }
                    else 
                    {
                        terminalPos[i][j] = k; 
                        tiles[i][j].setNum(k);
                        tiles[i][j].setLabelText(String.valueOf(k));
                        k++;
                    }                        
                }
            }                         
        }
        else if(mode == 3)
        {
            tiles[0][0].setNum(7);
            tiles[0][0].setLabelText(String.valueOf(7));
            tiles[0][1].setNum(6);
            tiles[0][1].setLabelText(String.valueOf(6));
            tiles[0][2].setNum(5);
            tiles[0][2].setLabelText(String.valueOf(5));
            tiles[0][3].setNum(0);
            tiles[0][3].setLabelText("");
            
            tiles[1][0].setNum(8);
            tiles[1][0].setLabelText(String.valueOf(8));
            tiles[1][1].setNum(1);
            tiles[1][1].setLabelText(String.valueOf(1));
            tiles[1][2].setNum(4);
            tiles[1][2].setLabelText(String.valueOf(4));
            tiles[1][3].setNum(15);   
            tiles[1][3].setLabelText(String.valueOf(15));
            
            tiles[2][0].setNum(9);
            tiles[2][0].setLabelText(String.valueOf(9));
            tiles[2][1].setNum(2);
            tiles[2][1].setLabelText(String.valueOf(2));
            tiles[2][2].setNum(3);
            tiles[2][2].setLabelText(String.valueOf(3));
            tiles[2][3].setNum(14);                        
            tiles[2][3].setLabelText(String.valueOf(14));
            
            tiles[3][0].setNum(10);
            tiles[3][0].setLabelText(String.valueOf(10));            
            tiles[3][1].setNum(11);
            tiles[3][1].setLabelText(String.valueOf(11));            
            tiles[3][2].setNum(12);
            tiles[3][2].setLabelText(String.valueOf(12));            
            tiles[3][3].setNum(13);                                  
            tiles[3][3].setLabelText(String.valueOf(13));            
            for(int i = 0; i <this.dimension; i++)
            {            
                for(int j = 0; j < this.dimension; j++)
                {                
                    this.terminalPos[i][j] = this.tiles[i][j].getNum();
                }            
            }
        }
        else if(mode == 4)
        {
            tiles[0][0].setNum(1);
            tiles[0][0].setLabelText(String.valueOf(1));
            tiles[0][1].setNum(12);
            tiles[0][1].setLabelText(String.valueOf(12));
            tiles[0][2].setNum(11);
            tiles[0][2].setLabelText(String.valueOf(11));
            tiles[0][3].setNum(10);
            tiles[0][3].setLabelText(String.valueOf(10));
            
            tiles[1][0].setNum(2);
            tiles[1][0].setLabelText(String.valueOf(2));
            tiles[1][1].setNum(13);
            tiles[1][1].setLabelText(String.valueOf(13));
            tiles[1][2].setNum(0);
            tiles[1][2].setLabelText("");
            tiles[1][3].setNum(9);   
            tiles[1][3].setLabelText(String.valueOf(9));
            
            tiles[2][0].setNum(3);
            tiles[2][0].setLabelText(String.valueOf(3));
            tiles[2][1].setNum(14);
            tiles[2][1].setLabelText(String.valueOf(14));
            tiles[2][2].setNum(15);
            tiles[2][2].setLabelText(String.valueOf(15));
            tiles[2][3].setNum(8);                        
            tiles[2][3].setLabelText(String.valueOf(8));
            
            tiles[3][0].setNum(4);
            tiles[3][0].setLabelText(String.valueOf(4));            
            tiles[3][1].setNum(5);
            tiles[3][1].setLabelText(String.valueOf(5));            
            tiles[3][2].setNum(6);
            tiles[3][2].setLabelText(String.valueOf(6));            
            tiles[3][3].setNum(7);                                  
            tiles[3][3].setLabelText(String.valueOf(7));            
            for(int i = 0; i <this.dimension; i++)
            {            
                for(int j = 0; j < this.dimension; j++)
                {                
                    this.terminalPos[i][j] = this.tiles[i][j].getNum();
                }            
            }            
        }
        else if(mode == 5)
        {
            tiles[0][0].setNum(12);
            tiles[0][0].setLabelText(String.valueOf(12));
            tiles[0][1].setNum(7);
            tiles[0][1].setLabelText(String.valueOf(7));
            tiles[0][2].setNum(11);
            tiles[0][2].setLabelText(String.valueOf(11));
            tiles[0][3].setNum(0);
            tiles[0][3].setLabelText("");
            
            tiles[1][0].setNum(2);
            tiles[1][0].setLabelText(String.valueOf(2));
            tiles[1][1].setNum(9);
            tiles[1][1].setLabelText(String.valueOf(9));
            tiles[1][2].setNum(5);
            tiles[1][2].setLabelText(String.valueOf(5));
            tiles[1][3].setNum(14);   
            tiles[1][3].setLabelText(String.valueOf(14));
            
            tiles[2][0].setNum(1);
            tiles[2][0].setLabelText(String.valueOf(1));
            tiles[2][1].setNum(10);
            tiles[2][1].setLabelText(String.valueOf(10));
            tiles[2][2].setNum(6);
            tiles[2][2].setLabelText(String.valueOf(6));
            tiles[2][3].setNum(13);                        
            tiles[2][3].setLabelText(String.valueOf(13));
            
            tiles[3][0].setNum(15);
            tiles[3][0].setLabelText(String.valueOf(15));            
            tiles[3][1].setNum(4);
            tiles[3][1].setLabelText(String.valueOf(4));            
            tiles[3][2].setNum(8);
            tiles[3][2].setLabelText(String.valueOf(8));            
            tiles[3][3].setNum(3);                                  
            tiles[3][3].setLabelText(String.valueOf(3));            
            for(int i = 0; i <this.dimension; i++)
            {            
                for(int j = 0; j < this.dimension; j++)
                {                
                    this.terminalPos[i][j] = this.tiles[i][j].getNum();
                }            
            }   
        }
        else if(mode == 6)
        {
            k = dimension*dimension - 1;
            for(int i = 0 ; i < tiles.length; i ++)
            {
                for(int j = 0; j < dimension; j++)
                { 
                    if(k == 0) 
                    {
                        terminalPos[j][i] = 0; 
                        tiles[j][i].setLabelText("");
                        tiles[j][i].setNum(0);
                        
                    }
                    else 
                    {
                        terminalPos[j][i] = k; 
                        tiles[j][i].setNum(k);
                        tiles[j][i].setLabelText(String.valueOf(k));
                        k--;
                    }                        
                }
            }
        }        
    }
    
    
    /**
     * Sets the mode of the board <br>
     * 1 = horizontal <br>
     * 2 = vertical <br>
     * 3 = spiral <br>
     * 4 = peripheral <br>
     * 5 = adds to 30 <br>
     * 6 = impossible <br>
     * @param mode 
     */
    public void setMode(int mode)
    {
        this.mode = mode;
    }
    
    /**
     * Takes a x coordinate and calculates the width of the selected Square
     * @param x the x coordinate tha JFrame event mousPressed returns;
     * @return the row of the selected square
     */
    private int calcRow(int x)
    {
        int row = -1;        
                
        for(int i = 0; i < this.tiles.length; i++)
        {
            if(x >= 15+ i*(600/dimension)
            && x <= (610) )    
            {
                row = i;
            }
        }                         
        return row;
    }
    /**
     * Takes a y coordinate and calculates the height of the  selected Square
     * @param x the y coordinate tha JFrame event mousPressed returns;
     * @return the column of the selected square
     */
    private int calcColumn(int y)
    {
        int col = -1;
        for(int i = 0; i < this.tiles[0].length; i++)
        {                        
            if(y >= 15+ i*(600/dimension)
            && y <= (610) )    
            {
                col = i;
            }            
        }
        return col;
    }
    
    /**
     * Swaps randomly the squares in the board
     */
    protected void randomise()
    {
        Random r = new Random();
        int row1, row2, col1, col2;        
        for(int i = 0; i < 100;i++)
        {
            row1 = r.nextInt(this.dimension);
            row2 = r.nextInt(this.dimension);
            col1 = r.nextInt(this.dimension);
            col2 = r.nextInt(this.dimension);
            this.tiles[row1][col1].swapProperties(this.tiles[row2][col2]);
        }
    }
    
    /**
     * Swaps a square with empty tile if the move is valid
     * @param x The x coordinate that we take when mousPressed event occurs . Used to calculate the row of the selected square
     * @param y The y coordinate that we take when mousPressed event occurs . Used to calculate the column of the selected square
     * @return true if isValidMove, false otherwise
     */
    public boolean movePiece(int x, int y)
    {
        boolean checkRight;
        boolean checkLeft;
        boolean checkUp;
        boolean checkDown;
        int row = this.calcRow(x);
        int col = this.calcColumn(y);

        checkDown = col == this.dimension - 1? false : true; // Paw panw?
        checkUp= col == 0 ? false : true; // Paw katw?
        checkLeft  = row == 0? false : true; // Paw aristera?
        checkRight = row == this.dimension - 1? false : true; // Paw deksia?
                                     
        if(checkDown)
        {
            //System.out.println("Down " + this.tiles[row][col + 1].getNum());
            if(this.tiles[row][col + 1].getNum() == 0)
            {
                this.tiles[row][col + 1].swapProperties(this.tiles[row][col]);                
                return true;
            }
        }
        if(checkUp)
        {
            //System.out.println("Up" + this.tiles[row][col - 1].getNum());
            if(this.tiles[row][col - 1].getNum() == 0)
            {
                this.tiles[row][col - 1].swapProperties(this.tiles[row][col]);                
                return true;
            }
        } 
        if(checkLeft)
        {
            //System.out.println("Left " + this.tiles[row - 1][col].getNum());
            if(this.tiles[row - 1][col].getNum() == 0)
            {
                this.tiles[row - 1][col].swapProperties(this.tiles[row][col]);                
                return true;
            }
        }  
        if(checkRight)
        {
            //System.out.println("Right " + this.tiles[row + 1][col].getNum());
            if(this.tiles[row + 1][col].getNum() == 0)
            {
                this.tiles[row + 1][col].swapProperties(this.tiles[row][col]); 
                return true;
            }
        }                
         return false;
    }        
    
    /**
     * Decides if a State is terminal.Compares the values of the the tiles squares with the terminal array values
     * @return true if the state is terminal, false otherwise
     */
    public boolean isTerminal()
    {
        boolean isTerminal = false;            
        
        for(int i = 0; i <this.dimension; i++)
        {            
            for(int j = 0; j < this.dimension; j++)
            {                
                if(this.terminalPos[i][j] == this.tiles[i][j].getNum())
                    isTerminal = true;                      
                else
                { 
                    return  false;                    
                }
            }
        }
        return isTerminal;
    }
    
}
