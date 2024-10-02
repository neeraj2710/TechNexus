package in.technexus.dao.impl;

import in.technexus.dao.ProductDao;
import in.technexus.pojo.ProductPojo;
import in.technexus.utility.DBUtil;
import in.technexus.utility.IDUtil;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
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
            ps = conn.prepareStatement("insert into products values (?,?,?,?,?,?,?,?)");
            ps.setString(1, product.getProdId());
            ps.setString(2, product.getProdName());
            ps.setString(3, product.getProdType());
            ps.setString(4, product.getProdInfo());
            ps.setDouble(5, product.getProdPrice());
            ps.setInt(6, product.getProdQuantity());
            ps.setBlob(7, product.getProdImage());
            ps.setString(1, "Y");
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
        String status = "Updation failed!";
        if(!prevProduct.getProdId().equals(updatedProduct.getProdId())){
            status = "Product IDs do not match! Update failed!";
            return status;
        }
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("update products set pname = ?,ptype=?,pinfo=?,pprice=?,pquantity=?,image=? where pid = ?");
            ps.setString(1, updatedProduct.getProdName());
            ps.setString(2, updatedProduct.getProdType());
            ps.setString(3, updatedProduct.getProdInfo());
            ps.setDouble(4, updatedProduct.getProdPrice());
            ps.setInt(5, updatedProduct.getProdQuantity());
            ps.setBlob(6, updatedProduct.getProdImage());
            ps.setString(7, updatedProduct.getProdId());
            if(ps.executeUpdate() > 0){
                status = "Product updated successfully!";
            }
        } catch (SQLException e) {
            System.out.println("Error in updateProduct:"+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        return status;
    }

    @Override
    public String updateProductPrice(String prodId, double updatedPrice) {
        String status = "Product price updation failed!";
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("update products set pprice = ? where pid = ?");
            ps.setDouble(1, updatedPrice);
            ps.setString(2, prodId);
            if(ps.executeUpdate() > 0){
                status = "Product price updated successfully!";
            }
        } catch (SQLException e) {
            System.out.println("Error in updateProductPrice:"+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        return status;
    }

    @Override
    public List<ProductPojo> getAllProducts() {
        List<ProductPojo> products = new ArrayList<>();
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("SELECT * from products where available = 'Y'");
            rs = ps.executeQuery();
            while(rs.next()){
                ProductPojo product = new ProductPojo();
                product.setProdId(rs.getString("pid"));
                product.setProdName(rs.getString("pname"));
                product.setProdType(rs.getString("ptype"));
                product.setProdInfo(rs.getString("pinfo"));
                product.setProdPrice(rs.getDouble("pprice"));
                product.setProdQuantity(rs.getInt("pquantity"));
                product.setProdImage((rs.getAsciiStream("image")));
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Error in getAllProducts:"+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        DBUtil.closeResultSet(rs);
        return products;
    }

    @Override
    public List<ProductPojo> getAllProductsByType(String type) {
        List<ProductPojo> products = new ArrayList<>();
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        type = type.toLowerCase();
        try{
            ps = conn.prepareStatement("SELECT * from products where lower(ptype) like ? and available = 'Y'");
            ps.setString(1, "%"+type+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                ProductPojo product = new ProductPojo();
                product.setProdId(rs.getString("pid"));
                product.setProdName(rs.getString("pname"));
                product.setProdType(rs.getString("ptype"));
                product.setProdInfo(rs.getString("pinfo"));
                product.setProdPrice(rs.getDouble("pprice"));
                product.setProdQuantity(rs.getInt("pquantity"));
                product.setProdImage((rs.getAsciiStream("image")));
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Error in getAllProductsByType:"+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        DBUtil.closeResultSet(rs);
        return products;
    }

    @Override
    public List<ProductPojo> searchA11Products(String search) {
        List<ProductPojo> products = new ArrayList<>();
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        search = search.toLowerCase();
        try{
            ps = conn.prepareStatement("SELECT * from products where lower(ptype) like ? or lower(pname) like ? or lower(pinfo) like ? and available = 'Y'");
            ps.setString(1, "%"+search+"%");
            ps.setString(2, "%"+search+"%");
            ps.setString(3, "%"+search+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                ProductPojo product = new ProductPojo();
                product.setProdId(rs.getString("pid"));
                product.setProdName(rs.getString("pname"));
                product.setProdType(rs.getString("ptype"));
                product.setProdInfo(rs.getString("pinfo"));
                product.setProdPrice(rs.getDouble("pprice"));
                product.setProdQuantity(rs.getInt("pquantity"));
                product.setProdImage((rs.getAsciiStream("image")));
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Error in searchAllProducts:"+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        DBUtil.closeResultSet(rs);
        return products;
    }

    @Override
    public ProductPojo getProductDetails(String prodId) {
        ProductPojo product = null;
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select * from products where pid = ? and available = 'Y'");
            ps.setString(1, prodId);
            rs = ps.executeQuery();
            if(rs.next()){
                product = new ProductPojo();
                product.setProdId(rs.getString("pid"));
                product.setProdName(rs.getString("pname"));
                product.setProdType(rs.getString("ptype"));
                product.setProdInfo(rs.getString("pinfo"));
                product.setProdPrice(rs.getDouble("pprice"));
                product.setProdQuantity(rs.getInt("pquantity"));
                product.setProdImage((rs.getAsciiStream("image")));
            }
        } catch (SQLException e) {
            System.out.println("Error in getProductDetails:"+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        DBUtil.closeResultSet(rs);
        return product;
    }

    @Override
    public int getProductQuantity(String prodId) {
        int quantity = 0;
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select pquantity from products where pid = ? ");
            ps.setString(1, prodId);
            rs = ps.executeQuery();
            if(rs.next()){
                quantity = rs.getInt("pquantity");
            }
        } catch (SQLException e) {
            System.out.println("Error in getProductQuantity:"+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        DBUtil.closeResultSet(rs);
        return quantity;
    }

    @Override
    public String updateProductWithoutImage(String prevProductId, ProductPojo updatedProduct) {
        String status = "Updation failed";
        int prevQuantity = 0;
        if(!prevProductId.equals(updatedProduct.getProdId())){
            return "Product IDs do not match";
        }
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        try{
            prevQuantity = getProductQuantity(prevProductId);
            ps = conn.prepareStatement("update products set pname=?,ptype=?,pinfo=?, pprice = ?,pquantity=? where pid = ? ");
            ps.setString(1, updatedProduct.getProdName());
            ps.setString(2, updatedProduct.getProdType());
            ps.setString(3, updatedProduct.getProdInfo());
            ps.setDouble(4, updatedProduct.getProdPrice());
            ps.setInt(5, updatedProduct.getProdQuantity());
            ps.setString(6, updatedProduct.getProdId());
            int count = ps.executeUpdate();
            if(count == 1 && prevQuantity<updatedProduct.getProdQuantity()){
                status = "Product updated successfully and mail sent";
            } else if (count == 1) {
                status = "Product updated successfully";
            }
        } catch (SQLException e) {
            System.out.println("Error in updateProductWithoutImage:"+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        return status;
    }

    @Override
    public double getProductPrice(String prodId) {
        double price = 0;
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select pprice from products where pid = ?");
            ps.setString(1, prodId);
            rs = ps.executeQuery();
            if(rs.next()){
                price = rs.getDouble("pprice");
            }
        } catch (SQLException e) {
            System.out.println("Error in getProductPrice:"+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        DBUtil.closeResultSet(rs);
        return price;
    }

    @Override
    public boolean sellNProduct(String prodId, int n) {
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("update products set pquantity = (pquantity-?) where pid = ? and available = 'Y'");
            ps.setInt(1, n);
            ps.setString(2, prodId);
            int count = ps.executeUpdate();
            if(count == 1){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error in sellNProduct:"+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        return false;
    }

    @Override
    public List<String> getAllProductsType() {
        List<String> productType = new ArrayList<>();
        Connection conn = DBUtil.provideConnection();
        Statement st = null;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery("select distinct ptype from products where available = 'Y'");
            while(rs.next()){
                productType.add(rs.getString("ptype"));
            }
        } catch (SQLException e) {
            System.out.println("Error in getAllProductsType:"+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(st);
        DBUtil.closeResultSet(rs);
        return productType;
    }

    @Override
    public byte[] getImage(String prodId) {
        byte[] image = null;
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select image from products where pid = ?");
            ps.setString(1, prodId);
            rs = ps.executeQuery();
            if(rs.next()){
                image = rs.getBytes("image");
            }
        } catch (SQLException e) {
            System.out.println("Error in getImage:"+e.getMessage());
            e.printStackTrace();
        }
        DBUtil.closeStatement(ps);
        DBUtil.closeResultSet(rs);
        return image;
    }

    @Override
    public String removeProduct(String prodId) {
        return "";
    }
}
