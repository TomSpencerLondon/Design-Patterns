package org.example.strategy.problem;

public class Main {
    public static void main(String[] args) {
        ImageStorage imageStorage = new ImageStorage("png", "b&w");

        imageStorage.store("file");
    }
}
