package in.technexus.dao;

import in.technexus.pojo.DemandPojo;

import java.util.List;

public interface DemandDao {
    public boolean addProduct(DemandPojo demandPojo);
    public boolean removeProduct(String userId, String prodId);
    public List<DemandPojo> haveDemanded(String prodId);
}
