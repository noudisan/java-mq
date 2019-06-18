官网
http://rocketmq.apache.org/docs/motivation/


一、启动
Start Name Server
1、nohup sh bin/mqnamesrv &
2、tail -f ~/logs/rocketmqlogs/namesrv.log

Start Broker
1、nohup sh bin/mqbroker -n localhost:9876 &
2、tail -f ~/logs/rocketmqlogs/broker.log


二、实例
1、简单MQ
2、有序
3、广播
4、定时调度
5、批量
6、过滤
7、日志追加
8、openMessaging
9、事务
