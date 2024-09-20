package in.technexus.pojo;

public class UserPojo {

    private String username;
    private String useremail;
    private String mobile;
    private String address;
    private int pincode;
    private String password;

    public UserPojo() {
    }

    public UserPojo(String username, String useremail, String mobile, String address, int pincode, String password) {
        this.username = username;
        this.useremail = useremail;
        this.mobile = mobile;
        this.address = address;
        this.pincode = pincode;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserPojo{" +
                "username='" + username + '\'' +
                ", useremail='" + useremail + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", pincode=" + pincode +
                ", password='" + password + '\'' +
                '}';
    }
}
