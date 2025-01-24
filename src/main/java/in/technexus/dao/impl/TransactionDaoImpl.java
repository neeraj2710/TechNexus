package in.technexus.dao.impl;

import in.technexus.dao.TransactionDao;
import in.technexus.utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDaoImpl implements TransactionDao {

//    returns only the user ID related to the particular transaction ID
    @Override
    public String getUserId(String transId) {
        String userId = "";
        Connection conn = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select useremail from transactions where transid=?");
            ps.setString(1, transId);
            rs = ps.executeQuery();
            if(rs.next()) {
                userId = rs.getString("useremail");
            }
        } catch (SQLException e) {
            System.out.println("Error in getUserId(TransactionDaoImpl): "+e.getMessage());
            e.printStackTrace();
        }
//        closing resources
        DBUtil.closeStatement(ps);
        DBUtil.closeResultSet(rs);
        return userId;
    }
}
