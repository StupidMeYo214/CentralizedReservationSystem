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
import com.utdallas.models.DepartmentAdministration;
import com.utdallas.models.GetDepartment;
import com.utdallas.models.UserGetter;

/**
 * Servlet implementation class DepartmentController
 */
@WebServlet("/DepartmentController")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String task = request.getParameter("task");
		String username = request.getParameter("username");
		UserGetter userGetter = new UserGetter();
		User user = userGetter.getUser(username);
		request.setAttribute("user", user);
		
		DepartmentAdministration departmentAdministration = new DepartmentAdministration();

		if(task.equals("create")){
			String departmentName = request.getParameter("departmentName");
			String departmentAddress = request.getParameter("departmentAddress");
			String contactEmail = request.getParameter("contactEmail");
			String contactPhone = request.getParameter("contactPhone");
			String img1 = request.getParameter("img");
			String img = img1.replace("\\", "/");
			
			departmentAdministration.createDepartment(departmentName, departmentAddress, contactEmail, contactPhone, img);
			
			GetDepartment getDepartment = new GetDepartment();
			ArrayList<Department> departments = getDepartment.getDepartmentList();
			request.setAttribute("departments", departments);
			request.getRequestDispatcher("SystemAdminWorkSpace.jsp").forward(request, response);
		}
		if(task.equals("remove")){
			
			String departmentId = request.getParameter("departmentId");
			String departmentName = request.getParameter("departmentName");
			
			departmentAdministration.deleteDepartment(departmentId, departmentName);
			
			GetDepartment getDepartment = new GetDepartment();
			ArrayList<Department> departments = getDepartment.getDepartmentList();
			request.setAttribute("departments", departments);
			request.getRequestDispatcher("SystemAdminWorkSpace.jsp").forward(request, response);
		}
		if(task.equals("edit")){
			
			String departmentId = request.getParameter("departmentId");
			String departmentAddress = request.getParameter("departmentAddress");
			String contactEmail = request.getParameter("contactEmail");
			String contactPhone = request.getParameter("contactPhone");
			String img1 = request.getParameter("img");
			String img = img1.replace("\\", "/");
			
			departmentAdministration.editDepartment(departmentId, departmentAddress, contactEmail, contactPhone, img);
			
			GetDepartment getDepartment = new GetDepartment();
			ArrayList<Department> departments = getDepartment.getDepartmentList();
			request.setAttribute("departments", departments);
			request.getRequestDispatcher("SystemAdminWorkSpace.jsp").forward(request, response);
		}
		if(task.equals("newUser")){
			UserGetter getter = new UserGetter();
			String name = request.getParameter("name");
			String newusername = request.getParameter("newUsername");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String level = request.getParameter("level");
			String address = request.getParameter("address");
			String department = request.getParameter("department");
			String departmentId = request.getParameter("departmentId");
			getter.newUser(name, newusername, password, email, level, address, department, departmentId);
			
			GetDepartment getDepartment = new GetDepartment();
			ArrayList<Department> departments = getDepartment.getDepartmentList();
			request.setAttribute("departments", departments);
			request.getRequestDispatcher("SystemAdminWorkSpace.jsp").forward(request, response);
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
