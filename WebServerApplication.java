import java.io.IOException;

public class WebServerApplication {
    public static void main(String[] args) throws IOException{
        WebServer  webserver = new WebServer();
        System.out.println("Demarrage du serveur");
        webserver.run(80);
        
    }
}   