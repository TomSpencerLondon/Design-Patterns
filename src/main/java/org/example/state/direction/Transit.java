package org.example.state.direction;

public class Transit implements TravelState {
    @Override
    public int eta() {
        System.out.println("Calculating ETA (transit)");
        return 3;
    }

    @Override
    public int direction() {
        System.out.println("Calculating Direction (transit)");
        return 3;
    }
}
