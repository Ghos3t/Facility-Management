package MAC_Facility.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MAC_Facility.data.CreateMarDAO;
import MAC_Facility.data.LoginDAO;
import MAC_Facility.data.RegistrationDAO;
import MAC_Facility.model.*;
import MAC_Facility.controller.*;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		//insert employee
		if (action.equals("save_mar_details")) {
//			if (request.getParameter("insertEmpbutton")!=null) {  //insert employee button pressed
			MARForm mf = new MARForm();
			mf.setMARDetails(request.getParameter("facility_type"), request.getParameter("facility_name"), request.getParameter("description"), request.getParameter("reported_by"), request.getParameter("date"),request.getParameter("time"), request.getParameter("mar"));
			MARFormErrorMsgs MFEerrorMsgs = new MARFormErrorMsgs();
			mf.validateMARForm(mf, MFEerrorMsgs);
			session.setAttribute("mferrorMsgs",MFEerrorMsgs);
			String login_username = (String) session.getAttribute("login_username"); 
			mf.setFk_username(login_username);
			if (MFEerrorMsgs.getErrorMsg().equals("")) {
				CreateMarDAO.createMar(mf);
			}
//				session.removeAttribute("registration");				
				url = "/MARForm.jsp"; 
			}
//			
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}