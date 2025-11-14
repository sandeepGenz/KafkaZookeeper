package KafkaDemo.dto;
public class OrderEvent {
    private String orderId;
    private String product;
    private int price;

    public OrderEvent() {}
    public OrderEvent(String orderId, String product, int price) {
        this.orderId = orderId;
        this.product = product;
        this.price = price;
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    @Override
    public String toString() {
        return "OrderEvent{" + "orderId='" + orderId + '\'' + ", product='" + product + '\'' + ", price=" + price + '}';
    }
}

