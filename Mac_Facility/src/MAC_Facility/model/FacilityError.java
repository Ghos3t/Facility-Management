package MAC_Facility.model;



public class FacilityError {
	private String errorMsg;
	private String FacilityIDError;
	private String FacilityNameError;
	private String TypeError;
	private String DurationError;
	
	
	public FacilityError() {
		this.errorMsg = "";
		this.FacilityIDError = "";
		this.FacilityNameError = "";
		this.TypeError = "";
		this.DurationError = "";
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {
		if (!FacilityIDError.equals("") || !FacilityNameError.equals("") || !TypeError.equals("") || !DurationError.equals(""))
			this.errorMsg = "Please correct the following errors";
	}
	public String getFacilityIDError() {
		return FacilityIDError;
	}
	public void setFacilityIDError(String FacilityIDError) {
		this.FacilityIDError = FacilityIDError;
	}
	public String getFacilityNameError() {
		return FacilityNameError;
	}
	public void setFacilityNameError(String FacilityNameError) {
		this.FacilityNameError = FacilityNameError;
	}
	public String getTypeError() {
		return TypeError;
	}
	public void setTypeError(String Typeerror) {
		this.TypeError = Typeerror;
	}
	public String getDurationError() {
		return DurationError;
	}
	public void setDurationError(String DurationError) {
		this.DurationError = DurationError;
	}

}

