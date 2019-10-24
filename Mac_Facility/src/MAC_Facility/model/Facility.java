package MAC_Facility.model;

import MAC_Facility.data.FacilityDAO;

public class Facility {

	private static final long serialVersionUID = 3L;
	public String idfacility;
	public String facility_name;
	public String Duration;
	public String Type;
	
	public void setFacility (String idfacility, String facility_name,String Type , String venue) {
		setIDFacility(idfacility);
		setFacility_name(facility_name);
		setType(Type);
		setVenue(venue);
	}
	
	public String getIDFacility() {
		return idfacility;
	}
	public void setIDFacility(String idfacility) {
		this.idfacility = idfacility;
	}
	
	public String getfacility_name() {
		return facility_name;
	}
	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}
	public String getDuration() {
		return Duration;
	}
	public void setType(String Duration) {
        this.Duration = Duration;
	}
	
	public String getType() {
		return Type;
	}
	public void setVenue(String Type ) {
		this.Type = Type;
	}

	public void validateFacility (String action, Facility facility, FacilityError errorMsgs) {
		if (action.equals("saveCompany")) {
			errorMsgs.setFacilityIDError(validateIdcompany(action,facility.getIDFacility()));
			errorMsgs.setFacilityNameError(validateFacility_name(facility.getfacility_name()));
			errorMsgs.setTypeError(validateType(facility.getType()));
			errorMsgs.setDurationError(validatevenue(facility.getDuration()));
			errorMsgs.setErrorMsg();
		}
		else
			if (action.equals("searchCompany")) {
				if (facility_name.equals("") && idfacility.equals("")) 
					errorMsgs.setFacilityNameError("Both Facility Name and Facity ID cannot be blank");
				else
					if (!idfacility.equals(""))
						errorMsgs.setFacilityIDError(validateIdcompany(action, idfacility));
				errorMsgs.setErrorMsg();				
			}
			else { //action=searchEmployee
				if (idfacility.equals(" ")) 
					errorMsgs.setFacilityIDError("Facility ID cannot be blank");
				else
					errorMsgs.setFacilityIDError(validateIdcompany(action,idfacility));
				errorMsgs.setErrorMsg();
			}
	}

	private String validateIdcompany(String action, String idfacility) {
		String result="";
		if (!isTextAnInteger(idfacility))
			result="Your facility ID must be a number";
		else
			if (action.equals("ADDFacility")) {
				if (!stringSize(idfacility,3,16))
					result= "Your facility Id must between 3 and 16 digits";
				/*else
					if (!FacilityDAO.FacilityUniqueID(idfacility))
						result="facility ID already in database";*/
			}
		return result;
	}
	
	private String validateFacility_name(String facility_name) {
		String result="";
		if (!stringSize(facility_name,3,45))
			result= "Your facility Name must between 3 and 45 digits";
		else
			if (Character.isLowerCase(facility_name.charAt(0)))
				result="Your facility name must start with a capital letter";
		return result;		
	}
	
	private String validateType(String Type) {
		String result="";
		if (!stringSize(Type,3,45))
			result="Type Should be arounf 3 to 24 characters";
		else
			if (Character.isLowerCase(facility_name.charAt(0)))
				result="Your facility name must start with a capital letter";
		
		return result;		
	}
	
	private String validatevenue(String Venue) {
		String result=" ";
		if (!stringSize(Venue,3,45))
			result="Type Should be arounf 3 to 24 characters";
		else
			if (Character.isLowerCase(facility_name.charAt(0)))
				result="Your facility name must start with a capital letter";
		
		
		return result;		
	}

//	This section is for general purpose methods used internally in this class
	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
	private boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}

}

