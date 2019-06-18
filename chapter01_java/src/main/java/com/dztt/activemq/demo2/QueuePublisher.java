package com.dztt.activemq.demo2;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息生产者
 */
public class QueuePublisher {

    public static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

    public static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

    public static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String... args) {
        try {
            //创建连接工厂
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);
            //创建链接
            Connection connection = connectionFactory.createConnection();
            //链接开启
            connection.start();
            //创建回话
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //创建queue
            Queue myTestQueue = session.createQueue("activemq-queue-test1");
            //创建发送者
            MessageProducer producer = session.createProducer(myTestQueue);

            for (int i = 1; i <= 3; i++) {
                TextMessage message = session.createTextMessage("发送消息" + i);
                producer.send(myTestQueue, message);
            }


            producer.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
