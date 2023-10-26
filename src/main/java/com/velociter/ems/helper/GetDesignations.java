package com.velociter.ems.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.velociter.ems.pojo.DesignationsPojo;
import com.velociter.ems.pojo.RegistrationPojo;

import jakarta.servlet.http.HttpSession;
import oracle.net.aso.p;

public class GetDesignations {

	DatabaseConnection dbConnection = new DatabaseConnection();

	public List<String> getDesignations() {

		Connection connection = dbConnection.getConnection();

		List<String> designationList = new ArrayList<String>();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DESIGNATIONS");

			ResultSet resultSet = preparedStatement.executeQuery();

			DesignationsPojo designationsPojo = new DesignationsPojo();

			while (resultSet.next()) {

				designationsPojo.setDesignation_ID(resultSet.getString("Designation_ID"));

				designationsPojo.setDesignation_Name(resultSet.getString("Designation_Name"));

				designationList.add(designationsPojo.getDesignation_Name());
				System.out.println(designationsPojo.getDesignation_Name());

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if (connection != null) {

				System.out.print("in finally, in getDesignations");

			}

		}

		return designationList;

	}
	
	public List<String> getDesignationForAdmin() {

		Connection connection = dbConnection.getConnection();

		List<String> designationList = new ArrayList<String>();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DESIGNATIONS WHERE DESIGNATION_ID = 2");

			ResultSet resultSet = preparedStatement.executeQuery();

			DesignationsPojo designationsPojo = new DesignationsPojo();

			while (resultSet.next()) {

				designationsPojo.setDesignation_ID(resultSet.getString("Designation_ID"));

				designationsPojo.setDesignation_Name(resultSet.getString("Designation_Name"));

				designationList.add(designationsPojo.getDesignation_Name());

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if (connection != null) {

				System.out.print("in finally, in getDesignationForAdmin");

			}

		}

		return designationList;

	}
	
	public List<RegistrationPojo> getManagers(){
		
		Connection connection = dbConnection.getConnection();

		List<RegistrationPojo> managerList = new ArrayList<RegistrationPojo>();
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMP_DESIGNATION WHERE manager_ID = 1");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {

				DesignationsPojo designationsPojo = new DesignationsPojo();

				designationsPojo.setEmployee_desigID(Integer.parseInt(resultSet.getString("empid")));
				
				RegistrationPojo registrationPojo = getEmpByID(Integer.toString(designationsPojo.getEmployee_desigID()));
				
				managerList.add(registrationPojo);
				
			
				
			}
			if(managerList.size() > 0) {
				return managerList;
			}
		}
		 catch (Exception e) {

             e.printStackTrace();

        }
		
		return null;
		
	}
	

		public RegistrationPojo getEmpByID(String ID) {
			
			Connection connection = dbConnection.getConnection();
			
           RegistrationPojo registrationPojo = new RegistrationPojo();
           
           try {

                PreparedStatement preparedStatement = connection.prepareStatement("select * from Employee where empID = ?");

                preparedStatement.setString(1, ID);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {

 

                	registrationPojo.setEmpID(resultSet.getString("empid"));;

                	registrationPojo.setfName(resultSet.getString("fName"));

                	registrationPojo.setlName(resultSet.getString("lName"));

                	registrationPojo.setAge(Short.parseShort(resultSet.getString("Age")));

                	registrationPojo.setGender(resultSet.getString("Gender"));
                	
                	registrationPojo.setEmail(resultSet.getString("Email"));

                	registrationPojo.setPhone(resultSet.getString("Phone"));

 

                     return registrationPojo;

 

                } else {

                     return null;
                }

 

           } catch (Exception e) {

                e.printStackTrace();

           }
		return null; 
 
		}
	
		public List<String> getDesignationForManager() {

			Connection connection = dbConnection.getConnection();

			List<String> designationList = new ArrayList<String>();

			try {

				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DESIGNATIONS WHERE DESIGNATION_ID > 2");

				ResultSet resultSet = preparedStatement.executeQuery();

				DesignationsPojo designationsPojo = new DesignationsPojo();

				while (resultSet.next()) {

					designationsPojo.setDesignation_ID(resultSet.getString("Designation_ID"));

					designationsPojo.setDesignation_Name(resultSet.getString("Designation_Name"));

					designationList.add(designationsPojo.getDesignation_Name());

				}

			} catch (SQLException e) {

				e.printStackTrace();

			} finally {

				if (connection != null) {

					System.out.print("in finally, in getDesignationForManager");

				}

			}

			return designationList;

		}
		
		public String determineEmpDesignation(String empID) throws SQLException {
			
			Connection connection = dbConnection.getConnection();
			
			DesignationsPojo designationsPojo = new DesignationsPojo();
			
			String empDesgination = null;
			
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from emp_Designation WHERE empid = ?");
			
			preparedStatement.setString(1, empID);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			try {
				if(resultSet.next()){
					
					empDesgination = resultSet.getString("Designation");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return empDesgination;
			
		}
		
		public List<RegistrationPojo> getEmpForMgr(String ID){
			
			Connection connection = dbConnection.getConnection();

			List<RegistrationPojo> managerList = new ArrayList<RegistrationPojo>();
			
			try {
				
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMP_DESIGNATION WHERE manager_ID = ?");
				
				preparedStatement.setString(1, ID);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {

					DesignationsPojo designationsPojo = new DesignationsPojo();

					designationsPojo.setEmployee_desigID(Integer.parseInt(resultSet.getString("empid")));
					
					RegistrationPojo registrationPojo = getEmpByID(Integer.toString(designationsPojo.getEmployee_desigID()));
					
					managerList.add(registrationPojo);
					
				
					
				}
				if(managerList.size() > 0) {
					return managerList;
				}
			}
			 catch (Exception e) {

	             e.printStackTrace();

	        }
			
			return null;
			
		}
		
}
