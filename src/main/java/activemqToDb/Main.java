package activemqToDb;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {
    public static void main(String[] args) throws Exception {
     CamelContext camelContext = new   DefaultCamelContext();
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        camelContext.addComponent("jms", JmsComponent.jmsComponent(connectionFactory));
        camelContext.addRoutes(new JmsReadRoute());
        camelContext.start();
        ConsumerTemplate consumerTemplate = camelContext.createConsumerTemplate();

        String receiveBody = consumerTemplate.receiveBody("direct:readQueue", String.class);
        System.out.println("receiveBody = " + receiveBody);

    }
}
