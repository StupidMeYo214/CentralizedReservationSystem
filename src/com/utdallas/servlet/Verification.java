package com.utdallas.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utdallas.classes.Department;
import com.utdallas.classes.Facility;
import com.utdallas.classes.User;
import com.utdallas.models.GetDepartment;
import com.utdallas.models.GetFacility;
import com.utdallas.models.VerificationMachine;

/**
 * Servlet implementation class Verification
 */
@WebServlet("/Verification")
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userNameIn;
		String passwordIn;
		
		userNameIn = request.getParameter("userNameIn");
		
		passwordIn = request.getParameter("passwordIn");
		
		VerificationMachine verificationMachine = new VerificationMachine();
		boolean isLegal = verificationMachine.isLegal(userNameIn, passwordIn);
		if(!isLegal)
		{
			request.setAttribute("Legal", isLegal);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		// if the user is legal user 1.set user info into User Class 2.Dispatch to different services
		else{
			User user = verificationMachine.getUser();
			String level = user.getLevel();
			request.setAttribute("User", user);
			if(level.equals("1"))
			{
				GetDepartment getDepartment = new GetDepartment();
				ArrayList<Department> departments = getDepartment.getDepartmentList();
				request.setAttribute("user", user);
				request.setAttribute("departments", departments);
				request.getRequestDispatcher("SystemAdminWorkSpace.jsp").forward(request, response);
			}
			else if(level.equals("2"))
			{
				String department = user.getDepart();
				GetFacility getFacilities = new GetFacility();
				ArrayList<Facility> facilityList = getFacilities.getFacilityList(department);
				request.setAttribute("facilityList", facilityList);
				request.setAttribute("user", user);
				request.getRequestDispatcher("DepartmentAdminWorkSpace.jsp?department="+department).forward(request, response);
			}
			else {
				String name = user.getName();
				GetDepartment getDepartment = new GetDepartment();
				ArrayList<Department> departments = getDepartment.getDepartmentList();
				request.setAttribute("user", user);
				request.setAttribute("departments", departments);
				//request.getRequestDispatcher("DepartmentSelection.jsp?name="+name).forward(request, response);
				request.getRequestDispatcher("DepartmentSelection.jsp").forward(request, response);
			}
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
