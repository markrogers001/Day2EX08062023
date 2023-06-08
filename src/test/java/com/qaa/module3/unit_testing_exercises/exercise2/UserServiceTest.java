package test.java.com.qaa.module3.unit_testing_exercises.exercise2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.qaa.module3.unit_testing_exercises.exercise2.UserService;

class UserServiceTest {
	
	private UserService service;
	
	@BeforeEach
	void setUp() throws Exception {
		service = new UserService();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		service = null;
	}

	@Test
	void testRegisterUsernameNull() {
		
		//Arrange
		String username = null;
		String password = "Codes123";
		String expected = "Username must not be null";
		
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
			service.register(username, password);
		}, "IllegalArgumentException was expected");
		
		assertEquals(expected, iae.getMessage());
	}
	
	@Test
	void testRegisterUsernameEmpty() {
		
		//Arrange
		String username = "   ";
		String password = "Codes123";
		String expected = "Username must not be whitespace only";
		
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
			service.register(username, password);
		}, "IllegalArgumentException was expected");
		
		assertEquals(expected, iae.getMessage());
	}
	
	@Test
	void testRegisterPasswordEmpty() {
		
		//Arrange
		String username = "bobby";
		String password = "  ";
		String expected = "Password must not be whitespace only";
		
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
			service.register(username, password);
		}, "IllegalArgumentException was expected");
		
		assertEquals(expected, iae.getMessage());
	}
	
	@Test
	void testRegisterPasswordNull() {
		
		//Arrange
		String username = "bobby";
		String password = null;
		String expected = "Password must not be null";
		
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
			service.register(username, password);
		}, "IllegalArgumentException was expected");
		
		assertEquals(expected, iae.getMessage());
	}
	
	@Test
	void testRegisterUsernameLessThan4() {
		
		//Arrange
		String username = "bob";
		String password = "Codes123";
		String expected = "Username must contain at least 4 characters";
		
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
			service.register(username, password);
		}, "IllegalArgumentException was expected");
		
		assertEquals(expected, iae.getMessage());
	}
	
	@Test
	void testRegisterPasswordLessThan6() {
		
		//Arrange
		String username = "bobby";
		String password = "Code1";
		String expected = "Password must contain at least 6 characters";
		
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
			service.register(username, password);
		}, "IllegalArgumentException was expected");
		
		assertEquals(expected, iae.getMessage());
	}
	
	@Test
	void testRegisterPasswordNoUpper() {
		
		//Arrange
		String username = "bobby";
		String password = "code123";
		String expected = "Password must contain at least 1 uppercase character";
		
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
			service.register(username, password);
		}, "IllegalArgumentException was expected");
		
		assertEquals(expected, iae.getMessage());
	}
	
	@Test
	void testRegisterPasswordNoLower() {
		
		//Arrange
		String username = "bobby";
		String password = "CODE123";
		String expected = "Password must contain at least 1 lowercase character";
		
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
			service.register(username, password);
		}, "IllegalArgumentException was expected");
		
		assertEquals(expected, iae.getMessage());
	}
	
	@Test
	void testRegisterPasswordNodigit() {
		
		//Arrange
		String username = "bobby";
		String password = "CODEabc";
		String expected = "Password must contain at least 1 number character";
		
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
			service.register(username, password);
		}, "IllegalArgumentException was expected");
		
		assertEquals(expected, iae.getMessage());
	}
	
	@Test
	void testRegisterValidCombo() {
		
		//Arrange
		String username = "bobby";
		String password = "Code123";
		String expected = "bobby";
		
		
		assertEquals(expected, service.register(username, password));
	}
	
	@Test
	void testRegisterDuplicateUser() {
		
		//Arrange
		String username = "bobby";
		String password = "CODEabc1";
		String expected = "Username already exists";
		
		String newUser = service.register(username, password);
		
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
			service.register(username, password);
		}, "IllegalArgumentException was expected");
		
		assertEquals(expected, iae.getMessage());
	}

	@Test
	void testLoginuserNull() {
		
		String username = null;
		String password = "CODEabc1";
		String expected = "Username and password must not be null";
		
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
			service.login(username, password);
		}, "IllegalArgumentException was expected");
		
		assertEquals(expected, iae.getMessage());
	}
	
	@Test
	void testLoginPasswordNull() {
		
		String username = "bobby";
		String password = null;
		String expected = "Username and password must not be null";
		
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
			service.login(username, password);
		}, "IllegalArgumentException was expected");
		
		assertEquals(expected, iae.getMessage());
	}
	
	@Test
	void testLoginUserEmpty() {
		
		String username = "  ";
		String password = "Codes123";
		String expected = "Username and password must not be empty";
		
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
			service.login(username, password);
		}, "IllegalArgumentException was expected");
		
		assertEquals(expected, iae.getMessage());
	}
	
	@Test
	void testLoginPasswordEmpty() {
		
		String username = "bobby";
		String password = "";
		String expected = "Username and password must not be empty";
		
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
			service.login(username, password);
		}, "IllegalArgumentException was expected");
		
		assertEquals(expected, iae.getMessage());
	}
	
	@Test
	void testLoginValid() {
		
		String username = "bobby";
		String password = "Codes123";
		String expected = "bobby";
		
//		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
//			service.login(username, password);
//		}, "IllegalArgumentException was expected");
		
		service.register(username, password);
		
		assertEquals(expected, service.login(username, password));
	}
	
	@Test
	void testLoginInValidUsernmae() {
		
		String username = "bobby";
		String password = "Codes123";
		String expected = "Invalid username supplied";
		service.register(username, password);
		
		RuntimeException iae = assertThrows(RuntimeException.class, () -> {
			service.login("bertie", password);
		}, "RuntimeException was expected");
		
			
		assertEquals(expected, iae.getMessage());
	}
	
	@Test
	void testLoginPasswordInvalid() {
		
		String username = "bobby";
		String password = "Codes123";
		String expected = "Invalid password supplied";
		service.register(username, password);
		
		IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> {
			service.login(username, "Knees12");
		}, "IllegalArgumentException was expected");
		
		assertEquals(expected, iae.getMessage());
	}

}
