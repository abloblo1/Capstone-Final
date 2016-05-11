import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.*;
import java.util.Random;

public class Dodge extends JComponent 
{
    private int windowWidth = 800;
    private int windowHeight = 330;
    private Rectangle box;
    private Rectangle goal;
    private Rectangle obstacle;
    private int randNumb = 0;
    private int squareWidth = 25;
    private int squareHeight = 25;
    private int squareYLocation = -squareWidth;
    private boolean numberCreated = false;
    private int counter;

    public Dodge()
    {
        //creates the new objects of the character and the goal
        box = new Rectangle(5,258,20,30);   
        goal = new Rectangle(760,266,15,15);
        this.setFocusable(true);
        //creates the keylistener
        this.addKeyListener(new KeyStrokeListener());
        //Score
        counter = 0;
    }

    public void generateRandomNumber() 
    {
        //generates a random number 
        Random rand = new Random();
        randNumb = rand.nextInt(windowWidth - squareWidth) + 30;
        numberCreated = true;
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.fillRect(0, 0, windowWidth, windowHeight);
        g2.setColor(Color.BLUE);
        obstacle = new Rectangle(randNumb, squareYLocation, squareWidth, squareHeight);
        g2.fill(obstacle);
        g2.setColor(Color.green);
        g2.draw(box);
        g2.fill(box);
        g2.setColor(Color.red);
        g2.draw(goal);
        g2.fill(goal);
        g2.setColor(Color.white);
        g2.drawString(counter + "", 10,10);
        
        if (!numberCreated) 
        {
            generateRandomNumber();
        }
        //moves the squares y coordinate towards the bottom of the screen and stops once it hits the bottom
        if (squareYLocation <= windowHeight) 
        {
            squareYLocation++;
            //resets the x and y location to a new position
        } 
        else 
        {
            numberCreated = false;
            squareYLocation = -squareHeight;
        }

        if(box.intersects(goal))
        {
            //if the character is touching the goal, teleport back to start and add 10 to score
            this.moveCharacterTo(5,258);
            counter += 10;
        }
        
        if(box.intersects(obstacle))
        {
            //if the character is hit by an obstacle, teleport back to start and subtract 10 from score
            this.moveCharacterTo(5,258);
            counter -= 10;
        }

        repaint();
    }

    public void moveCharacterTo(int x, int y)
    {
        //moves the character to a set location
        box.setLocation(x, y);
        repaint();
    }

    public void moveCharacterBy(int dx, int dy)
    {
        //translates the character by a certain amount in one direction
        box.translate(dx, dy);
        repaint();
    }

    class KeyStrokeListener implements KeyListener
    {
        public void keyPressed(KeyEvent event) 
        {
            String key = KeyStroke.getKeyStrokeForEvent(event).toString().replace("pressed ", ""); 
            if (event.getKeyCode() == KeyEvent.VK_LEFT)
            {
                //moves the character left
                moveCharacterBy(-10, 0);   
            }
            else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                //moves the character right
                moveCharacterBy(10, 0);   
            }
        }

        public void keyTyped(KeyEvent event) {}

        public void keyReleased(KeyEvent event) {}
    }
}