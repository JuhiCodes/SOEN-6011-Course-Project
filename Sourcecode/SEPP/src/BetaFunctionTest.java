import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BetaFunctionTest {

	@Test
	void test() {
		assertEquals(120.0,BetaFunction.getFactorial(6.0, true));
		assertEquals(2.0,BetaFunction.computeSquareRoot(4.0));
		assertEquals(25.0,BetaFunction.computePower(5.0, 2.0));
		assertEquals(118.01916795759013,BetaFunction.computeGamma(6));
	}

}
