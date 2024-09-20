package in.technexus.pojo;

public class DemandPojo {

    private String useremail;
    private String prodId;
    private int demandQuantity;

    public DemandPojo() {
    }

    public DemandPojo(String useremail, String prodId, int quantity) {
        this.useremail = useremail;
        this.prodId = prodId;
        this.demandQuantity = quantity;
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

    public int getDemandQuantity() {
        return demandQuantity;
    }

    public void setDemandQuantity(int demandQuantity) {
        this.demandQuantity = demandQuantity;
    }

    @Override
    public String toString() {
        return "DemandPojo{" +
                "useremail='" + useremail + '\'' +
                ", prodId='" + prodId + '\'' +
                ", quantity=" + demandQuantity +
                '}';
    }
}
