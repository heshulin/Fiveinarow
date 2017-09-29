package windows;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Created by HeShulin on 2017/9/22.
 * 此类暂时废除
 */
public class Login extends JFrame implements MouseListener, Runnable {


    public void initWindow(){
        //init window
        this.setTitle("登录");
        this.setSize(400, 300);
        this.setResizable(false);// 设置窗口大小不可被改变
        this.setLocationRelativeTo(null);// 设置窗口初始在屏幕正中间
        //this.setIconImage(Toolkit.getDefaultToolkit().createImage("logo5.png"));// 给窗体添加一个图
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置退出
        this.addMouseListener(this);// 加入鼠标监听器

        Container con=this.getContentPane();//生成一个容器
        //行列布局
        con.setLayout(new GridLayout(7,1));

        //第一行 静态文字
        JPanel pan1=new JPanel();
        JLabel title=new JLabel("欢迎登陆内蒙古大学棋牌室");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        pan1.add(title);
        con.add(pan1);


        //空行
        JPanel pan2 = new JPanel();
        con.add(pan2);

        //第三行用户名和输入框
        JPanel pan3=new JPanel();//生成一个新的版面
        JLabel username=new JLabel("用户名");
        pan3.add(username);
        JTextField  tf_name=new JTextField (15);
        pan3.add(tf_name);
        con.add(pan3);

        //第四行密码和输入框
        JPanel pan4=new JPanel();//生成一个新的版面
        JLabel password = new JLabel("密     码");
        pan4.add(password);
        JPasswordField passWord=new JPasswordField(15);
        passWord.setEchoChar('*');
        pan4.add(passWord);
        con.add(pan4);

        //第五行空行
        JPanel pan5 = new JPanel();
        con.add(pan5);

        //第六行 登录 注册按钮
        JPanel pan6 = new JPanel();
        JButton loginButton = new JButton("登录");
        JLabel nullString = new JLabel("              ");
        JButton registeButton = new JButton("注册");
        pan6.add(loginButton);
        pan6.add(nullString);
        pan6.add(registeButton);
        con.add(pan6);

        //第七行空行
        JPanel pan7 = new JPanel();
        con.add(pan7);

        this.setVisible(true); // 设置窗口显示


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
