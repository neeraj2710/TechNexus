package in.technexus.pojo;

public class CartPojo {

    private String useremail;
    private String prodId;
    private int quantity;

    public CartPojo() {
    }

    public CartPojo(String useremail, String prodId, int quantity) {
        this.useremail = useremail;
        this.prodId = prodId;
        this.quantity = quantity;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartPojo{" +
                "useremail='" + useremail + '\'' +
                ", prodId='" + prodId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
