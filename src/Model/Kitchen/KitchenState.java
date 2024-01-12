package Model.Kitchen;

import java.util.List;
import Model.Order;

public interface KitchenState {
    int getCurrentOrderId();
    List<Order> getWaitingOrders();
}
