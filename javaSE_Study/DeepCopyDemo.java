import java.io.*;

/**
 * @author Komorebi
 * @since 2022.04.24.14:15
 */
public class DeepCopyDemo implements Serializable {

    //深拷贝
    public Object deepCopy() throws IOException, ClassNotFoundException {
        //序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
}
