package activemqToDb;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.sql.SqlComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DbMysqlRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new DbMysqlRoute();
    }

    @Override
    protected CamelContext createCamelContext() throws Exception {
        String url = "jdbc:mysql://localhost:3306/camel-test";
        DataSource dataSource = setupDataResourse(url);
        SimpleRegistry simpleRegistry = new SimpleRegistry();
        simpleRegistry.put("myDataSource",dataSource);
        SqlComponent sqlComponent = new SqlComponent();
        sqlComponent.setDataSource(dataSource);
        simpleRegistry.put("sql",dataSource);
        return new DefaultCamelContext(simpleRegistry);
    }

    private DataSource setupDataResourse(String url) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("");
        basicDataSource.setUrl(url);
        return basicDataSource;
    }
    @Test
    public void jms2DBRouteTest(){

        String input = "first db input";
        ArrayList responseList =  template.requestBody("direct:dbInput", input, ArrayList.class);
        System.out.println("responseList : " + responseList.size());
        assertNotEquals(0,responseList.size());

    }
}