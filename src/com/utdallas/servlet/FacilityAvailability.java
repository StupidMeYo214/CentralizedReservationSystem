package com.utdallas.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utdallas.classes.Reservation;
import com.utdallas.models.ReservationList;

/**
 * Servlet implementation class FacilityAvailability
 */
@WebServlet("/FacilityAvailability")
public class FacilityAvailability extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacilityAvailability() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String date = request.getParameter("date");
		String departmentName = request.getParameter("departmentName");
		String facilityId = request.getParameter("facilityId");
		String facility = request.getParameter("facility");
		
		ReservationList reservationList = new ReservationList();
		ArrayList<Reservation> reservations = reservationList.getReserveList(departmentName, facilityId,date);
		
		request.setAttribute("reservations", reservations);
		request.setAttribute("department", departmentName);
		request.setAttribute("facilityId", facilityId);
		request.setAttribute("facility", facility);
		request.setAttribute("date", date);
		request.getRequestDispatcher("FacilityAvailability.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
