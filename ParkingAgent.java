public class ParkingAgent extends Thread {
    private final ParkingPool pool;
    private final String agentName;

    public ParkingAgent(ParkingPool pool, String agentName) {
        this.pool = pool;
        this.agentName = agentName;
    }

    @Override
    public void run() {
        while (true) {
            RegistrarParking order = pool.getOrder();
            if (order != null) {
                System.out.println(agentName + " is parking " + order);
                try {
                    Thread.sleep(1000); // Simulate time to park
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(agentName + " parked " + order);
            }
        }
    }
}
