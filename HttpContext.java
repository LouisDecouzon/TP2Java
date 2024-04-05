import java.io.IOException;
import java.net.Socket;

public class HttpContext {

    private Socket socket= new Socket();
    public HttpResponse response;
    public HttpRequest request;

    public HttpContext(Socket socket) throws IOException{
        this.socket=socket;
        response =new HttpResponse(this.socket);
        request = new HttpRequest(this.socket);
        System.out.println(request);
    }
    public HttpRequest getRequest(){
        return request;    
    }
    
    public HttpResponse getResponse(){
        return response;
    }

    public void close(){
        try {
            this.socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
