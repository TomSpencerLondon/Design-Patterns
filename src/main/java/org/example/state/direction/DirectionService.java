package org.example.state.direction;

public class DirectionService {
    private TravelState travelState;

    public int getEta() {
       return travelState.eta();
    }

    public int getDirection() {
        return travelState.direction();
    }

    public TravelState getTravelState() {
        return travelState;
    }

    public void setTravelState(TravelState travelMode) {
        this.travelState = travelMode;
    }
}
