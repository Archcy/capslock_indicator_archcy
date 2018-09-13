import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NoneFrame extends JWindow {


    private int width=50,height=50,border=0; //button control
    Point origin = new Point();
    Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
    private float opca=0.5f;
    public NoneFrame() {
        this.setSize(width, height);
        this.setLocation(scsize.width-width,scsize.height-height);
        this.setBackground(Color.darkGray);
        this.setAlwaysOnTop(true);
        this.setType(JFrame.Type.UTILITY);
        this.setOpacity(opca);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                origin=e.getPoint();
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getModifiers()==4)
                {
                    System.exit(0);
                }
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseDragged(MouseEvent e) {
                Point p = getLocation();
                setLocation(p.x+e.getX()-origin.x,p.y+e.getY()-origin.y);
            }
        });
    }
}
