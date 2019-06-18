package com.dztt.activemq.demo2;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息消费者
 */
public class QueueSubscriber {

    public static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

    public static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

    public static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String... args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
        try {
            Connection connection = connectionFactory.createConnection();

            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Queue myTestQueue = session.createQueue("activemq-queue-test1");
            //3个消费者 每个消费一个

            MessageConsumer messageConsumer = session.createConsumer(myTestQueue);
            messageConsumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    try {
                        System.out.println("消费者1接收到消息：" + ((TextMessage) message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

            MessageConsumer messageConsumer2 = session.createConsumer(myTestQueue);
            messageConsumer2.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    try {
                        System.out.println("消费者2接收到消息：" + ((TextMessage) message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

            MessageConsumer messageConsumer3 = session.createConsumer(myTestQueue);
            messageConsumer3.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    try {
                        System.out.println("消费者3接收到消息：" + ((TextMessage) message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread.sleep(100 * 1000);

            session.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
