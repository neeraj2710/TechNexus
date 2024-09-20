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
        return "";
    }

    @Override
    public boolean isRegistered(String emailId) throws SQLException {
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = conn.prepareStatement("select * from users where useremail = ?");
        ps.setString(1, emailId);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    @Override
    public String isValidCredentials(String emailId, String password) {
        return "";
    }

    @Override
    public UserPojo getUserDetails(String emailId) {
        return null;
    }

    @Override
    public String getUserFirstName(String emailId) {
        return "";
    }

    @Override
    public String getUserAddr(String emailId) {
        return "";
    }
}
