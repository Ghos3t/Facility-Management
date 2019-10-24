package MAC_Facility.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MAC_Facility.data.FacilityDAO;
import MAC_Facility.model.Facility;
import MAC_Facility.model.FacilityError;
import MAC_Facility.model.MARForm;


@WebServlet("/FacilityController")
public class FacilityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private void getCompanyParam (HttpServletRequest request, Facility facility) {
		facility.setFacility(request.getParameter("idfacility"),request.getParameter("facility_name"),request.getParameter("Duration"),request.getParameter("Type"));  
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		session.removeAttribute("errorMsgs");
/*//		List companies
		if (action.equalsIgnoreCase("listfacilities")) {
			ArrayList<Facility> facilityInDB = new ArrayList<Facility>();
			facilityInDB=FacilityDAO.listfacilities();
			session.setAttribute("FACILITIES", facilityInDB);				
			getServletContext().getRequestDispatcher("/listComapny.jsp").forward(request, response);
		}
		else // redirect all other gets to post
			doPost(request,response);*/
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		Facility facility = new Facility();
		FacilityError CerrorMsgs = new FacilityError();
		int selectedFacilityIndex;
		session.removeAttribute("errorMsgs");
		
		if(action.equalsIgnoreCase("listfacilities")) {
			//getCompanyParam(request,facility);
			//facility.validateFacility(action,facility,CerrorMsgs);
			ArrayList<Facility> result = FacilityDAO.listfacilities();
			session.setAttribute("FACILITIES", result);
			/*if (!CerrorMsgs.getErrorMsg().equals("")) {// if error messages
				getCompanyParam(request,facility);
				session.setAttribute("errorMsgs", CerrorMsgs);
				url="/listCompany.jsp";
			}*/
			url = "/formAvailability.jsp";
			
		}else if (action.equalsIgnoreCase("ADDFacility") ) {  
			getCompanyParam(request,facility);
			facility.validateFacility(action,facility,CerrorMsgs);
			session.setAttribute("facility", facility);
			if (!CerrorMsgs.getErrorMsg().equals("")) {// if error messages
				getCompanyParam(request,facility);
				session.setAttribute("errorMsgs", CerrorMsgs);
				url="/listCompany.jsp";
			}
			
		}

		else 
		  if (action.equalsIgnoreCase("searchMAR") ) {
			/*String facilityname = request.getParameter("facility_name");   
			String facilityID = request.getParameter("idfacility");
			session.removeAttribute("errorMsgs");
			facility.setFacility(facilityID,facilityname,"","");
			facility.validateFacility(action,facility, CerrorMsgs);

			ArrayList<Facility> facilityInDB = new ArrayList<Facility>();
			if (CerrorMsgs.getErrorMsg().equals("")) {
				if (!facilityID.equals(""))
					facilityInDB=FacilityDAO.searchMAR(facilityID);
				else
					facilityInDB=FacilityDAO.searchfacilities(facilityname);
			 */
			  ArrayList<MARForm> result = FacilityDAO.searchMAR("searchMAR");
				session.setAttribute("FACILITIES", result);
				session.removeAttribute("facility");
				url="/searchMAR.jsp";
			}
		  else 
			  if (action.equalsIgnoreCase("searchAssignedMAR") ) {
				/*String facilityname = request.getParameter("facility_name");   
				String facilityID = request.getParameter("idfacility");
				session.removeAttribute("errorMsgs");
				facility.setFacility(facilityID,facilityname,"","");
				facility.validateFacility(action,facility, CerrorMsgs);

				ArrayList<Facility> facilityInDB = new ArrayList<Facility>();
				if (CerrorMsgs.getErrorMsg().equals("")) {
					if (!facilityID.equals(""))
						facilityInDB=FacilityDAO.searchMAR(facilityID);
					else
						facilityInDB=FacilityDAO.searchfacilities(facilityname);
				 */
				  ArrayList<MARForm> result = FacilityDAO.searchAssignedMAR();
					session.setAttribute("FACILITIES", result);
					session.removeAttribute("facility");
					url="/searchMAR.jsp";
				}
			else {
				session.setAttribute("facility", facility);
				session.setAttribute("errorMsgs", CerrorMsgs);
				url="/searchMAR.jsp";				
			}
		/*
			else 
				  if (action.equalsIgnoreCase("assignedMAR") ) {
					String facilityname = request.getParameter("facility_name");   
					String facilityID = request.getParameter("idfacility");
					session.removeAttribute("errorMsgs");
					facility.setFacility(facilityID,facilityname,"","");
					facility.validateFacility(action,facility, CerrorMsgs);

					ArrayList<Facility> facilityInDB = new ArrayList<Facility>();
					if (CerrorMsgs.getErrorMsg().equals("")) {
						if (!facilityID.equals(""))
							facilityInDB=FacilityDAO.assignedMAR();
						else
							facilityInDB=FacilityDAO.assignedMAR();

						session.setAttribute("FACILITIES", facilityInDB);
						session.removeAttribute("facility");
						url="/searchMAR.jsp";
					}
					else {
						session.setAttribute("facility", facility);
						session.setAttribute("errorMsgs", CerrorMsgs);
						url="/searchMAR.jsp";				
					}
				}*/
		 
		 /* else {
			  if(action.equalsIgnoreCase("AssignMAR")) {
				  String facilityname=request.getParameter("facility_name");
				  String facilityID=request.getParameter("idfacility");
				  session.removeAttribute("errorMsgs");
				  facility.setFacility(facilityID, facilityname);
			  }
		  }*/
		

				
			
		/* { //action=listSpecificCompany
			ArrayList<Facility> facilityInDB = new ArrayList<Facility>();
			Facility selectedFacility = new Facility();
			if (request.getParameter("radioCompany")!=null) {
				selectedFacilityIndex = Integer.parseInt(request.getParameter("radioCompany")) - 1;
				facilityInDB=FacilityDAO.listfacilities(); 
				selectedFacility.setFacility(	facilityInDB.get(selectedFacilityIndex).getIDFacility(),facilityInDB.get(selectedFacilityIndex).getfacility_name(), 
						facilityInDB.get(selectedFacilityIndex).getType(), facilityInDB.get(selectedFacilityIndex).getvenue());
				session.setAttribute("FACILTIES", selectedFacility);
				url="/ListSpecificCompany.jsp";					
			}*/
	/*		else { // determine if Submit button was clicked without selecting a company
				if (request.getParameter("listfacilities")!=null) {
					String errorMsgs =  "Please select a company";
					session.setAttribute("errorMsgs",errorMsgs);
					url="/listCompany.jsp";					
				}
				else { //view button was used instead of radio button
					facilityInDB=FacilityDAO.searchfacility(request.getParameter("idfacility"));
					selectedFacility.setFacility(	facilityInDB.get(0).getIDFacility(), facilityInDB.get(0).getfacility_name(), 
							facilityInDB.get(0).getType(), facilityInDB.get(0).getvenue());
					session.setAttribute("FACILITIES", selectedFacility);
					url="/ListSpecificCompany.jsp";					
				}
			}
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}*/
	
			getServletContext().getRequestDispatcher(url).forward(request, response);
	}}
