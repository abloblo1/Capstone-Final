import javax.swing.JFrame;
import java.awt.event.*;

public class JumpFrame extends JFrame
{
    private JumpComponent scene;
//     class FrameWindowListener extends WindowAdapter
//     {
//         public void windowOpened(WindowEvent event)
//         {
//             scene.requestFocusInWindow();
//         }
//     }

    public JumpFrame()
    {
        scene = new JumpComponent();
        add(scene);

//         this.addWindowListener(new FrameWindowListener());

        setSize(800, 300);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
} 