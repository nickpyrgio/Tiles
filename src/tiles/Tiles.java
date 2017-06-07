/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Nikos Pyrgiotis
 * @version 1
 */
public class Tiles extends JFrame implements ActionListener,MouseListener , MouseMotionListener {  
    //https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html
    public static void main(String[] args) {
        Tiles tiles = new Tiles();
        tiles.showFrame();
    }        
    private final DecimalFormat dFormat = new DecimalFormat("00");
    private final Timer timer;
    private final JLabel timeLabel;
    private int secs = 0;
    private int mins = 0;
    private int hrs = 0;
    
    private final Board board;
    private JButton shuffleButton;
    private JPanel panel;    
    private boolean startGame = false;
    private JMenu menu;
    private JMenuBar menubar ;
    private JCheckBoxMenuItem horizontal;
    private JCheckBoxMenuItem vertical;
    private JCheckBoxMenuItem spiral;
    private JCheckBoxMenuItem peripheral;
    private JCheckBoxMenuItem addsToThirty;
    private JCheckBoxMenuItem impossible;    
    
    /*
     * Initialises the Tiles component elements and 
     * some other variables     
     */
    public Tiles()
    {
        super("TILES GAME");            
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        super.setResizable(false);
        super.setVisible(false);     
        this.timer = new Timer(1000, this);
        this.timeLabel = new JLabel();
        this.timeLabel.setHorizontalAlignment(JLabel.CENTER);
        this.timeLabel.setVerticalAlignment(JLabel.CENTER);               
        this.timeLabel.setFont(new Font("Serif", Font.ITALIC, 20)); 
        this.timeLabel.setText(
        this.dFormat.format(hrs) + ":" + 
        this.dFormat.format(mins) + ":" + 
        this.dFormat.format(secs));                
        this.board = new Board(4 , 1);
        this.board.init();
    }
     
    
    /**
     * adds menu components
     */
    private void menuGui()
    {
        this.menubar = new JMenuBar();
        this.menu = new JMenu("Choose Game");
        this.horizontal = new JCheckBoxMenuItem("HORIZONTAL");
        this.vertical = new JCheckBoxMenuItem("VERTICAL");
        this.spiral = new JCheckBoxMenuItem("SPIRAL");
        this.peripheral = new JCheckBoxMenuItem("PERIPHERAL");
        this.addsToThirty = new JCheckBoxMenuItem("ADDS TO 30");
        this.impossible = new JCheckBoxMenuItem("IMPOSSIBLE");   
        
        this.horizontal.addActionListener(this);
        this.vertical.addActionListener(this);
        this.spiral.addActionListener(this);
        this.peripheral.addActionListener(this);
        this.addsToThirty.addActionListener(this);
        this.impossible.addActionListener(this);
        
        this.horizontal.setSelected(true);
        this.menu.add(horizontal);
        this.menu.addSeparator();
        this.menu.add(vertical);
        this.menu.addSeparator();
        this.menu.add(spiral);
        this.menu.addSeparator();
        this.menu.add(peripheral);
        this.menu.addSeparator();
        this.menu.add(addsToThirty);
        this.menu.addSeparator();
        this.menu.add(impossible);        
        this.menu.addSeparator();
        
        this.menubar.add(menu);
        this.setJMenuBar(menubar);
    }
    
    /**
     * Shows the components on the screen 
     * 
     */
    public void showFrame()
    {       

        menuGui();
        this.shuffleButton = new JButton("Shuffle");   
        this.shuffleButton.addActionListener(this);
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(shuffleButton);
        
        this.panel = new JPanel(new BorderLayout());
        this.panel.setBounds(0, 0, 615, 615);
        
        this.panel.setPreferredSize(new Dimension(630, 645));
        this.panel.add(this.board,BorderLayout.CENTER);
        this.panel.add(buttonPanel,BorderLayout.PAGE_END);        
        
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        
        this.board.addMouseListener(this);
        
        this.add(panel, BorderLayout.SOUTH);           
        add(this.timeLabel, BorderLayout.NORTH);
        this.setVisible(true);  
        this.pack();
        this.setLocationRelativeTo(null);           
    }
     
    /**
     * Sets a JCheckBoxMenuItem setSelected method true
     * @param item The JCheckBoxMenuItem item thah setSelected method is set true
     */
    private void setIsChecked(JCheckBoxMenuItem item)
    {
        this.horizontal.setSelected(false);
        this.vertical.setSelected(false);
        this.spiral.setSelected(false);
        this.peripheral.setSelected(false);
        this.addsToThirty.setSelected(false);
        this.impossible.setSelected(false);
        
        item.setSelected(true);
    }
    
    /**
     * Stops and initialises counter(time)
     */
    private void initCounter()
    {        
        this.timer.stop();
        this.secs = 0;
        this.mins = 0; 
        this.hrs = 0;
        this.timeLabel.setText(
        this.dFormat.format(0) + ":" + 
        this.dFormat.format(0) + ":" + 
        this.dFormat.format(0));                   
    }

    /**
     * Listen to an eaction event.It listens to
     * all the components that have 
     * addActionListener(this)
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(this.timer))
        {
            this.secs++;
            if (this.secs == 60)
            {
              this.mins++;
              this.secs = 0;
            }

            if (this.mins == 60)
            {
              this.hrs++;
              this.mins = 0;
              this.secs = 0;
            }

            if (this.hrs == 24)
            {
              this.hrs = 0;
              this.mins = 0;
              this.secs = 0;
            } 
            this.timeLabel.setText(
            this.dFormat.format(this.hrs) + ":" + 
            this.dFormat.format(this.mins) + ":" + 
            this.dFormat.format(this.secs));
        }
        if(e.getSource().equals(this.shuffleButton))
        {
            this.initCounter();
            this.timer.setInitialDelay(1000);
            this.timer.start();            
            this.startGame = true; 
            this.board.randomise();            
        }
        if(e.getSource().equals(this.horizontal))
        {
            initCounter();
            this.board.setMode(1);
            board.init();
            this.startGame = false;
            this.setIsChecked(this.horizontal);
        }
        if(e.getSource().equals(this.vertical))
        {         
            initCounter();
            this.board.setMode(2);
            board.init();
            this.startGame = false;  
            this.setIsChecked(this.vertical);
        }
        if(e.getSource().equals(this.spiral))
        {     
            initCounter();
            this.board.setMode(3);
            board.init();
            this.startGame = false;                        
            this.setIsChecked(this.spiral);
        }        
        if(e.getSource().equals(this.peripheral))
        {    
            initCounter();
            this.board.setMode(4);
            board.init();
            this.startGame = false;                        
            this.setIsChecked(this.peripheral);
        }
        if(e.getSource().equals(this.addsToThirty))
        {    
            initCounter();
            this.board.setMode(5);
            board.init();
            this.startGame = false;                        
            this.setIsChecked(this.addsToThirty);
        }        
        if(e.getSource().equals(this.impossible))
        {         
            initCounter();
            this.board.setMode(6);
            board.init();
            this.startGame = false;            
            this.setIsChecked(this.impossible);
        }                
    }

    @Override
    public void mouseClicked(MouseEvent e) {   
        //do nothing

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(!this.startGame)
        {
            return;
        }
        Component c =  board.findComponentAt(e.getX(), e.getY());
        if (!(c instanceof JLabel) )
        {
            return;
        }
        //Piece parent = (Piece)c.getParent();
        this.board.movePiece(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(this.startGame)
        {            
            if(this.board.isTerminal())
            {                
                CongratsDialog aDialog = new CongratsDialog(this);                
                startGame = false;
                this.timer.stop();
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //do nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //do nothing
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //do nothing
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //do nothing
    }
        
}
