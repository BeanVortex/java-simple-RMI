package reflection.RMI;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket socket = new ServerSocket(9876)) {
            Socket sck = socket.accept();
            ObjectInputStream ois = new ObjectInputStream(sck.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(sck.getOutputStream());

            List<Person> data = new ArrayList<>();
            data.addAll(
                    List.of(new Person("P1", 10), new Person("P2", 12), new Person("P3", 15), new Person("P4", 18)));

            Class pClass = List.class;

            String mInvoke = (String) ois.readObject();
            Person p = (Person) ois.readObject();
            Method method = pClass.getMethod(mInvoke, Object.class);
            method.invoke(data, p);
            oos.writeObject(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
