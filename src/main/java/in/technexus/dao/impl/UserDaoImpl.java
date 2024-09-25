package in.technexus.dao.impl;

import in.technexus.dao.UserDao;
import in.technexus.pojo.UserPojo;
import in.technexus.utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public String registerUser(UserPojo user) {
        String status = "Registration failed";
        if(isRegistered(user.getUseremail())){
            return "User already exists";
        }
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("insert into users values(?,?,?,?,?,?)");
            ps.setString(1, user.getUseremail());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getMobile());
            ps.setString(4, user.getAddress());
            ps.setInt(5, user.getPincode());
            ps.setString(6, user.getPassword());
            if(ps.executeUpdate() > 0){
                status = "Registration successful";

                // code to send email
            }
        } catch (SQLException e) {
            System.out.println("Error in registerUser()"+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        return status;
    }

    @Override
    public boolean isRegistered(String emailId) {
        boolean flag = false;
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select * from users where useremail = ?");
            ps.setString(1, emailId);
            rs = ps.executeQuery();
            if(rs.next()) {
                flag = true;
            }
        }catch(SQLException e){
            System.out.println("Error in isRegistered: " + e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps);
        return flag;
    }

    @Override
    public String isValidCredentials(String emailId, String password) {
        String status = "Login Denied! incorrect username or password";
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select * from users where useremail = ? and password = ?");
            ps.setString(1, emailId);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()) {
                status = "Login Success!";
            }
        } catch (SQLException e) {
            status = "Error in isValidCredentials: " + e.getMessage();
            System.out.println("Error in isValidCredentials: " + e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps);
        return status;
    }

    @Override
    public UserPojo getUserDetails(String emailId) {
        UserPojo user = null;
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select * from users where useremail = ?");
            ps.setString(1, emailId);
            rs = ps.executeQuery();
            if(rs.next()) {
                user = new UserPojo();
                user.setUseremail(rs.getString("useremail"));
                user.setUsername(rs.getString("username"));
                user.setMobile(rs.getString("mobile"));
                user.setAddress(rs.getString("address"));
                user.setPincode(rs.getInt("pincode"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error in getUserDetails: " + e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps);
        return user;
    }

    @Override
    public String getUserFirstName(String emailId) {
        String first = null;
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select username from users where useremail = ?");
            ps.setString(1, emailId);
            rs = ps.executeQuery();
            if(rs.next()) {
                first = rs.getString("username").split(" ")[0];
            }
        } catch (SQLException e) {
            System.out.println("Error in getUserFirstName: " + e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps);
        return first;
    }

    @Override
    public String getUserAddr(String emailId) {
        String addr = null;
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select address from users where useremail = ?");
            ps.setString(1, emailId);
            rs = ps.executeQuery();
            if(rs.next()) {
                addr = rs.getString("address");
            }
        } catch (SQLException e) {
            System.out.println("Error in getUserAddr: " + e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(ps);
        return addr;
    }
}
