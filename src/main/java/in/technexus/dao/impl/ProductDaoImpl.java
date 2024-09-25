package in.technexus.dao.impl;

import in.technexus.dao.ProductDao;
import in.technexus.pojo.ProductPojo;
import in.technexus.utility.DBUtil;
import in.technexus.utility.IDUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public String addProduct(ProductPojo product) {
        String status = "Product registration failed!";
        if(product.getProdId() == null){
            product.setProdId(IDUtil.generateProdId());
        }
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("insert into products values (?,?,?,?,?,?,?)");
            ps.setString(1, product.getProdId());
            ps.setString(2, product.getProdName());
            ps.setString(3, product.getProdType());
            ps.setString(4, product.getProdInfo());
            ps.setDouble(5, product.getProdPrice());
            ps.setInt(6, product.getProdQuantity());
            ps.setBlob(7, product.getProdImage());
            if(ps.executeUpdate() > 0){
                status = "Product registration successful! with product id: " + product.getProdId();
            }
        } catch (SQLException e) {
            System.out.println("Error in addProduct:"+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        return status;
    }

    @Override
    public String updateProduct(ProductPojo prevProduct, ProductPojo updatedProduct) {
        return "";
    }

    @Override
    public String updateProductPrice(String prodId, double updatedPrice) {
        return "";
    }

    @Override
    public List<ProductPojo> getAllProducts() {
        return Collections.emptyList();
    }

    @Override
    public List<ProductPojo> getAllProductsByType(String type) {
        return Collections.emptyList();
    }

    @Override
    public List<ProductPojo> searchA11Products(String search) {
        return Collections.emptyList();
    }

    @Override
    public ProductPojo getProductDetails(String prodId) {
        return null;
    }

    @Override
    public int getProductQuantity(String prodId) {
        return 0;
    }

    @Override
    public String updateProductWithoutImage(String prevProductId, ProductPojo updatedProduct) {
        return "";
    }

    @Override
    public double getProductPrice(String prodId) {
        return 0;
    }

    @Override
    public boolean sellNProduct(String prodId, int n) {
        return false;
    }

    @Override
    public List<String> getAllProductsType() {
        return Collections.emptyList();
    }

    @Override
    public byte[] getImage(String prodId) {
        return new byte[0];
    }

    @Override
    public String removeProduct(String prodId) {
        return "";
    }
}
