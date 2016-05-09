import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class JumpComponent extends JComponent
{
    private Rectangle box;
    private Rectangle goal;
    private int x_cord;
    private int y_cord;
    public JumpComponent()
    {  
        box = new Rectangle(0,230,20,30);   
        goal = new Rectangle(760,236,15,15);
        this.setFocusable(true);
        this.addKeyListener(new KeyStrokeListener());
        this.x_cord = 0;
        this.y_cord = 230;
    }

    public void paintComponent(Graphics g)
    {  
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.green);
        g2.draw(box);
        g2.fill(box);
        g2.setColor(Color.blue);
        g2.draw(goal);
        g2.fill(goal);
    }

    public void moveCharacterTo(int x, int y)
    {
        box.setLocation(x, y);
        repaint();
        this.x_cord = x;
        this.y_cord = y;
    }

    public int character_x()
    {
        return x_cord;
    }

    public int character_y()
    {
        return y_cord;
    }

    public void moveCharacterBy(int dx, int dy)
    {
        box.translate(dx, dy);
        repaint();
        this.x_cord += dx;
        this.y_cord += dy;
    }

    class KeyStrokeListener implements KeyListener
    {
        public void keyPressed(KeyEvent event) 
        {
            String key = KeyStroke.getKeyStrokeForEvent(event).toString().replace("pressed ", ""); 
            if (key.equals("DOWN"))
            {
                moveCharacterBy(0, 10);            
            }
            else if (key.equals("UP"))
            {
                moveCharacterBy(0, -10);            
            }
            else if (key.equals("LEFT"))
            {
                moveCharacterBy(-10, 0);            
            }
            else if (key.equals("RIGHT"))
            {
                moveCharacterBy(10, 0);            
            }
        }

        public void keyTyped(KeyEvent event) {}

        public void keyReleased(KeyEvent event) {}
    }
}































