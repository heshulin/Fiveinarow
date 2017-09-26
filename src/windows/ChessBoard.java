package windows;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by HeShulin on 2017/9/20.
 */
public class ChessBoard extends JFrame implements MouseListener, Runnable {

    private JButton singlePlay;
    private int colorflag = 1;
    public synchronized void initColorFlag(int x){
        colorflag = x;
    }
    private BufferedImage background = null;
    private BufferedImage blackchess = null;
    private BufferedImage whitechess = null;
    private Point[][] CHESSBOARDEXPRESS = new Point[15][15];
    private int[][] CHESSMAN = new int[15][15];
    private Graphics g2 = null;
    private Graphics2D g = null;
    private JButton jButton1=null;
    public static JPanel GImage = null;
    private JLabel jlpic = new JLabel();
    //判断是否赢棋
    private boolean judgeWinner(int x,int y,int player){
        int num=0;
        //横向判断
        for(int i=x;i>=x-4;i--) {
            if(i<0||i>=15){
                continue;
            }
            if(CHESSMAN[i][y]==player){
                num++;
                if(num>=5){
                    return true;
                }
            }
            else{
                break;
            }
        }
        for(int i=x+1;i<=x+4;i++) {
            if(i<0||i>=15){
                continue;
            }
            if(CHESSMAN[i][y]==player){
                num++;
                System.out.println(num);
                if(num>=5){
                    return true;
                }
            }
            else{
                break;
            }
        }
        //纵向判断
        num=0;
        for(int i=y;i>=y-4;i--) {
            if(i<0||i>=15){
                continue;
            }
            if(CHESSMAN[x][i]==player){
                num++;
                if(num>=5){
                    return true;
                }
            }
            else{
                break;
            }
        }
        for(int i=y+1;i<=y+4;i++) {
            if(i<0||i>=15){
                continue;
            }
            if(CHESSMAN[x][i]==player){
                num++;
                if(num>=5){
                    return true;
                }
            }
            else{
                break;
            }
        }
        //左斜向判断
        num=0;
        for(int i=0;i<=4;i++) {
            if(x+i<0||x+i>=15||y+i<0||y+i>=15){
                continue;
            }
            if(CHESSMAN[x+i][y+i]==player){
                num++;
                if(num>=5){
                    return true;
                }
            }
            else{
                break;
            }
        }
        for(int i=1;i<=4;i++) {
            if(x-i<0||x-i>=15||y-i<0||y-i>=15){
                continue;
            }
            if(CHESSMAN[x-i][y-i]==player){
                num++;
                if(num>=5){
                    return true;
                }
            }
            else{
                break;
            }
        }
        //右斜向判断
        num=0;
        for(int i=0;i<=4;i++) {
            if(x+i<0||x+i>=15||y-i<0||y-i>=15){
                continue;
            }
            if(CHESSMAN[x+i][y-i]==player){
                num++;
                if(num>=5){
                    return true;
                }
            }
            else{
                break;
            }
        }
        for(int i=1;i<=4;i++) {
            if(x-i<0||x-i>=15||y+i<0||y+i>=15){
                continue;
            }
            if(CHESSMAN[x-i][y+i]==player){
                num++;
                if(num>=5){
                    return true;
                }
            }
            else{
                break;
            }
        }
        return false;
    }
    //改变下棋方
    public synchronized boolean change(){
        try{
            if(colorflag == 1){
                colorflag = 2;
            }else{
                colorflag = 1;
            }
            return true;
        }catch (Exception e) {
            return false;
        }

    }
    //初始化数据
    private void initData(){
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++) {
                CHESSBOARDEXPRESS[i][j] = new Point(100+j*60,100+i*60);
            }
        }
        for(int i = 0;i<15;i++){
            for(int j = 0;j<15;j++){
                CHESSMAN[i][j]=0;
            }
        }
    }
    //通过坐标得到棋盘上的点
    private Point getPos(int x,int y){
        for(int i = 0;i<15;i++){
            for(int j = 0;j<15;j++){
                if(x==(int)CHESSBOARDEXPRESS[i][j].getX()&&y==(int)CHESSBOARDEXPRESS[i][j].getY()){
                    return new Point(i,j);
                }
            }
        }
        return new Point(-1,-1);
    }

    JFrame jFrame = this;
    //初始化窗口
    public void initWindow(){
        //引入背景图
        try {
            background = ImageIO.read(getClass().getResource("background.jpg"));
            blackchess = ImageIO.read(getClass().getResource("blackchess.png"));
            whitechess = ImageIO.read(getClass().getResource("whitechess.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //init window
        this.setTitle("五子棋");
        this.setSize(1400, 1000);
        this.setResizable(false);// 设置窗口大小不可被改变
        this.setLocationRelativeTo(null);// 设置窗口初始在屏幕正中间
        //this.setIconImage(Toolkit.getDefaultToolkit().createImage("logo5.png"));// 给窗体添加一个图标
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置退出
        this.addMouseListener(this);// 加入鼠标监听器
        this.setVisible(true); // 设置窗口显示
        g = (Graphics2D)this.getGraphics();
    }
    //初始化棋盘
    public void initChessBoard(){
        this.g2 = background.createGraphics();
        this.g2.setColor(new Color(0,0,0));
        for(int i=0;i<15;i++){
            this.g2.drawLine(100+i*60,100,100+i*60,940);
            this.g2.drawLine(100,100+i*60,940,100+i*60);
        }
        initData();
        //棋盘上的定位点
        for(int i=3;i<=11;i=i+4){
            for(int j=3;j<=11;j=j+4){
                this.g2.fillRect((int)CHESSBOARDEXPRESS[i][j].getX()-5,(int)CHESSBOARDEXPRESS[i][j].getY()-5,10,10);
            }
        }
        initColorFlag(1);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.g.drawImage(background, 0, 0 ,this);

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //judge the range of the click event
        if(e.getY()>=100&&e.getY()<=940&&e.getX()>100&&e.getX()<=940) {
            int tmpx,tmpy;
            if ((e.getX() - ((e.getX() - 100) / 60 * 60 + 100)) > 30) {
                tmpx = (e.getX() - 100) / 60 * 60 + 160;
            } else {
                tmpx = (e.getX() - 100) / 60 * 60 + 100;
            }
            if ((e.getY() - ((e.getY() - 100) / 60 * 60 + 100)) > 30) {
                tmpy = (e.getY() - 100) / 60 * 60 + 160;
            } else {
                tmpy = (e.getY() - 100) / 60 * 60 + 100;
            }
            if (this.g==null){
                System.out.println("g == null");
                this.g = (Graphics2D) this.getGraphics();
            }
            Point tmppoint = getPos(tmpx,tmpy);
//            System.out.println((int)tmppoint.getX()+" "+(int)tmppoint.getY());
//            System.out.println(tmpx+" "+tmpy);
            if(colorflag==1&&CHESSMAN[(int)tmppoint.getX()][(int)tmppoint.getY()]==0){
                this.g.drawImage(blackchess,tmpx-25,tmpy-25,50,50,null);
                CHESSMAN[(int)tmppoint.getX()][(int)tmppoint.getY()] = 1;
                boolean win = judgeWinner((int)tmppoint.getX(),(int)tmppoint.getY(),1);
                if(win==true){
                    System.out.println("卡比兽获胜");
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "卡比兽获胜", "胜利信息", JOptionPane.PLAIN_MESSAGE);
                }
                change();
            }else if(colorflag==2&&CHESSMAN[(int)tmppoint.getX()][(int)tmppoint.getY()]==0) {
                this.g.drawImage(whitechess,tmpx-25,tmpy-25,50,50,null);
                CHESSMAN[(int)tmppoint.getX()][(int)tmppoint.getY()] = 2;
                boolean win = judgeWinner((int)tmppoint.getX(),(int)tmppoint.getY(),2);
                if(win==true){
                    System.out.println("杰尼龟获胜");
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "杰尼龟获胜", "胜利信息", JOptionPane.PLAIN_MESSAGE);
                }
                change();
            }

            System.out.println(tmpx + ":" + tmpy);
//测试
//            for(int i=0;i<15;i++){
//                for(int j=0;j<15;j++){
//                    System.out.print(CHESSMAN[i][j]+" ");
//                }
//                System.out.println("");
//            }

        }

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
