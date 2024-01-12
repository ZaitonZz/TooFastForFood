package Model.Kitchen;

import Model.Order;

import java.util.ArrayList;
import java.util.List;

public class KitchenStateImpl implements KitchenState {
    private int currentOrderId;
    private List<Order> waitingOrders;

    public KitchenStateImpl() {
        this.currentOrderId = 0;
        this.waitingOrders = new ArrayList<>();
    }

    @Override
    public int getCurrentOrderId() {
        return currentOrderId;
    }

    @Override
    public List<Order> getWaitingOrders() {
        return waitingOrders;
    }
}
