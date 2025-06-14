import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingPool pool = new ParkingPool();

        System.out.print("Enter number of cars to park: ");
        int n = scanner.nextInt();

        System.out.print("Enter number of agents: ");
        int agentCount = scanner.nextInt();

        for (int i = 1; i <= agentCount; i++) {
            ParkingAgent agent = new ParkingAgent(pool, "Agent-" + i);
            agent.start();
        }

        for (int i = 1; i <= n; i++) {
            RegistrarParking order = new RegistrarParking(i);
            pool.addOrder(order);
            try {
                Thread.sleep(500); // Simulate arrival time between cars
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        scanner.close();
    }
}
