package activemqToDb;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class InsertProsessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String input = exchange.getIn().getBody(String.class);
        System.out.println("input = " + input);
        String sql = "INSERT INTO messages(id,message) VALUES('1','"+input+"')";
        System.out.println("sql = " + sql);
        exchange.getIn().setBody(sql);
    }
}
