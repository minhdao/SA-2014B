import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by minh on 7/16/14.
 * Program starts here
 * Threads and sockets for servers are created here
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        final CardTable ct = (CardTable) context.getBean("cardTable");
        ct.shuffer();

        try {
            ServerSocket ss = new ServerSocket(18888);
            while(true){
                final Socket server = ss.accept();

                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        try {
                            DataInputStream dis = new DataInputStream(server.getInputStream());
                            DataOutputStream dos = new DataOutputStream(server.getOutputStream());

                            String name = dis.readUTF();

                            if(ct.getPlayerNumber() < 4){
                                ct.addPlayer(new Player(name));
                                dos.writeUTF("Hello " + name + ". You are the player number " + ct.getPlayerNumber());
//                                server.close();
                            }else{
                                dos.writeUTF("Sorry " + name);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
