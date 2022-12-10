package ru.stqa.pdt.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
    @Test
    public void testDistance() {
        Point p1 = new Point(2,4);
        Point p2 = new Point(7,1);
        Assert.assertEquals(p1.distance(p2), 6.324555320336759);
    }

}
