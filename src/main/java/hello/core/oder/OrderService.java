package hello.core.oder;

public interface OrderService {
    Order createOrder(Long memberID, String itemName, int itemPrice);

}
