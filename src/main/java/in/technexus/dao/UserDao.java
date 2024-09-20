package in.technexus.dao;

import in.technexus.pojo.UserPojo;

import java.sql.SQLException;

public interface UserDao {
    String registerUser(UserPojo user);
    boolean isRegistered(String emailId) throws SQLException;
    String isValidCredentials(String emailId, String password);
    UserPojo getUserDetails(String emailId);
    String getUserFirstName(String emailId);
    String getUserAddr(String emailId);
}
