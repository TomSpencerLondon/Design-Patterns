package org.example.strategy.exercise;

public class DESEncryption implements EncryptionAlgorithm {
    @Override
    public void encrypt(String message) {
        System.out.println("Encrypting message using DES");
    }
}
