/**
 * @author Pujan
 * @version 1
 * Trigonometric Functions SIN, COS, TAN [Non-implemented methods and constructors]
 */
package jUnittest;

import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.Math;

	public class TrigonometricJunitTest {
		@Test
		public void testAssertions() {
			//Radian
			//Test functions for small values
			TrigonometricJunit.Trig tri = new TrigonometricJunit.Trig(1.0);
			
			//Comparing the radian values for the Math sin function and Custom TrigonometricJunit function
			assertEquals(Math.sin(1.0), tri.TrigFuncSin(), 0.0);
			
			//Comparing the radian values for the Math cos function and Custom TrigonometricJunit function
			assertEquals(Math.cos(1.0), tri.TrigFuncCos(), 0.000001);
			
			//Comparing the radian values for the Math tan function and Custom TrigonometricJunit function
			assertEquals(Math.tan(1.0), tri.TrigFuncTan(), 0.000001);
			
			//Test function for large values
			tri.setX(680.0);
			
			//Comparing large radian values for the Math sin function and Custom TrigonometricJunit function
			assertEquals(Math.sin(680.0), tri.TrigFuncSin(), 0.000001);
			
			//Comparing large radian values for the Math cos function and Custom TrigonometricJunit function
			assertEquals(Math.cos(680.0), tri.TrigFuncCos(), 0.000001);
			
			//Comparing large radian values for the Math tan function and Custom TrigonometricJunit function
			assertEquals(Math.tan(680.0), tri.TrigFuncTan(), 0.000001);
			
			//Degree
						
			//Testing the value for the 1st quadrant
			tri.setX(tri.radtodegree(0.558505));
			
			//Comparing the degree values for the Math sin function and Custom TrigonometricJunit function for 1st quadrant
			assertEquals(Math.sin(Math.toDegrees(0.558505)), tri.TrigFuncSin(), 0.000001);
			
			//Comparing the degree values for the Math sin function and Custom TrigonometricJunit function for 1st quadrant
			assertEquals(Math.cos(Math.toDegrees(0.558505)), tri.TrigFuncCos(), 0.000001);
			
			//Comparing the degree values for the Math tan function and Custom TrigonometricJunit function for 1st quadrant
			assertEquals(Math.tan(Math.toDegrees(0.558505)), tri.TrigFuncTan(), 0.000001);
			
			//Testing the value for the 2nd quadrant
			tri.setX(tri.radtodegree(1.72788));
			
			//Comparing the degree values for the Math sin function and Custom TrigonometricJunit function for 2nd quadrant
			assertEquals(Math.sin(Math.toDegrees(1.72788)), tri.TrigFuncSin(), 0.000001);
			
			//Comparing the degree values for the Math sin function and Custom TrigonometricJunit function for 2nd quadrant
			assertEquals(Math.cos(Math.toDegrees(1.72788)), tri.TrigFuncCos(), 0.000001);
			
			//Comparing the degree values for the Math tan function and Custom TrigonometricJunit function for 2nd quadrant
			assertEquals(Math.tan(Math.toDegrees(1.72788)), tri.TrigFuncTan(), 0.000001);

			//Testing the value for the 3rd quadrant
			tri.setX(tri.radtodegree(3.31613));
			
			//Comparing the degree values for the Math sin function and Custom TrigonometricJunit function for 3rd quadrant
			assertEquals(Math.sin(Math.toDegrees(3.31613)), tri.TrigFuncSin(), 0.000001);
			
			//Comparing the degree values for the Math sin function and Custom TrigonometricJunit function for 3rd quadrant
			assertEquals(Math.cos(Math.toDegrees(3.31613)), tri.TrigFuncCos(), 0.000001);
			
			//Comparing the degree values for the Math tan function and Custom TrigonometricJunit function for 3rd quadrant
			assertEquals(Math.tan(Math.toDegrees(3.31613)), tri.TrigFuncTan(), 0.000001);
			
			//Testing the value for the 4th quadrant
			tri.setX(tri.radtodegree(5.41052));
			
			//Comparing the degree values for the Math sin function and Custom TrigonometricJunit function for 4th quadrant
			assertEquals(Math.sin(Math.toDegrees(5.41052)), tri.TrigFuncSin(), 0.000001);
			
			//Comparing the degree values for the Math sin function and Custom TrigonometricJunit function for 4th quadrant
			assertEquals(Math.cos(Math.toDegrees(5.41052)), tri.TrigFuncCos(), 0.000001);
			
			//Comparing the degree values for the Math tan function and Custom TrigonometricJunit function for 4th quadrant
			assertEquals(Math.tan(Math.toDegrees(5.41052)), tri.TrigFuncTan(), 0.000001);
		}
		
		@Test
		public void whenExceptionThrown_thenAssertionSucceeds() {
			String expectedMessage = "Invalid number";
			String actualMessage = "";
			
			//Testing values for POSITIVE_INFINITY
			TrigonometricJunit.Trig tri = new TrigonometricJunit.Trig(Double.POSITIVE_INFINITY);
			
			//Testing values for the sin function
			Exception exception1 = assertThrows(NumberFormatException.class, () -> {
				tri.TrigFuncSin();
			});
			actualMessage = exception1.getMessage();
			assertTrue(actualMessage.contains(expectedMessage));
			
			//Testing values for the cos function
			Exception exception2 = assertThrows(NumberFormatException.class, () -> {
				tri.TrigFuncCos();
			});
			actualMessage = exception2.getMessage();
			assertTrue(actualMessage.contains(expectedMessage));
			
			//Testing values for the tan function
			Exception exception3 = assertThrows(NumberFormatException.class, () -> {
				tri.TrigFuncTan();
			});
			actualMessage = exception3.getMessage();
			assertTrue(actualMessage.contains(expectedMessage));
			
			//Testing values for NEGATIVE_INFINITY
			tri.setX(Double.NEGATIVE_INFINITY);
			
			//Testing values for the sin function		
		    Exception exception4 = assertThrows(NumberFormatException.class, () -> {
		    	tri.TrigFuncSin();
		    });
		    actualMessage = exception4.getMessage();
		    assertTrue(actualMessage.contains(expectedMessage));
		    
		    //Testing values for the cos function
		    Exception exception5 = assertThrows(NumberFormatException.class, () -> {
		    	tri.TrigFuncCos();
		    });
		    actualMessage = exception5.getMessage();
		    assertTrue(actualMessage.contains(expectedMessage));

		    //Testing values for the tan function
		    Exception exception6 = assertThrows(NumberFormatException.class, () -> {
		    	tri.TrigFuncTan();
		    });
		    actualMessage = exception6.getMessage();
		    assertTrue(actualMessage.contains(expectedMessage));
		}
	}

