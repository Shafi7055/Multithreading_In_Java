import java.util.LinkedList;
import java.util.Queue;

public class ParkingPool {
    private final Queue<RegistrarParking> orderQueue = new LinkedList<>();
    private final int MAX_CAPACITY = 10;

    public synchronized void addOrder(RegistrarParking order) {
        while (orderQueue.size() >= MAX_CAPACITY) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        orderQueue.offer(order);
        System.out.println(order + " arrived and is waiting to park.");
        notifyAll();
    }

    public synchronized RegistrarParking getOrder() {
        while (orderQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        RegistrarParking order = orderQueue.poll();
        notifyAll();
        return order;
    }
}
