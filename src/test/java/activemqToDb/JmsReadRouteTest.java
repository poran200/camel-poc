package activemqToDb;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JmsReadRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new JmsReadRoute();
    }

    @Override
    public CamelContext context() {
        CamelContext defaultCamelContext = new DefaultCamelContext();
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        defaultCamelContext.addComponent("jms", JmsComponent.jmsComponent(connectionFactory));
        return defaultCamelContext;
    }

    @Test
    void readMessageFromJms() throws Exception {
        context().addRoutes(createRouteBuilder());
        context().start();
        String expect = "123";
        String receiveBody = consumer.receiveBody("direct:readQueue", String.class);
        System.out.println("receiveBody = " + receiveBody);
        assertEquals(expect,receiveBody);
    }
}