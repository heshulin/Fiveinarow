package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by HeShulin on 2017/9/27.
 */
public class ChooseFunction extends JFrame implements MouseListener, Runnable {

    public void initWindow(){
        //init window
        this.setTitle("内蒙古大学棋牌室");
        this.setSize(400, 300);
        this.setResizable(false);// 设置窗口大小不可被改变
        this.setLocationRelativeTo(null);// 设置窗口初始在屏幕正中间
        //this.setIconImage(Toolkit.getDefaultToolkit().createImage("logo5.png"));// 给窗体添加一个图
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置退出
        this.addMouseListener(this);// 加入鼠标监听器

        Container con=this.getContentPane();//生成一个容器
        //行列布局
        con.setLayout(new GridLayout(4,1));

        //第一行 静态文字
        JPanel pan1=new JPanel();
        JLabel title=new JLabel("欢迎来到内蒙古大学棋牌室");
        title.setFont(new Font("宋体",Font.BOLD, 20));
        pan1.add(title);
        con.add(pan1);

        //第二行 单人游戏
        JPanel pan2 = new JPanel();
        JButton singlePlay = new JButton("单  人  游  戏");
        pan2.add(singlePlay);
        con.add(pan2);



        //第三行 匹配游戏
        JPanel pan3 = new JPanel();
        JButton doublePlay = new JButton("匹配联机游戏");
        pan3.add(doublePlay);
        con.add(pan3);


        //第四行空行
        JPanel pan4 = new JPanel();
        con.add(pan4);

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
