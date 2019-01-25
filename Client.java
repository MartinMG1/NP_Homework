import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.Security;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

class TCP_echo_client {
    public static final int LISTENING_TCP_PORT = 3333;
    //public static final String LISTENING_IP_ADDRESS = "localhost";

    public static void main(String[] args) throws IOException {
        System.setProperty("javax.net.ssl.trustStore", "myTrustStore.jts");
        System.setProperty("javax.net.ssl.trustStorePassword", "mypasswd");

        System.out.println("Enter IP address of the server:");
        Scanner in = new Scanner(System.in);
        String ipAddress = in.next();
        try{
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket mySocket = (SSLSocket) sslsocketfactory.createSocket(ipAddress, LISTENING_TCP_PORT);
            System.out.println("Connected to echo server (" + mySocket.getInetAddress().getHostAddress() + ")");

            PrintWriter out = new PrintWriter(mySocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String sentence = reader.readLine();
            while ( !sentence.equals("END") ) {
                out.println(sentence);
                String response = input.readLine();
                System.out.println(response);
                sentence = reader.readLine();
            }
            out.println(sentence);      // send END to the server to notify them to close the cocket
        } catch (Exception ex){
            System.err.println("Error Happened : "+ex.toString());
        }
    }
}