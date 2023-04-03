package org.example.strategy.problem;

public class ImageStorage {

    private CompressStrategy compressor;
    private FilterStrategy filter;

    public ImageStorage(String compressor, String filter) {
        this.compressor = compressStrategy(compressor);
        this.filter = filterStrategy(filter);
    }

    private CompressStrategy compressStrategy(String compressor) {
        if (compressor.equals("jpeg")) {
            return new JpgCompress();
        }

        return new PngCompress();
    }

    private FilterStrategy filterStrategy(String filter) {
        if (filter.equals("b&w")) {
            return new BAndWFilter();
        }

        return new HighContrastFilter();
    }

    public void store(String fileName) {
        compressor.compress();
        filter.filter();
    }
}
