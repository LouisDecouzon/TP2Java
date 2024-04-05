import java.io.IOException;
import java.net.Socket;

public class RequestProcessor {
    private Socket socket =new Socket();
    HttpContext context;
    
    public RequestProcessor(Socket socket){
        this.socket=socket;
        try {
            context =new HttpContext(socket);        
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public void process() throws IOException{
        if(context.getRequest().getUrl().equals("/")){
            context.getResponse().ok("OK");
        }
        else{
            context.getResponse().notFound("NOt Found");
        }
    }
}
