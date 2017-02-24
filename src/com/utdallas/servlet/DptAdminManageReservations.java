package com.utdallas.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utdallas.classes.ReservedRecord;
import com.utdallas.models.CancelReservation;
import com.utdallas.models.GetReservation;
import com.utdallas.models.MakeReservation;

/**
 * Servlet implementation class DptAdminManageReservations
 */
@WebServlet("/DptAdminManageReservations")
public class DptAdminManageReservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DptAdminManageReservations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usernameNew = request.getParameter("usernameNew");
		
		String username = request.getParameter("username");
		String task = request.getParameter("task");
		String departmentName = request.getParameter("departmentName");
		String facilityId = request.getParameter("facilityId");
		String reservationId = request.getParameter("reservationId");

		if(task.equals("cancel")){
			CancelReservation cancelReservation = new CancelReservation();
			cancelReservation.cancel(departmentName, facilityId, reservationId);
			GetReservation getReservation= new GetReservation();
			ArrayList<ReservedRecord> records=getReservation.getReserveListByDpt(departmentName, facilityId);
			request.setAttribute("records", records);
			request.getRequestDispatcher("DptMgrReservationManagement.jsp?username="+username+"&departmentName="+departmentName+"&facilityId="+facilityId).forward(request, response);
		}
		if(task.equals("edit")){
			
			MakeReservation reservation = new MakeReservation();
			reservation.editReservation(departmentName, facilityId, reservationId, usernameNew);
			GetReservation getReservation= new GetReservation();
			ArrayList<ReservedRecord> records=getReservation.getReserveListByDpt(departmentName, facilityId);
			request.setAttribute("records", records);
			request.getRequestDispatcher("DptMgrReservationManagement.jsp?username="+username+"&departmentName="+departmentName+"&facilityId="+facilityId).forward(request, response);
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
