package com.velociter.ems;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.velociter.ems.helper.GetStateCity;

/**
 * Servlet implementation class CityServlet
 */
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String selectedState = request.getParameter("state");

        GetStateCity getSC = new GetStateCity();

      

        List<String> cityList = getSC.getCities(selectedState);



        // Create an HTML snippet with the city options

        StringBuilder cityOptions = new StringBuilder();

        for (String city : cityList) {

            cityOptions.append("<option value='" + city + "'>" + city + "</option>");

        }



        // Send the HTML snippet as the response

        response.setContentType("text/html");

        response.getWriter().write(cityOptions.toString());

    }

}
