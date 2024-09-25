package in.technexus.dao;

import in.technexus.pojo.UserPojo;

public interface UserDao {
    String registerUser(UserPojo user);
    boolean isRegistered(String emailId);
    String isValidCredentials(String emailId, String password);
    UserPojo getUserDetails(String emailId);
    String getUserFirstName(String emailId);
    String getUserAddr(String emailId);
}
