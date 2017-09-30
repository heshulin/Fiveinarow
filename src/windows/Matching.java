package windows;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by HeShulin on 2017/9/29.
 */
public class Matching extends JFrame{
    private Socket socket=null;
    public void initWindow(){
        //init window
        this.setTitle("匹配");
        this.setSize(600, 400);
        this.setResizable(false);// 设置窗口大小不可被改变
        this.setLocationRelativeTo(null);// 设置窗口初始在屏幕正中间
        //this.setIconImage(Toolkit.getDefaultToolkit().createImage("logo5.png"));// 给窗体添加一个图
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置退出

        JLabel jLabel = new JLabel("             正在匹配。。。     ");
        jLabel.setFont(new Font("黑体",Font.BOLD, 30));
        this.add(jLabel);
        this.setVisible(true); // 设置窗口显示
        try{
            socket = new Socket("127.0.0.1",5417);
            MatchingDataThread matchingDataThread = new MatchingDataThread();
            matchingDataThread.init(socket);
            matchingDataThread.start();
            matchingDataThread.setListener(new MatchingDataThread.Listener() {
                @Override
                public void callback(int colorFlag) {
                    ChessBoard chessBoard = new ChessBoard();
                    chessBoard.initColorFlag(colorFlag);
                    chessBoard.initWindow();
                    chessBoard.initChessBoard(2,socket);
                    dispose();
                }
            });

        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

}
