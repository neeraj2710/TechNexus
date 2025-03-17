package in.technexus.servlet;

import in.technexus.dao.ProductDao;
import in.technexus.dao.impl.CartDaoImpl;
import in.technexus.dao.impl.ProductDaoImpl;
import in.technexus.pojo.ProductPojo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "LandingServlet", value = "/LandingServlet")
public class LandingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("username");
        String userType = (String)session.getAttribute("usertype");
        String search = request.getParameter("search");
        String type = request.getParameter("type");

        ProductDaoImpl productDao = new ProductDaoImpl();
        CartDaoImpl cartDao = new CartDaoImpl();
        String message = "All Products";
        List<ProductPojo> products = new ArrayList<>();
        if(search!=null){
            products = productDao.searchA11Products(search);
            message = "Showing results for '"+search+"'";
        }else if (type!=null){
            products = productDao.getAllProductsByType(type);
            message = "Showing results for '"+type+"'";
        }else{
            products = productDao.getAllProducts();
        }
        if(products.isEmpty()){
            products = productDao.getAllProducts();
            message = "No items found for '"+(search!=null?search:type)+"'";
        }
        Map<String,Integer> map = new HashMap<>();
        for(ProductPojo product : products){
            int qty = cartDao.getCartItemCount(userName,product.getProdId());
            map.put(product.getProdId(), qty);
        }

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        request.setAttribute("userName", userName);
        request.setAttribute("message", message);
        request.setAttribute("products", products);
        request.setAttribute("map", map);
        rd.forward(request, response);
    }
}