
package com.velociter.ems;

 

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.ManagerPojo;

 

/**

* Servlet implementation class ManagerServlet

*/

@WebServlet(name = "ManagerServlet", urlPatterns = { "/ManagerServlet" })

public class ManagerServlet extends HttpServlet {

     private static final long serialVersionUID = 1L;

 

     DatabaseConnection dbConnection = new DatabaseConnection();

     Connection connection = dbConnection.getConnection();

 

     /**

     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse

     *      response)

     */

     protected void doGet(HttpServletRequest request, HttpServletResponse response)

                throws ServletException, IOException {

           List<ManagerPojo> managers = getAllManagers();

           String json = new Gson().toJson(managers);

 

           response.setContentType("application/json");

           response.setCharacterEncoding("UTF-8");

           response.getWriter().write(json);

     }

 

     public List<ManagerPojo> getAllManagers() {

           List<ManagerPojo> managers = new ArrayList<>();

           String query = "SELECT * FROM manager";

           String nameOfManager = "SELECT fname, lname FROM employee WHERE EmpID =?";

           try {

                PreparedStatement pstm = connection.prepareStatement(query);

                ResultSet rs = pstm.executeQuery();

                while (rs.next()) {

                     PreparedStatement pstm2 = connection.prepareStatement(nameOfManager);

                     pstm2.setString(1, rs.getString("managerid"));

                     ResultSet rs2 = pstm2.executeQuery();

                     if (rs2.next()) {

                           ManagerPojo manager = new ManagerPojo();

                           manager.setMgrID(rs.getString("managerid"));

                           manager.setMgrName(rs2.getString("fname") + " " + rs2.getString("lname"));

                           managers.add(manager);

                     }

                }

           } catch (SQLException e) {

                e.printStackTrace();

           }

           return managers;

     }

 

}