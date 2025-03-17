package in.technexus.servlet;

import in.technexus.dao.impl.ProductDaoImpl;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "ShowImageServlet", value = "/ShowImageServlet")
public class ShowImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String prodId = request.getParameter("pid");
        byte[] arr = new ProductDaoImpl().getImage(prodId);
        if(arr == null) {
            File fnew = new File(request.getServletContext().getRealPath("media/images/noimage.jpg"));
            BufferedImage originalImage = ImageIO.read(fnew);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage,"jpg",baos);
            arr = baos.toByteArray();
        }
        ServletOutputStream stream = response.getOutputStream();
        stream.write(arr);
    }
}