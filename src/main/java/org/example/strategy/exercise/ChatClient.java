package org.example.strategy.exercise;

public class ChatClient {
    public void send(String message, EncryptionAlgorithm encryptionAlgorithm) {
        encryptionAlgorithm.encrypt(message);
        System.out.println("Sending the encrypted message...");
    }
}
