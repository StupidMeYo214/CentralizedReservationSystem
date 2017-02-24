package com.utdallas.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utdallas.models.CancelReservation;

/**
 * Servlet implementation class ReservationManager
 */
@WebServlet("/ReservationCancelation")
public class ReservationCancelationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationCancelationController() {
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
		
		CancelReservation cancelReservation = new CancelReservation();
		cancelReservation.cancel(departmentName, facilityId, reservationId, username);
		
		request.getRequestDispatcher("/UserManageReservation?username="+username).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
