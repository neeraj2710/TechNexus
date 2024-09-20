package in.technexus.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IDUtil {

    public static String generateProdId(){
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String prodId = sdf.format(today);
        prodId = "P" + prodId;
        return prodId;
    }

    public static String generateTransId(){
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String transId = sdf.format(today);
        transId = "T" + transId;
        return transId;
    }
}
