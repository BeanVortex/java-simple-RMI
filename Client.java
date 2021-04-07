package reflection.RMI;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 9876); Scanner scan = new Scanner(System.in)) {
            //Socket sck = socket.accept();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            System.out.println("Enter method name(add): ");
            String methodName = scan.nextLine();
            System.out.println("Enter Person's name: ");
            String personName = scan.nextLine();
            System.out.println("Enter Person's age: ");
            Integer personAge = scan.nextInt();
            Person newPerson = new Person(personName, personAge);

            oos.writeObject(methodName);
            Thread.sleep(1000);
            oos.writeObject(newPerson);
            List<Person> data = (ArrayList) ois.readObject();
            for (Person person : data)
                System.out.println("Person name: " + person.getName() + "\nPerson age: " + person.getAge());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
