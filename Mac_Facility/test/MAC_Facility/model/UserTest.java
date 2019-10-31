package MAC_Facility.model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class UserTest {

	User usr;
	UserErrorMsgs UerrorMsgs;

	@Before
	public void setUp() throws Exception {
		usr = new User();
		UerrorMsgs = new UserErrorMsgs();
	}

	@Test
	@FileParameters("test/User_test_cases.csv")
	public void test(int testcaseNo, String action, String username, String last_name, String first_name, String phone,
			String email, String role, String errorMsg, String usernameError, String firstNameError,
			String lastNameError, String phoneError, String emailError, String roleError) {

		usr.setUser(username, last_name, first_name, phone, email, role);

		usr.validateUser(action, usr, UerrorMsgs);

		assertTrue(errorMsg.equals(UerrorMsgs.getErrorMsg()));
		assertTrue(usernameError.equals(UerrorMsgs.getUsernameError()));
		assertTrue(firstNameError.equals(UerrorMsgs.getFirst_nameError()));
		assertTrue(lastNameError.equals(UerrorMsgs.getLastNameError()));
		assertTrue(phoneError.equals(UerrorMsgs.getPhoneError()));
		assertTrue(emailError.equals(UerrorMsgs.getEmailError()));
		assertTrue(roleError.equals(UerrorMsgs.getRoleError()));

//		fail("Not yet implemented");
	}
}
