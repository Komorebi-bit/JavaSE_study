package internet;

import java.io.IOException;
import java.net.*;

/**
 * @author Komorebi
 * @since 2022.07.24.16:59
 */
public class SendData {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("192.168.0.103");
        //数据报嵌套字
        DatagramSocket ds = new DatagramSocket();
        byte[] bytes = "hello world".getBytes();
        //数据包
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length,address,10086);
        ds.send(dp);
        ds.close();
    }
}
