package com.utdallas.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utdallas.classes.Department;
import com.utdallas.classes.User;
import com.utdallas.models.GetDepartment;
import com.utdallas.models.UserGetter;

/**
 * Servlet implementation class Departments
 */
@WebServlet("/ShowDepartments")
public class DepartmentsRetriever extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentsRetriever() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		UserGetter userGetter = new UserGetter();
		User user = userGetter.getUser(username);
		GetDepartment getDepartment = new GetDepartment();
		ArrayList<Department> departments = getDepartment.getDepartmentList();
		request.setAttribute("user", user);
		request.setAttribute("departments", departments);
		request.getRequestDispatcher("DepartmentSelection.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

}
