package windows;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by HeShulin on 2017/9/29.
 */
public class PostData {
    private static PostData postData = null;
    public static synchronized  PostData getPostData(){
        if(postData==null){
            postData = new PostData();
        }
        return postData;
    }
    private PostData(){};
    public static boolean sendData(Socket socket,String jsonData){

        try {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(jsonData);
            dataOutputStream.flush();
            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
