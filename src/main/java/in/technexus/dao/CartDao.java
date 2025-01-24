package in.technexus.dao;

import in.technexus.pojo.CartPojo;

import java.util.List;

public interface CartDao {
    public String addProductToCart(CartPojo cart);
    public String updateProductInCart(CartPojo cart);
    public List<CartPojo> getAllCartItems(String userId);
    public int getCartItemCount(String userId, String itemId);
    public String removeProductFromCart(String userId,String prodId);
    public boolean removeAProduct(String userId, String prodId);
}
