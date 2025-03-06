package in.technexus.dao.impl;

import in.technexus.dao.CartDao;
import in.technexus.listener.DBConnectionListener;
import in.technexus.pojo.CartPojo;
import in.technexus.pojo.DemandPojo;
import in.technexus.utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartDaoImpl implements CartDao {

    @Override
    public String addProductToCart(CartPojo cart){
        String status = "Failed to add to cart";
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps1 = null;
        ResultSet rs = null;
        try{
            ps1 = conn.prepareStatement("select * from USERCART where prodid = ? and useremail = ?");
            ps1.setString(1, cart.getProdId());
            ps1.setString(2, cart.getUseremail());
            rs = ps1.executeQuery();
            if (rs.next()){
                ProductDaoImpl productDao = new ProductDaoImpl();
                int stockQty = productDao.getProductQuantity(cart.getProdId());
                int newQty = cart.getQuantity() + rs.getInt("quantity");
                if(stockQty < newQty){
                    cart.setQuantity(stockQty);
                    this.updateProductInCart(cart);
                    status = "Only "+stockQty+" no. of items are available in our stock so we are adding "+stockQty+" items in your cart.";
                    DemandPojo demandPojo = new DemandPojo();
                    demandPojo.setProdId(cart.getProdId());
                    demandPojo.setUseremail(cart.getUseremail());
                    demandPojo.setDemandQuantity(newQty-stockQty);
                    DemandDaoImpl demandDao = new DemandDaoImpl();
                    if(demandDao.addProduct(demandPojo)) status += " We will mail you when "+(newQty-stockQty)+" no. of items will be available.";

                }else {
                    cart.setQuantity(newQty);
                    status = this.updateProductInCart(cart);
                }
            }
        } catch (SQLException e) {
            status = "Addition failed due to exception";
            System.out.println("Exception in addProductToCart() : "+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps1);
        return status;
    }

    @Override
    public String updateProductInCart(CartPojo cart) {
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        String status = "Failed to add in cart";
        try{
            ps = conn.prepareStatement("select * from usercart where prodid = ? and useremail = ?");
            ps.setString(1, cart.getProdId());
            ps.setString(2, cart.getUseremail());
            rs = ps.executeQuery();
            if(rs.next()){
                if(cart.getQuantity()>0){
                    ps2 = conn.prepareStatement("update usercart set quantity = ? where prodid = ? and useremail = ?");
                    ps2.setInt(1, cart.getQuantity());
                    ps2.setString(2, cart.getProdId());
                    ps2.setString(3, cart.getUseremail());
                    if(ps2.executeUpdate()>0) status = "Product successfully updated in cart";
                    else status = "failed to update the product";
                }else if (cart.getQuantity() == 0){
                    ps2 = conn.prepareStatement("delete from USERCART where prodid = ? and useremail = ?");
                    ps2.setString(1,cart.getProdId());
                    ps2.setString(2, cart.getUseremail());
                    if(ps2.executeUpdate()>0) status = "Product successfully updated in cart";
                    else status = "failed to update the product";
                }

            }else{
                ps2 = conn.prepareStatement("insert into usercart values(?,?,?)");
                ps2.setString(1, cart.getUseremail());
                ps2.setString(2, cart.getProdId());
                ps2.setInt(3, cart.getQuantity());
                if(ps2.executeUpdate()>0) status = "Product successfully Added to cart";
            }
        } catch (SQLException e) {
            status = "Updation failed due to exception";
            e.printStackTrace();
            System.out.println("Error in updateProductInCart(): "+e.getMessage());
        }
        DBUtil.closeStatement(ps);
        DBUtil.closeStatement(ps2);
        DBUtil.closeResultSet(rs);
        return status;
    }

    @Override
    public List<CartPojo> getAllCartItems(String userId) {
        List<CartPojo> cartList = new ArrayList<>();
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from USERCART where useremail = ?");
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()){
                CartPojo cartPojo = new CartPojo();
                cartPojo.setQuantity(rs.getInt("quantity"));
                cartPojo.setProdId(rs.getString("prodid"));
                cartPojo.setUseremail(userId);
                cartList.add(cartPojo);
            }
        }catch (SQLException ex){
            System.out.println("Exception in getAllCartItems() : "+ex.getMessage());
            ex.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        DBUtil.closeResultSet(rs);
        return cartList;
    }

    @Override
    public int getCartItemCount(String userId, String itemId) {
        if(userId==null || itemId==null) return 0;
        int res = 0;
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select quantity from USERCART where useremail = ? and prodid = ?");
            ps.setString(1, userId);
            ps.setString(2, itemId);
            rs = ps.executeQuery();
            if (rs.next()) res = rs.getInt(1);
        }catch (SQLException ex){
            System.out.println("Exception in getCartItemCount(): "+ex.getMessage());
            ex.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        DBUtil.closeResultSet(rs);
        return res;
    }

    @Override
    public String removeProductFromCart(String userId, String prodId) {
        String status = "Product removal failed";
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        try {
            ps1 = conn.prepareStatement("select * from USERCART where useremail = ? and prodid = ?");
            ps1.setString(1, userId);
            ps1.setString(2, prodId);
            rs = ps1.executeQuery();
            if(rs.next()){
                int prodQuantity = rs.getInt("quantity");
                prodQuantity -= 1;
                if(prodQuantity > 0){
                    ps2 = conn.prepareStatement("update usercart set quantity = ? where useremail = ? and prodid = ?");
                    ps1.setInt(1, prodQuantity);
                    ps2.setString(2, userId);
                    ps2.setString(3, prodId);
                    int k = ps2.executeUpdate();
                    if(k > 0) status = "Product Successfully removed";
                }else {
                    ps2 = conn.prepareStatement("delete from usercart where useremail = ? and prodid = ?");
                    ps2.setString(1, userId);
                    ps2.setString(2, prodId);
                    int k = ps2.executeUpdate();
                    if(k > 0) status = "Product successfully removed";
                }
            }
        }catch (SQLException ex){
            status = "Removal failed due to exception";
            System.out.println("Error in removeProductFrom(): "+ex.getMessage());
            ex.printStackTrace();
        }
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps1);
        DBUtil.closeStatement(ps2);
        return status;
    }

    @Override
    public boolean removeAProduct(String userId, String prodId) {
        boolean flag = false;
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("delete from usercart where useremail = ? and prodid = ?");
            ps.setString(1, userId);
            ps.setString(2, prodId);
            int k = ps.executeUpdate();
            if(k > 0) flag = true;
        }catch (SQLException ex){
            System.out.println("Exception in removeAProduct(): "+ex.getMessage());
            ex.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        return flag;
    }
}
