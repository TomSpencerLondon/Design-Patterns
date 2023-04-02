package org.example.state.direction;

public class Driving implements TravelState {
    @Override
    public int eta() {
        System.out.println("Calculating ETA (driving)");
        return 1;
    }

    @Override
    public int direction() {
        System.out.println("Calculating Direction (driving)");
        return 1;
    }
}
