package ru.job4j.pojo;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void whenLastNull() {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        int expected = 3;
        int rsl = Shop.indexOfNull(products);
        Assert.assertEquals(rsl, expected);
    }

    @Test
    public void whenFirstNull() {
        Product[] products = new Product[5];
        products[1] = new Product("Milk", 10);
        int expected = 0;
        int rsl = Shop.indexOfNull(products);
        Assert.assertEquals(rsl, expected);
    }

    @Test
    public void whenHasNotNull() {
        Product[] products = new Product[1];
        products[0] = new Product("Milk", 10);
        int expected = -1;
        int rsl = Shop.indexOfNull(products);
        Assert.assertEquals(rsl, expected);
    }
}