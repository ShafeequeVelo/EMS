package com.velociter.ems;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.velociter.ems.helper.Operations;
import com.velociter.ems.pojo.RegistrationPojo;
 

/**

* Servlet implementation class UpdatePassword

*/

@WebServlet(name = "UpdatePasswordServlet", urlPatterns = {"/UpdatePasswordServlet"})

public class UpdatePasswordServlet extends HttpServlet {

            private static final long serialVersionUID = 1L;

 

            /**

            * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse

            *      response)

            */

            protected void doPost(HttpServletRequest request, HttpServletResponse response)

                                    throws ServletException, IOException {

                        RegistrationPojo registrationPojo = new RegistrationPojo();

                        registrationPojo.setEmpID(request.getParameter("empid"));

                        registrationPojo.setPassword(request.getParameter("Password"));

                        Operations op = new Operations();

                        int i = op.updatePassword(registrationPojo);

                        if(i > 0) {

                                   // response.sendRedirect("ControllerServlet?submit=UpdatePasswordServlet");
                        	request.getRequestDispatcher("ControllerServlet?submit=UpdatePasswordServlet").forward(request, response);

                        }

                        else {

                                    response.sendRedirect("ControllerServlet?submit=ChangePassword");

                        }

            }

 

}