package org.example.state.direction;

public class Bicycling implements TravelState {
    @Override
    public int eta() {
        System.out.println("Calculating ETA (bicycling)");
        return 2;

    }

    @Override
    public int direction() {
        System.out.println("Calculating Direction (bicycling)");
        return 2;
    }
}
