package org.example.strategy.problem;

public class HighContrastFilter implements FilterStrategy {
    @Override
    public void filter() {
        System.out.println("Applying high contrast filter");
    }
}
