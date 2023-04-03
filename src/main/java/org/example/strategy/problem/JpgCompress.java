package org.example.strategy.problem;

public class JpgCompress implements CompressStrategy {
    @Override
    public void compress() {
        System.out.println("Compressing using JPEG");
    }
}
