package org.example.strategy.solution;

public class JpegCompressor implements Compressor {
    @Override
    public void compress(String fileName) {
        System.out.println("Compressing using jpeg");
    }
}
