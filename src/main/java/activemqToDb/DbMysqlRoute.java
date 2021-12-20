package activemqToDb;

import org.apache.camel.builder.RouteBuilder;

public class DbMysqlRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

       from("direct:dbInput")
               .to("log:?level=INFO&showBody=true")
               .process(new InsertProsessor())
               .to("jdbc:myDataSource")
               .to("sql:select * from messages")
               .to("log:?level=INFO&showBody=true");
    }
}
