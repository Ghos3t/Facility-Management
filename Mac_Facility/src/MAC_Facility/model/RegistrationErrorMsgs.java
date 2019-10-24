package MAC_Facility.model;

public class RegistrationErrorMsgs {

	private String errorMsg;
	private String first_nameError;
	private String last_nameError;
	private String contactError;
	private String emailError;
	private String utaIDerror;
	private String addressError;
	private String cityError;
	private String zipcodeError;
	private String usernameError;
	private String passwordError;
//	private String roleError;
	
	
	public RegistrationErrorMsgs() {
		this.errorMsg = "";
		this.first_nameError = "";
		this.last_nameError = "";
		this.contactError = "";
		this.emailError = "";
		this.utaIDerror = "";
		this.addressError = "";
		this.cityError = "";
		this.zipcodeError = "";
		this.usernameError = "";
		this.passwordError = "";
//		this.roleError = "";
		
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {
		if (!first_nameError.equals("") || !last_nameError.equals("") || !contactError.equals("") || !emailError.equals("") || !utaIDerror.equals("") || !addressError.equals("") || !cityError.equals("") || !zipcodeError.equals("") || !usernameError.equals("") || !passwordError.equals(""))   
			this.errorMsg = "Please correct the following errors";
	}
	public String getfirst_nameError() {
		return first_nameError;
	}
	public void setfirst_nameError(String first_nameError) {
		this.first_nameError = first_nameError;
	}
	public String getlast_nameError() {
		return last_nameError;
	}
	
	public void setlast_nameError(String last_nameError) {
		this.last_nameError = last_nameError;
	}
	public void setcontactError(String contactError) {
		this.contactError = contactError;
	}
	public String getcontactError() {
		return contactError;
	}
	public void setemailError(String emailError) {
		this.emailError = emailError;
	}
	public String getemailError() {
		return emailError;
	}
	
	public String getutaIDError() {
		return utaIDerror;
	}
	public void setutaIDerror(String utaIDError) {
		this.utaIDerror = utaIDerror;
	}
	public String getaddressError() {
		return addressError;
	}
	public void setaddressError(String addressError) {
		this.addressError = addressError;
	}
	public String getcityError() {
		return cityError;
	}
	public void setcityError(String cityError) {
		this.cityError = cityError;
	}
	
	public String getzipcodeError() {
		return zipcodeError;
	}
	public void setzipcodeError(String zipcodeError) {
		this.zipcodeError = zipcodeError;
	}
	public String getusernameError() {
		return usernameError;
	}
	
	public void setusernameError(String usernameError) {
		this.usernameError = usernameError;
	}
	public void setpasswordError(String passwordError) {
		this.passwordError = passwordError;
	}
	public String getpasswordError() {
		return passwordError;
	}
//	public void setroleError(String roleError) {
//		this.roleError = roleError;
//	}
//	public String getroleError() {
//		return roleError;
//	}
}