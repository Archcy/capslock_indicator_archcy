import javax.swing.*;
import java.awt.*;


public class show_popup {
    private JWindow jw = new JWindow();
    private int width=50,height=50,border=0; //button control
    private int fontsize=50;
    private JPanel Qs_panel = new JPanel();
    private JLabel Caps_icon = new JLabel();
    private Font uf_Big = new Font("SansSerif",1,fontsize);
    long time_dis=500;
    public void init_ind()
    {
        jw.setSize(500,200);
        jw.setOpacity(0.3f);
        jw.setAlwaysOnTop(true);
        jw.setLocationRelativeTo(null);
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
    }
    public void change(boolean is_On)
    {
        try{
            if(is_On)
            {
                Caps_icon.setText("CapsLock ON");
                jw.setVisible(true);
                Thread.currentThread().sleep(time_dis);
                jw.dispose();
            }
            else
            {
                Caps_icon.setText("CapsLock OFF");
                jw.setVisible(true);
                Thread.currentThread().sleep(time_dis);
                jw.dispose();
            }
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

    }
}
