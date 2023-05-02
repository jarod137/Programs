package edu.nmsu.cs.circles;

import org.junit.*;

public class Circle2Test {
	// Data you need for each test case
	private Circle2 circle1;
    private Circle2 circle2;
    private Circle2 circle3;
    private final double delta = 1e-15;

	// Stuff you want to do before each test case
	@Before
	public void setup() {
		System.out.println("\nTest starting...");
		circle1 = new Circle2(1, 2, 3);
        circle2 = new Circle2(1, 2, 4);
        circle3 = new Circle2(10, 11, 12);
	}

	// Stuff you want to do after each test case
	@After
	public void teardown() {
		System.out.println("\nTest finished.");
	}

	// Test a positive move
	@Test
	public void simpleMove() {
		Point p;
		System.out.println("Running test: simpleMove.");
		p = circle1.moveBy(1, 1);
		Assert.assertTrue(p.x == 2 && p.y == 3);
	}

	// Test a negative move
	@Test
	public void simpleMoveNeg() {
		Point p;
		System.out.println("Running test: simpleMoveNeg.");
		p = circle1.moveBy(-1, -1);
		Assert.assertTrue(p.x == 0 && p.y == 1);
	}

    // Test scaling method.
    @Test
    public void simpleScale() {
        System.out.println("Running test: simpleScale.");
        double x = circle1.scale(3.0f);
        Assert.assertEquals(9.0f, x, delta);
    }

    // Test intersection method with two intersecting circles
    @Test
    public void simpleIntersect() {
        System.out.println("Running test: simpleIntersect.");
        Assert.assertTrue(circle1.intersects(circle2));
    }

    // Test intersection method with two non-intersecting circles	
    @Test
    public void simpleNonIntersect() {
        System.out.println("Running test: simpleNonIntersect");
        Assert.assertFalse(circle1.intersects(circle3));
    }
}