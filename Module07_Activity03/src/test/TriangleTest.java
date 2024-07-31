/* Harrison Blair's Submission for Module07-Activity03
 * 
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import main.TriangleFinder;
import main.IFeelException;


public class TriangleTest {
	
	TriangleFinder myTriFinder;
	
	@BeforeEach
	public void SetUp() {
		myTriFinder = new TriangleFinder();
	}
	
	@DisplayName("Non Integers are disallowed")
	@ParameterizedTest
	@CsvSource({
		"a, 2, 3",
		"1 , b, 3",
		"1, 2, c",
	})
	public void RejctNonNumbers(String s1, String s2, String s3) {
		// Set the sides
		myTriFinder.setSide1(s1);
		myTriFinder.setSide2(s2);
		myTriFinder.setSide3(s3);
		
		try {
			myTriFinder.determineTriangleType();
			fail("Shouldn't get here!");
		} catch (Exception ex) {}
	}
	
	@DisplayName("Disallowed Integers are disallowed")
	@ParameterizedTest
	@CsvSource({
		"0, 2, 3",
		"1 , -2, 3",
		"1, 2, -3",
	})
	public void RejctInvalidNumbers(String s1, String s2, String s3) {
		// Set the sides
		myTriFinder.setSide1(s1);
		myTriFinder.setSide2(s2);
		myTriFinder.setSide3(s3);
		
		try {
			myTriFinder.determineTriangleType();
			fail("Shouldn't get here!");
		} catch (Exception ex) {}
	}
	
	@DisplayName("All sides make a triangle")
	@ParameterizedTest
	@CsvSource({
		"10000, 2, 3",
		"1 , 20000, 3",
		"4, 2, 30000",
		"1000000, 1000000, 1000000"
	})
	public void RejctInvalidTriangles(String s1, String s2, String s3) {
		// Set the sides
		myTriFinder.setSide1(s1);
		myTriFinder.setSide2(s2);
		myTriFinder.setSide3(s3);
		
		try {
			myTriFinder.determineTriangleType();
			fail("Shouldn't get here!");
		} catch (Exception ex) {}
	}
	
	@DisplayName("Computes correct types for given triangle")
	@ParameterizedTest
	@CsvSource({
		"1, 1, 1, Equilateral",
		"1 , 5, 5, Isosceles",
		"5 , 5, 1, Isosceles",
		"5 , 1, 5, Isosceles",
		"15, 34 ,32, Scalene",
	})
	public void RejctInvalidTriangles(String s1, String s2, String s3, String type) {
		// Set the sides
		myTriFinder.setSide1(s1);
		myTriFinder.setSide2(s2);
		myTriFinder.setSide3(s3);
		
		try {
			String myType = myTriFinder.determineTriangleType();
			
			assertEquals(myType, type);
		} catch (Exception ex) { fail("Shouldn't get here!"); }
	}
	
}