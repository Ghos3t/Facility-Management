package MAC_Facility.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import MAC_Facility.data.RegistrationDAO;
import MAC_Facility.model.*;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		//insert employee
		if (action.equals("save_registration_details")) {
//			if (request.getParameter("insertEmpbutton")!=null) {  //insert employee button pressed
			Registration registration = new Registration();
//			Company company = (Company) session.getAttribute("company"); 
			registration.setRegistration(request.getParameter("states"), request.getParameter("roles"), request.getParameter("first_name"), request.getParameter("last_name"), request.getParameter("contact"), request.getParameter("email"), request.getParameter("uta_id"), request.getParameter("address"), request.getParameter("city"), request.getParameter("zip_code"), request.getParameter("username"), request.getParameter("password"));
			RegistrationErrorMsgs EerrorMsgs = new RegistrationErrorMsgs();
			registration.validateRegistration(registration, EerrorMsgs);
//			registration.setFk_company(company.getIdcompany());
			session.setAttribute("registration",registration);
			session.setAttribute("errorMsgs",EerrorMsgs);
			if (EerrorMsgs.getErrorMsg().equals("")) {
				RegistrationDAO.Register(registration);
				session.removeAttribute("registration");	

			}
				url = "/Registration.jsp"; 
			}
//			else { // done button pressed
//				session.removeAttribute("company");
//				session.removeAttribute("employee");
//				session.removeAttribute("COMPANIES");
//				session.removeAttribute("errorMsgs");
//				url="/index.jsp";
//			}
//		}
		//list employee
//		 else { // (action.equalsIgnoreCase("searchEmployee") )
//			String companyID = request.getParameter("idcompany");
//			ArrayList<Employee> employeesInDB = new ArrayList<Employee>();
//			Company company = new Company();
//			CompanyErrorMsgs CerrorMsgs = new CompanyErrorMsgs();
//			company.setIdcompany(request.getParameter("idcompany"));
//			company.validateCompany(action,company,CerrorMsgs);
//			if (CerrorMsgs.getErrorMsg().equals("")) {
//				employeesInDB=EmployeeDAO.listEmployees(companyID);
//				session.setAttribute("employees", employeesInDB);
//				session.removeAttribute("company");
//				session.removeAttribute("errorMsgs");
//				url="/listEmployee.jsp";
//			}
//			else {
//				session.setAttribute("errorMsgs",CerrorMsgs);
//				session.setAttribute("company", company);
//				url="/searchEmployee.jsp";
//			}
//		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}