import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

class HttpRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return  new HttpRoute();
    }
   @Test
    public  void fileIsExist() throws InterruptedException {
       Thread.sleep(5000);

   }

}