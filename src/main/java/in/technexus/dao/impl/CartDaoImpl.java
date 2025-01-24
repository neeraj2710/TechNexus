package in.technexus.dao.impl;

import in.technexus.dao.CartDao;
import in.technexus.listener.DBConnectionListener;
import in.technexus.pojo.CartPojo;
import in.technexus.utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CartDaoImpl implements CartDao {

    @Override
    public String addProductToCart(CartPojo cart){
        return "";
    }

    @Override
    public String updateProductInCart(CartPojo cart) {
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        String status = "Failed to add in cart";
        try{
            ps = conn.prepareStatement("select * from usercart where prodid = ? and useremail = ?");
            ps.setString(1, cart.getProdId());
            ps.setString(2, cart.getUseremail());
            if(ps.executeUpdate()>0){
                if(cart.getQuantity()>0){
                    ps = conn.prepareStatement("update usercart set quantity = ? where prodid = ? and useremail = ?");
                    ps.setInt(1, cart.getQuantity());
                    ps.setString(2, cart.getProdId());
                    ps.setString(3, cart.getUseremail());
                }else{
                    ps = conn.prepareStatement("delete from products where prodid = ? and useremail = ?");
                    ps.setString(1,cart.getProdId());
                    ps.setString(2, cart.getUseremail());
                }
                if(ps.executeUpdate()>0) status = "Product successfully updated in cart";
            }else{
                ps = conn.prepareStatement("insert into usercart values(?,?,?)");
                ps.setString(1, cart.getUseremail());
                ps.setString(2, cart.getProdId());
                ps.setInt(3, cart.getQuantity());
                if(ps.executeUpdate()>0) status = "Product successfully Added to cart";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error in updateProductInCart(): "+e.getMessage());
        }
        DBUtil.closeStatement(ps);
        return status;
    }

    @Override
    public List<CartPojo> getAllCartItems(String userId) {
        return Collections.emptyList();
    }

    @Override
    public int getCartItemCount(String userId, String itemId) {
        return 0;
    }

    @Override
    public String removeProductFromCart(String userId, String prodId) {
        return "";
    }

    @Override
    public boolean removeAProduct(String userId, String prodId) {
        return false;
    }
}
