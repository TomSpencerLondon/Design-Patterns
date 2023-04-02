package org.example.state.direction;

public class Main {
    public static void main(String[] args) {
        DirectionService directionService = new DirectionService();
        directionService.setTravelState(new Driving());

        directionService.getEta();
        directionService.getDirection();

        directionService.setTravelState(new Bicycling());
        directionService.getEta();
        directionService.getDirection();

    }
}
