package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import java.nio.channels.Pipe;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void pointThenDistanceWhen2() {
        Point a = new Point(0, 2);
        Point b = new Point(2, 3);
        double dist = a.distance(b);
        double rsl = 2.2;
        Assert.assertEquals(dist, rsl, 0.1);

    }

    @Test
    public void pointThenDistanceWhen3() {
        Point a = new Point(1, 2);
        Point b = new Point(2, 5);
        double dist = a.distance(b);
        double rsl = 3.1;
        Assert.assertEquals(dist, rsl, 0.1);

    }

    @Test
    public void pointThenDistance3dWhen3() {
        Point a = new Point(1, 2, 4);
        Point b = new Point(2, 5, 3);
        double dist = a.distance(b);
        double rsl = 3.1;
        Assert.assertEquals(dist, rsl, 0.1);
    }
}