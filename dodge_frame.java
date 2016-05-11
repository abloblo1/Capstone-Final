import javax.swing.JFrame;
import java.awt.event.*;

public class dodge_frame extends JFrame
{
    private Dodge scene;
    
    public dodge_frame()
    {
        //adds the dodge object to the frame
        scene = new Dodge();
        add(scene);

        setSize(800, 330);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("DODGE THE BLOCKS BRO");
    }
} 