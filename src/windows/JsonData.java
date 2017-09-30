package windows;

import java.awt.*;

/**
 * Created by HeShulin on 2017/9/29.
 */
public class JsonData {
    //0 空状态
    //1 确认角色
    //2 准备
    //3 下子
    //4 胜利
    private int dataId;

    private Point point;
    private String msg;

    //1黑棋
    //2白棋
    private int character;

    /**
     *
     * @param dataId
     * @param point
     * @param msg
     * @param character
     */
    JsonData(int dataId,Point point,String msg,int character){
        this.dataId = dataId;
        this.point = point;
        this.msg = msg;
        this.character = character;
    }

    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCharacter() {
        return character;
    }

    public void setCharacter(int character) {
        this.character = character;
    }

}
