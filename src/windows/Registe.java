package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by HeShulin on 2017/9/23.
 */
public class Registe extends JFrame implements MouseListener, Runnable  {

    public void initWindow(){
        this.setTitle("注册");
        this.setSize(400,300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseListener(this);

        Container con=this.getContentPane();//生成一个容器
        con.setLayout(new GridLayout(7,1));

        JPanel jPanel1 = new JPanel();
        JLabel title = new JLabel("欢迎注册内蒙古大学棋牌室");
        title.setFont(new Font("宋体",Font.BOLD,20));
        jPanel1.add(title);
        con.add(jPanel1);

        JPanel nullLine1 = new JPanel();
        con.add(nullLine1);

        JPanel jPanel2 = new JPanel();
        JLabel userName = new JLabel("请输入用户名");
        JTextField inuserName = new JTextField(15);
        jPanel2.add(userName);
        jPanel2.add(inuserName);
        con.add(jPanel2);

        JPanel jPanel3 = new JPanel();
        JLabel passWord = new JLabel("请输入密    码");
        JPasswordField inpassWord = new JPasswordField(15);
        jPanel3.add(passWord);
        jPanel3.add(inpassWord);
        con.add(jPanel3);

        JPanel jPanel4 = new JPanel();
        JLabel repassWord = new JLabel("再次输入密码");
        JPasswordField reinpassWord = new JPasswordField(15);
        jPanel4.add(repassWord);
        jPanel4.add(reinpassWord);
        con.add(jPanel4);

        JPanel jPanel5 = new JPanel();
        JLabel hintText = new JLabel("");
        jPanel5.add(hintText);
        con.add(jPanel5);


        JPanel jPanel6 = new JPanel();
        JButton iamSure = new JButton("确 定");
        jPanel6.add(iamSure);
        con.add(jPanel6);


        this.setVisible(true);


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {

    }
}
