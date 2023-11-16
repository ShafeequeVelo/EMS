package com.velociter.ems.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.velociter.ems.pojo.RegistrationPojo;

public class Operations {
	
	public int updatePassword(RegistrationPojo rp) {

        int i = 0;
        
        Connection connection = DatabaseConnection.getConnection();

        String updatePassword = "UPDATE EMPLOYEE SET PASSWORD=? WHERE EMPID=?";
        
        PreparedStatement pstm = null;

        try {

              pstm = connection.prepareStatement(updatePassword);

             pstm.setString(1, rp.getPassword());

             pstm.setString(2, rp.getEmpID());

             i = pstm.executeUpdate();



        } catch (SQLException e) {

             e.printStackTrace();

        }
        finally {
        	DatabaseConnection.closeCon(pstm, connection);
		}
     return i;

  }

}
