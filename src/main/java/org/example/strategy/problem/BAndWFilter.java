package org.example.strategy.problem;

public class BAndWFilter implements FilterStrategy {
    @Override
    public void filter() {
        System.out.println("Applying B&W filter");
    }
}
