import com.sun.corba.se.spi.activation.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by minh on 7/16/14.
 * Program starts here
 * Threads and sockets for servers are created here
 */
public class Main {

    private static ArrayList<Thread> game = new ArrayList<Thread>();

    public static void main(String[] args) {
        Main m = new Main();

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        final CardTable ct = (CardTable) context.getBean("cardTable");
        ct.shuffer();

        try {
            ServerSocket ss = new ServerSocket(18888);
            for (int i = 0; ;i++){
                ct.addPlayer(new Player("name", ss.accept()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
