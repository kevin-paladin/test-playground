package com.paladincloud;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringExtrasTest {
	@Test
	public void removeNonSpaceAndCharacters() {
		String str = "abc";
		String expected = "abc";
		String actual = StringExtras.removeNonSpaceAndCharacters(str);

		assertEquals(expected, actual);
	}
}
