package com.paladincloud;

import com.paladincloud.basicfunctions.BasicFunctions;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BasicFunctionsSymflowerTest {
	@Test
	public void independentAdd1() {
		int a = 0;
		int b = 0;
		int expected = 0;
		int actual = BasicFunctions.independentAdd(a, b);

		assertEquals(expected, actual);
	}

	@Test
	public void independentAdd2() {
		int a = 1;
		int b = 2147483647;
		int expected = -2147483648;
		int actual = BasicFunctions.independentAdd(a, b);

		assertEquals(expected, actual);
	}
}
