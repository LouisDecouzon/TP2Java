import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private Socket clientSocket;
    private ServerSocket serverSocket;

    
    void run(int port ) throws IOException{
        ServerSocket serverSocket = new ServerSocket(port);
        while(true){
            Socket clientSocket = serverSocket.accept();
            RequestProcessor processor = new RequestProcessor(clientSocket);
            processor.process();
            
            clientSocket.close();
        }
    }
}
