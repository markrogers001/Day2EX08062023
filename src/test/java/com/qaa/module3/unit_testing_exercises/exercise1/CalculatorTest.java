package test.java.com.qaa.module3.unit_testing_exercises.exercise1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.qaa.module3.unit_testing_exercises.exercise1.Calculator;;

class CalculatorTest {
	
	Calculator cal;
	
	@BeforeEach
	void setUp() {
		cal = new Calculator();
	}
	
	@AfterEach
	void tearDown() {
		cal = null;
	}

	@Test
	void testAddTwoSmall() {
				
		assertEquals(40,cal.add(10, 30));
	}
	
	@Test
	void testAddPosNeg() {
				
		assertEquals(-2,cal.add(-20, 18));
	}
	
	@Test
	void testAddTwoBig() {
				
		assertEquals(10000010,cal.add(1000007, 9000003));
	}

	@Test
	void testSubtractnegpos() {
		assertEquals(-30,cal.subtract(-10, 20));
	}
	
	@Test
	void testSubtractbisSmall() {
		assertEquals(985,cal.subtract(1000, 15));
	}
	
	@Test
	void testSubtractsmallbi() {
		assertEquals(-985,cal.subtract(15, 1000));
	}

	@Test
	void testMultiplysmallsmall() {
		assertEquals(50,cal.multiply(10, 5));
	}
	
	@Test
	void testMultiplytwoneg() {
		assertEquals(90,cal.multiply(-10, -9));
	}
	
	@Test
	void testMultiplytwobig() {
		assertEquals(1000000000,cal.multiply(1000000, 1000));
	}

	@Test
	void testDividebyZero() {
		IllegalArgumentException iae = Assertions.assertThrows(IllegalArgumentException.class, () -> {
		      // code that could throw an exception
			cal.divide(10, 0);
		    }, "IllegalArgumentException was expected");
		assertEquals("Division by zero: divisor must not be 0", iae.getMessage());
	}
	
	@Test
	void testDivideTwoSmall() {
		assertEquals(5,cal.divide(15, 3));
	}
	
	@Test
	void testDividebyTwobig() {
		assertEquals(30,cal.divide(9000000, 300000));
	}

}
