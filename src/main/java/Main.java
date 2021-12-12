import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {


    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new HttpRoute());
        camelContext.start();
        Thread.sleep(5000);
        camelContext.stop();
    }
}
