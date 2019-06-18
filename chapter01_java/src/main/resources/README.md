一、自定义消息队列
1、BrokerServer启动消息队列（内置一个阻塞队列）
2、ConsumeClient从消息队列消费
3、ProduceClient发送消息到消费队列

activemq和rabbitmq不可以同时开启。否则回报错

com.rabbitmq.client.MalformedFrameException: AMQP protocol version mismatch; we are version 0-9-1, server sent signature 3,1,0,0







