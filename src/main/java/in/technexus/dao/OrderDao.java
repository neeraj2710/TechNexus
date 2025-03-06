package in.technexus.dao;

import in.technexus.pojo.OrderDetailsPojo;
import in.technexus.pojo.OrderPojo;
import in.technexus.pojo.TransactionPojo;

import java.util.List;

public interface OrderDao {

    public boolean addOrder(OrderPojo order);
    public boolean addTransaction(TransactionPojo transaction);
    public List<OrderPojo> getAllOrders();
    public List<OrderDetailsPojo> getAllOrderDetails(String userEmailId);
    public String shipNow(String orderId, String prodId);
    public String paymentSuccess(String username, double paidAmount);

}
