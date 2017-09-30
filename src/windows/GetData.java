package windows;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by HeShulin on 2017/9/27.
 */
public class GetData extends Thread {
    private Socket socketGetData = null;
    private Socket socketSendData = null;
    private Gson gson = new Gson();
    private JsonData jsonData = null;
//    private Listener listener = null;
//    private interface Listener{
//        void callback(JsonData jsonData);
//    }
//
    //此线程用于接收socket1的数据，向socket2发送数据
    GetData(Socket socket1,Socket socket2){
        socketGetData = socket1;
        socketSendData = socket2;
    }

    @Override
    public void run(){
        while(true){
            //未完成
            try {
                DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(socketGetData.getInputStream()));
                String tmpdata = null;
                tmpdata = dataInputStream.readUTF();
                PostData.sendData(socketSendData,tmpdata);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
