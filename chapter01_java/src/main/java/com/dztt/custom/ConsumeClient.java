package com.dztt.custom;

public class ConsumeClient {

    public static void main(String... args) throws Exception {
        Mqclient client = new Mqclient();
        String message = client.consume();
        System.out.println("获取的消息为：" + message);
    }
}
