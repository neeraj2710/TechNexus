package in.technexus.dao;

import in.technexus.pojo.ProductPojo;

import java.util.List;

public interface ProductDao {
    String addProduct(ProductPojo product) ;
    String updateProduct(ProductPojo prevProduct, ProductPojo updatedProduct);
    String updateProductPrice(String prodId, double updatedPrice);
    List<ProductPojo> getAllProducts();
    List<ProductPojo> getAllProductsByType(String type);
    List<ProductPojo> searchA11Products(String search);
    ProductPojo getProductDetails(String prodId) ;
    int getProductQuantity(String prodId) ;
    String updateProductWithoutImage(String prevProductId, ProductPojo updatedProduct) ;
    double getProductPrice(String prodId);
    boolean sellNProduct(String prodId, int n);
    List<String> getAllProductsType();
    byte[] getImage(String prodId);
    String removeProduct(String prodId);
}
