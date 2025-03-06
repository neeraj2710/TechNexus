package in.technexus.dao.impl;

import in.technexus.dao.OrderDao;
import in.technexus.pojo.CartPojo;
import in.technexus.pojo.OrderDetailsPojo;
import in.technexus.pojo.OrderPojo;
import in.technexus.pojo.TransactionPojo;
import in.technexus.utility.DBUtil;
import in.technexus.utility.IDUtil;

import javax.xml.bind.SchemaOutputResolver;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean addOrder(OrderPojo order) {
        boolean status = false;
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("insert into ORDERS values (?,?,?,?,?)");
            ps.setString(1, order.getOrderId());
            ps.setString(2, order.getProdId());
            ps.setInt(3, order.getQuantity());
            ps.setDouble(4,order.getAmount());
            ps.setInt(5, 0);
            int count = ps.executeUpdate();
            status = count > 0;
        } catch (SQLException e) {
            System.out.println("Exception in addOrder() : "+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        return status;
    }

    @Override
    public boolean addTransaction(TransactionPojo transaction) {
        boolean status = false;
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("insert into TRANSACTIONS values (?,?,?,?)");
            ps.setString(1, transaction.getTransactionId());
            ps.setString(2, transaction.getUserEmail());
            java.sql.Date d = new java.sql.Date(transaction.getTransTime().getTime());
            ps.setDate(3,d );
            ps.setDouble(4,transaction.getAmount());
            int count = ps.executeUpdate();
            status = count > 0;
        } catch (SQLException e) {
            System.out.println("Exception in addTransaction() : "+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        return status;
    }

    @Override
    public List<OrderPojo> getAllOrders() {
        List<OrderPojo> orderPojoList = new ArrayList<>();
        Connection conn = DBUtil.provideConnection();
        Statement st = null;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM ORDERS");
            while(rs.next()){
                OrderPojo order = new OrderPojo();
                order.setOrderId(rs.getString("orderid"));
                order.setProdId(rs.getString("proid"));
                order.setQuantity(rs.getInt("quantity"));
                order.setAmount(rs.getDouble("amount"));
                order.setShipped(rs.getInt("shipped"));
                orderPojoList.add(order);
            }
        }catch (SQLException ex){
            System.out.println("Exception in getAllOrders(): "+ex.getMessage());
            ex.printStackTrace();
        }
        DBUtil.closeStatement(st);
        DBUtil.closeResultSet(rs);
        return orderPojoList;
    }

    @Override
    public List<OrderDetailsPojo> getAllOrderDetails(String userEmailId) {
        List<OrderDetailsPojo> orderDetails = new ArrayList<>();
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT p.pid as prodid, o.orderid as orderid, o.shipped as shipped,p.image as image," +
                    "p.pname as pname,o.quantity as qty, o.amount as amount,t.transtime as time from orders o,products p," +
                    "transactions t where o.ordeid=t.transid and o.prodid=p.pid and t.useremail=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, userEmailId);
            rs = ps.executeQuery();
            while(rs.next()){
                OrderDetailsPojo order = new OrderDetailsPojo();
                order.setOrderId(rs.getString("orderid"));
                order.setProdImage(rs.getAsciiStream("image"));
                order.setProdId(rs.getString("prodid"));
                order.setProdName(rs.getString("pname"));
                order.setQuantity(rs.getInt("qty"));
                order.setAmount(rs.getDouble("amount"));
                order.setTime(rs.getTimestamp("time"));
                order.setShipped(rs.getInt("shipped"));
                orderDetails.add(order);
            }
        }catch (SQLException ex){
            System.out.println("Error in getAllOrderDetails(): "+ex.getMessage());
            ex.printStackTrace();
        }
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps);
        return orderDetails;
    }

    @Override
    public String shipNow(String orderId, String prodId) {
        String status = "Failure!";
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("update table orders set shipped = 1 where orderid = ? and prodid=?");
            ps.setString(1, orderId);
            ps.setString(2,prodId);
            int k = ps.executeUpdate();
            if(k>0) status="Order has been shipped successfully";
        }catch (SQLException ex){
            System.out.println("Error in shipNow(): "+ex.getMessage());
            ex.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        return status;
    }

    @Override
    public String paymentSuccess(String username, double paidAmount) {
        String status = "Order placement failed!";
        List<CartPojo> cartList = new CartDaoImpl().getAllCartItems(username);
        if(cartList.isEmpty()) return status;
        String transactionId = IDUtil.generateTransId();
        TransactionPojo trPojo = new TransactionPojo();
        trPojo.setTransactionId(transactionId);
        trPojo.setUserEmail(username);
        trPojo.setAmount(paidAmount);
        trPojo.setTransTime(new java.util.Date());
        boolean result = this.addTransaction(trPojo);
        if(!result) return status;
        boolean ordered = true;
        ProductDaoImpl productDao = new ProductDaoImpl();
        for(CartPojo cartPojo : cartList){
            double amount = productDao.getProductPrice(cartPojo.getProdId())*cartPojo.getQuantity();
            OrderPojo order = new OrderPojo();
            order.setOrderId(transactionId);
            order.setProdId(cartPojo.getProdId());
            order.setQuantity(cartPojo.getQuantity());
            order.setAmount(amount);
            order.setShipped(0);
            ordered = this.addOrder(order);
            if(!ordered) break;;
            ordered = new CartDaoImpl().removeAProduct(cartPojo.getUseremail(), cartPojo.getProdId());
            if (!ordered) break;
            ordered = productDao.sellNProduct(cartPojo.getProdId(), cartPojo.getQuantity());
            if(!ordered) break;
        }
        if(ordered) {
            status = "Order placed successfully";
            System.out.println("Transaction successful: "+transactionId);
        }else {
            System.out.println("Transaction failed: "+transactionId);
        }
        return status;
    }
}
