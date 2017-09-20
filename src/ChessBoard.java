import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by HeShulin on 2017/9/20.
 */
public class ChessBoard extends JFrame implements MouseListener, Runnable {



    public void initChessBoard(){
        //init window
        this.setTitle("五子棋");
        this.setSize(1300, 900);
        this.setResizable(false);// 设置窗口大小不可被改变
        this.setLocationRelativeTo(null);// 设置窗口初始在屏幕正中间
        //this.setIconImage(Toolkit.getDefaultToolkit().createImage("logo5.png"));// 给窗体添加一个图标
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置退出
        this.addMouseListener(this);// 加入鼠标监听器
        this.setVisible(true); // 设置窗口显示



    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

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
