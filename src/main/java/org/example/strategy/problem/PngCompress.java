package org.example.strategy.problem;

public class PngCompress implements CompressStrategy {
    @Override
    public void compress() {
        System.out.println("Compressing using PNG");
    }
}
