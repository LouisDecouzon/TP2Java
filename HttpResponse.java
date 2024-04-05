import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HttpResponse {
    
    private Socket socket =new Socket();
    public  BufferedWriter output;


    public HttpResponse(Socket socket){
        this.socket=socket;
    }

    
    void ok(String message) throws IOException{
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter((socket.getOutputStream())));
        output.write("HTTP/1.0 "+String.valueOf(200)+" "+message+"\n\nhello world!\n");
        output.flush();
    }

    void notFound(String message)throws IOException{
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter((socket.getOutputStream())));
        output.write("HTTP/1.0 "+String.valueOf(404)+" "+message+"\n");
        output.flush();
    }


}
