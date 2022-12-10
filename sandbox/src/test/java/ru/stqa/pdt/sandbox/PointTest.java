package ru.stqa.pdt.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
    @Test
    public void positivePoints() {
        Point p1 = new Point(2,4);
        Point p2 = new Point(7,1);
        Assert.assertEquals(p1.distance(p2), 6.324555320336759);
    }
    @Test
    public void nullPoints() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,0);
        Assert.assertEquals(p1.distance(p2),0);
    }
    @Test
    public void negativePoints() {
        Point p1 = new Point(-0.01,-1);
        Point p2 = new Point(-100, -5);
        Assert.assertEquals(p1.distance(p2),95.00515828101125);
    }

}
