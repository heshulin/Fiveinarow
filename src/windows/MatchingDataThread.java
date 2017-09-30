package windows;


import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by HeShulin on 2017/9/29.
 */
public class MatchingDataThread extends Thread{
    private Listener listener = null;
    private Gson gson = new Gson();
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    private Socket socket = null;

    public interface Listener{
        void callback(int colorFlag);
    }


    public void init(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        int colorFlag=-1;
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String tmpdata = null;
            tmpdata = dataInputStream.readUTF();
            JsonData sureColor = gson.fromJson(tmpdata,JsonData.class);
            if(sureColor.getDataId()==1){
                listener.callback(sureColor.getCharacter());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
