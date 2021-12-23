package restToMongo;

import activemqToDb.InsertProsessor;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public class RestApiToMysql extends RouteBuilder {

    public static final String DIRECT_GET_CORE = "direct:read";
    public static final String DIRECT_GET_CORE_SEARCH = "direct:search";
    public static final String ALL_MESSAGES = "select *from messages";
    public static final String DATA_SOURCE = "jdbc:myDataSource";

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("netty-http")
                .host("localhost")
                .port(8080)
                .bindingMode(RestBindingMode.json)
                .contextPath("")
                .enableCORS(true);


        rest("/v1/test")

                .get()
                .to(DIRECT_GET_CORE);

        rest()
                .get("/v2/test").param().name("txt").endParam()
                .to(DIRECT_GET_CORE_SEARCH);


        from(DIRECT_GET_CORE)
                .to("sql:" + ALL_MESSAGES)
                .to("log:?level=INFO&showBody=true")
                .end();

        from(DIRECT_GET_CORE_SEARCH)
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .process(exchange -> {
                    String txt = exchange.getIn().getHeader("txt", String.class);
                    String sql = "select * from messages where messages.message  like '"+txt+ "%'";
                    System.out.println("sql = " + sql);
                    exchange.getIn().setBody(sql);
                })
                .to(DATA_SOURCE)
                .to("log:?level=INFO&showBody=true")
                .end();
    }
}
