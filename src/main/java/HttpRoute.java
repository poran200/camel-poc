import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;

public class HttpRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:scheduler?period=120000")
                .log("HTTP Route started")
                .setHeader(Exchange.HTTP_METHOD).constant("GET")
                .to("http4://api.bittrex.com/api/v1.1/public/getcurrencies").logMask()
                .process(exchange -> {
                    Message copy = exchange.getMessage();
                    System.out.println(copy.getExchange().getExchangeId());
                })
                .log("Response : ${body}");

    }
    }

