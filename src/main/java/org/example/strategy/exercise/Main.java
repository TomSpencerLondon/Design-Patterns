package org.example.strategy.exercise;

public class Main {
    public static void main(String[] args) {
        AESEncryption aesEncryption = new AESEncryption();

        ChatClient chatClient = new ChatClient();

        chatClient.send("message", aesEncryption);
    }
}
