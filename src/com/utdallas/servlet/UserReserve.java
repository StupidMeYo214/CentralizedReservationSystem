package com.utdallas.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utdallas.models.MakeReservation;

/**
 * Servlet implementation class UserReserve
 */
@WebServlet("/UserReserve")
public class UserReserve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReserve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String departmentName = request.getParameter("departmentName");
		String facilityId = request.getParameter("facilityId");
		String reservationId = request.getParameter("reservationId");
		String username = request.getParameter("username");

		
		MakeReservation makeReservation = new MakeReservation();
		Boolean limit = makeReservation.makeReservation(departmentName, facilityId, reservationId, username);
		String timesLimit = "0";
		if(limit){
			timesLimit = "1";
		}
		String date = request.getParameter("date");
		String facility = request.getParameter("facility");
		
		request.getRequestDispatcher("/FacilityAvailability?date="+date+"&username="+username+"&departmentName="+departmentName+"&facilityId="+facilityId+"&facility="+facility+"&timesLimit="+timesLimit).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

}
