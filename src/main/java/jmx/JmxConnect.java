package jmx;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.QueueViewMBean;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;

public class JmxConnect {

    public static void main(String[] args) throws Exception {
//        ("\nCreate an RMI connector client and " +
//                "connect it to the RMI connector server");
        JMXServiceURL url =
                new JMXServiceURL("service:jmx:rmi:///jndi/rmi://127.0.0.1:1099/jmxrmi");
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

        ObjectName jmxBrokerName = new ObjectName("org.apache.activemq:type=Broker,brokerName=localhost,destinationType=Queue,destinationName=Done");
        QueueViewMBean queueViewMBean =
                MBeanServerInvocationHandler.newProxyInstance(mbsc, jmxBrokerName, QueueViewMBean.class, true);

          queueViewMBean.purge();
//        queueViewMBean.sendTextMessage("hello All!!");
//        queueViewMBean.purge();
//        String domains[] = mbsc.getDomains();
//        Arrays.sort(domains);
//        for (String domain : domains) {
//            System.out.println("\tDomain = " + domain);
//        }
    }
}
