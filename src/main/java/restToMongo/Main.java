package restToMongo;

import org.apache.camel.CamelContext;
import org.apache.camel.component.sql.SqlComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/camel-test";
        DataSource dataSource = setupDataResourse(url);
        SimpleRegistry simpleRegistry = new SimpleRegistry();
        simpleRegistry.put("myDataSource",dataSource);

        SqlComponent sqlComponent = new SqlComponent();
        sqlComponent.setDataSource(dataSource);
        simpleRegistry.put("sql",dataSource);
        DefaultCamelContext camelContext = new DefaultCamelContext(simpleRegistry);
        camelContext.addRoutes(new RestApiToMysql());
        camelContext.start();
    }

    private static DataSource setupDataResourse(String url) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("");
        basicDataSource.setUrl(url);
        return basicDataSource;
    }

}
