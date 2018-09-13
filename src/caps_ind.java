import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class caps_ind {

    private NoneFrame jw = new NoneFrame();
    private int width=50,height=50,border=0; //button control
    private int fontsize=35;
    private JPanel Qs_panel = new JPanel();
    private JLabel Caps_icon = new JLabel();
    private Font uf_Big = new Font("SansSerif",1,fontsize);
    boolean is_On = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
    GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(false);
    show_popup popup=new show_popup();

    public void init_ind()
    {

        Color Button_bgc = Color.darkGray;
        Color fg= Color.white;
        Qs_panel.setBackground(Button_bgc);
        Qs_panel.setVisible(true);
        Qs_panel.setBounds(border,border,width,height);
        Caps_icon.setBounds(0,0,width,height);
        Caps_icon.setForeground(fg);
        Caps_icon.setFont(uf_Big);
        Qs_panel.add(Caps_icon);
        jw.add(Qs_panel);
        popup.init_ind();
        if(is_On==true)
        {
            Caps_icon.setText("A");
        }
        else
        {
            Caps_icon.setText("a");
        }
    }

    public void show()
    {
        init_ind();

        keyboardHook.addKeyListener(new GlobalKeyAdapter() {
            @Override public void keyPressed(GlobalKeyEvent event) {
                if(event.getVirtualKeyCode()==GlobalKeyEvent.VK_CAPITAL )
                {
                    if(is_On==true)
                    {
                        Caps_icon.setText("a");
                        is_On=!is_On;
                        popup.change(is_On);
                    }
                    else
                    {
                        Caps_icon.setText("A");
                        is_On=!is_On;
                        popup.change(is_On);
                    }

                }
                jw.repaint(0,0,width,height);
            }
            @Override public void keyReleased(GlobalKeyEvent event) {

                }
        });


        jw.setVisible(true);
    }
}
