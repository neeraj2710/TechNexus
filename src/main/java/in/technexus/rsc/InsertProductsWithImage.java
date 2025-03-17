/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.technexus.rsc;

/**
 *
 * @author KingMardoX
 */
import java.sql.*;
import java.io.*;
import org.json.*;

public class InsertProductsWithImage {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        
        try {
            // 1. Load Oracle JDBC driver (ojdbc6.jar)
//            Class.forName("oracle.jdbc.OracleDriver");

            // 2. Establish connection to Oracle DB (demo user credentials)
            String url = "jdbc:oracle:thin:@localhost:1521:xe";  // DB URL (change as needed)
            String user = "technexus";  // demo user
            String password = "technexus";  // demo password
            conn = DriverManager.getConnection(url, user, password);
            
            // 3. Prepare to read the JSON file containing product data
            fileReader = new FileReader("D:/Adv Java Project/TechNexus/src/main/java/in/technexus/rsc/products_data.json");
            bufferedReader = new BufferedReader(fileReader);
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonContent.append(line);
            }

            // 4. Convert the JSON content to a JSON array
            JSONArray productsArray = new JSONArray(jsonContent.toString());

            // 5. Prepare the SQL insert statement (BLOB for image)
            String insertSQL = "INSERT INTO products (PID, PNAME, PTYPE, PINFO, PPRICE, PQUANTITY, IMAGE, AVAILABLE) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);

            // 6. Iterate through the products array and insert each product into the database
            for (int i = 0; i < productsArray.length(); i++) {
                JSONObject product = productsArray.getJSONObject(i);

                // Get product data
                String pid = product.getString("PID");
                String pname = product.getString("PNAME");
                String ptype = product.getString("PTYPE");
                String pinfo = product.getString("PINFO");
                double pprice = product.getDouble("PPRICE");
                int pquantity = product.getInt("PQUANTITY");

                // Get image file corresponding to the product (path: "d:/gadgethub/products_image/product_"+pid+".jpg")
                File imageFile = new File("d:/gadgethub/products_image/product_" + pid + ".jpg");
                if (imageFile.exists()) {
                    // Convert the image file to InputStream (for BLOB column)
                    FileInputStream imageInputStream = new FileInputStream(imageFile);
                    pstmt.setBinaryStream(7, imageInputStream, (int) imageFile.length());
                } else {
                    pstmt.setNull(7, Types.BLOB); // If image does not exist, set null
                }

                // Set the rest of the parameters
                pstmt.setString(1, pid);
                pstmt.setString(2, pname);
                pstmt.setString(3, ptype);
                pstmt.setString(4, pinfo);
                pstmt.setDouble(5, pprice);
                pstmt.setInt(6, pquantity);
                pstmt.setString(8, "Y");

                // Execute the insert statement
                pstmt.executeUpdate();
                System.out.println("product added "+pid);
            }

            System.out.println("Data inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close all resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                if (fileReader != null) fileReader.close();
                if (bufferedReader != null) bufferedReader.close();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}

