package internet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author Komorebi
 * @since 2022.07.24.17:31
 */
public class ReceiveData {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10086);
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        ds.receive(dp);
        //解析数据包
        String dataString = new String(dp.getData(),0,dp.getLength());
        System.out.println(dataString);
        ds.close();
    }
}
