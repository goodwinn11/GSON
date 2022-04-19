public class Plan {
    public String id;
    public String shipId;
    public String createdAt;
    public String arrivesAt;
    public String destination;
    public String departure;
    public int distance;
    public int fuelConsumed;
    public int fuelRemaining;
    public String terminatedAt;
    public int timeRemainingInSeconds;

    public void printOutFlightPlan() {
        System.out.println("\n\nFlight Plan:");
        System.out.printf("\nid: %s\nshipId: %s\ncreatedAt: %s\narrivesAt: %s\ndestination: %s\ndeparture: %s\ndistance: %d\nfuelConsumed: %d\nfuelRemaining: %d\nterminatedAt: %s\ntimeRemainingInSeconds: %d",
                id, shipId, createdAt, arrivesAt, destination, departure, distance, fuelConsumed, fuelRemaining, terminatedAt, timeRemainingInSeconds);
    }
}
