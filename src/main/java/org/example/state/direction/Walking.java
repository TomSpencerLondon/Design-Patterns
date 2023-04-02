package org.example.state.direction;

public class Walking implements TravelState {
    @Override
    public int eta() {
        System.out.println("Calculating ETA (walking)");
        return 4;

    }

    @Override
    public int direction() {
        System.out.println("Calculating Direction (walking)");
        return 4;
    }
}
