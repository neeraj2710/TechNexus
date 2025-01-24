package in.technexus.dao.impl;

import in.technexus.dao.DemandDao;
import in.technexus.pojo.DemandPojo;
import in.technexus.utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemandDaoImpl implements DemandDao {

//    returns true if data is added and false if insertion fails
    @Override
    public boolean addProduct(DemandPojo demandPojo) {
        boolean result = false;
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try{
//            if product is already available then updating the quantity
            ps1 = conn.prepareStatement("update userdemand set quantity = quantity+? where useremail = ? and prodid=?");
            ps1.setInt(1, demandPojo.getDemandQuantity());
            ps1.setString(2, demandPojo.getUseremail());
            ps1.setString(3, demandPojo.getProdId());
            int k = ps1.executeUpdate();
//            adding the product if it is not available
            if(k == 0){
                ps2 = conn.prepareStatement("insert into userdemand values(?,?,?)");
                ps2.setString(1, demandPojo.getUseremail());
                ps2.setString(2, demandPojo.getProdId());
                ps2.setInt(3, demandPojo.getDemandQuantity());
                ps2.executeUpdate();
            }
            result = true;
        } catch (SQLException e) {
            System.out.println("Error in addProduct(DemandDao): " + e.getMessage());
            e.printStackTrace();
        }
//        closing resources
        DBUtil.closeStatement(ps1);
        DBUtil.closeStatement(ps2);
        return result;
    }


//    returns false if deletion fails and true if deletion is successful
    @Override
    public boolean removeProduct(String userId, String prodId) {
        boolean result = false;
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("delete from userdemand where useremail=? and prodid=?");
            ps.setString(1, userId);
            ps.setString(2, prodId);
            result = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error in removeProduct(DemandDao): " + e.getMessage());
            e.printStackTrace();
        }
//        closing resources
        DBUtil.closeStatement(ps);
        return result;
    }


//    returns the list of demands for a particular product
    @Override
    public List<DemandPojo> haveDemanded(String prodId) {
        List<DemandPojo> demandPojoList = new ArrayList<>();
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select * from userdemand where prodid=?");
            ps.setString(1, prodId);
            rs = ps.executeQuery();

//            runs loop till the data is found
            while(rs.next()){
                DemandPojo demandPojo = new DemandPojo();
                demandPojo.setDemandQuantity(rs.getInt("quantity"));
                demandPojo.setUseremail(rs.getString("useremail"));
                demandPojo.setProdId(rs.getString("prodid"));
                demandPojoList.add(demandPojo);
            }
        } catch (SQLException e) {
            System.out.println("Error in haveDemanded(DemandDao): " + e.getMessage());
            e.printStackTrace();
        }

//        closing resources
        DBUtil.closeStatement(ps);
        DBUtil.closeResultSet(rs);
        return demandPojoList;
    }
}
