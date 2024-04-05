import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HttpRequest {
    String httpmethod;
    String url;
    public String request ="";
    Socket socket =new Socket();


    private void ReadClientRequest(Socket socket)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        String request=input.readLine();
            if(request!=null){
                String[] words = request.split(" ");
                if (words.length==3){
                    httpmethod= words[0];
                    url=words[1];
                }
            }
 
            
    }    

    public String getUrl(){
        return this.url;
    }

    public String getMethod(){
        return this.httpmethod;
    }

    public HttpRequest(Socket socket) throws IOException{
        this.socket=socket;
        ReadClientRequest(socket);
        
    }

    public String toString(){
        return "voici l'url "+url+" et la methode "+httpmethod;
    }

}
