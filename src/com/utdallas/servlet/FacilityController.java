package com.utdallas.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utdallas.classes.Facility;
import com.utdallas.classes.User;
import com.utdallas.models.GetFacility;
import com.utdallas.models.UserGetter;

/**
 * Servlet implementation class FacilityController
 */
@WebServlet("/FacilityController")
public class FacilityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacilityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GetFacility facilityManager = new GetFacility();
		String task = request.getParameter("task");
		String username = request.getParameter("username");
		UserGetter userGetter = new UserGetter();
		User user = userGetter.getUser(username);
		String dpt = request.getParameter("dpt");
		
		if(task.equals("create")){
			String facilityName = request.getParameter("facilityName");
			String dptId = request.getParameter("dptId");
			String description = request.getParameter("description");
			
			facilityManager.createFacility(facilityName, dpt, dptId, description);
		}
		if(task.equals("remove")){
			String facilityId = request.getParameter("facilityId");
			facilityManager.removeFacility(dpt, facilityId);
		}
		if(task.equals("edit")){
			String facilityId = request.getParameter("facilityId");
			String newName = request.getParameter("newName");
			String newDescription = request.getParameter("newDescription");
			facilityManager.editFacility(dpt, facilityId, newName, newDescription);
		}
		if(task.equals("update")){
			String facilityId = request.getParameter("facilityId");
			facilityManager.updateAvailability(dpt, facilityId);
		}
		
		
		ArrayList<Facility> facilityList = facilityManager.getFacilityList(dpt);
		request.setAttribute("facilityList", facilityList);
		request.setAttribute("user", user);
		request.getRequestDispatcher("DepartmentAdminWorkSpace.jsp?department="+dpt).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
