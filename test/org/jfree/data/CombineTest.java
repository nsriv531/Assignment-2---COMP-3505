package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CombineTest {

	private Range exampleRange;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCombineOverlappingRanges() {
		Range r1 = new Range(-15.75,15.25);
		Range r2 = new Range(13.75,14.00);
		Range result = Range.combine(r2, r1);
		assertEquals(result.getLowerBound(),-15.75);
		assertEquals(result.getUpperBound(),15.25);
	}
	
	@Test
	void testCombineNotOverlappingRanges() {
		Range r1 = new Range(10.5,30.45);
		Range r2 = new Range(5.5,10);
		Range result = Range.combine(r1, r2);
		assertEquals(result.getUpperBound(),30.45);
		assertEquals(result.getLowerBound(),5.5);
	}
	
	@Test
	void testCombineWithOneNullRange() {
		Range r1 = null;
		Range r2 = new Range(-15.75,15);
		Range result = Range.combine(r1, r2);
		assertEquals(result, r2);
	}
	
	@Test
	void testCombineWithTwoNullRangesIsNull() {
		Range r1 = null;
		Range r2 = null;
		Range result = Range.combine(r1, r2);
		assertNull(result);
	}

	@AfterEach
  	void tearDown() throws Exception {
  	}
	
	@AfterAll
  	static void tearDownAfterClass() throws Exception {
  	}
}
