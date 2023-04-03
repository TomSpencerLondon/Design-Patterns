package org.example.strategy.exercise;

public class AESEncryption implements EncryptionAlgorithm {
    @Override
    public void encrypt(String message) {
        System.out.println("Encrypting message using AES");
    }
}
