import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private Socket clientSocket;
    private ServerSocket serverSocket;

    void readRequest(Socket socket) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String request = "";
        int n=1;
    while(n!=0){
        request =input.readLine();
        if (request.equals((""))){
            n=0;
        }
        System.out.println(request);
        //System.out.println("A request has been received");
    }
    }
    void sendResponse(Socket socket) throws IOException{
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter((socket.getOutputStream())));
        output.write("ok\n");
        output.flush();
        System.out.println("A response has been emitted");
    }
    void run(int port ) throws IOException{
        ServerSocket serverSocket = new ServerSocket(port);
        while(true){
            Socket clientSocket = serverSocket.accept();

            readRequest(clientSocket);
            sendResponse(clientSocket);

            clientSocket.close();
        }
    }
}
