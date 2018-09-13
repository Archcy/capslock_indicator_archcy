import javax.swing.*;
import java.awt.*;


public class show_popup {
    private JWindow jw = new JWindow();
    private int width=500,height=100,border=0; //button control
    private int y_1=50;
    private int fontsize=50;
    private JPanel Qs_panel = new JPanel();
    private JLabel Caps_icon = new JLabel();
    private Font uf_Big = new Font("SansSerif",1,fontsize);
    private float opca=0.3f;
    long time_dis=500;
    public void init_ind()
    {
        jw.setSize(width,height);
        jw.setOpacity(opca);
        jw.setAlwaysOnTop(true);
        jw.setLocationRelativeTo(null);
        Color Button_bgc = Color.darkGray;
        Color fg= Color.white;
        Qs_panel.setBackground(Button_bgc);
        Qs_panel.setVisible(true);
        Qs_panel.setBounds(border,border,width-border,height-border);
        Caps_icon.setBounds(0,0,width-border,height-border);
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
                jw.setOpacity(0.7f);
                jw.setVisible(true);
                Thread.currentThread().sleep(time_dis);
                jw.dispose();
                jw.setOpacity(opca);
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
