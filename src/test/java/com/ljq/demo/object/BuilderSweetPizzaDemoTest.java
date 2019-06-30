package com.ljq.demo.object;

import org.junit.Test;

public class BuilderSweetPizzaDemoTest {

    @Test
    public void builderSweetPizzaDemoTest() {
        BuilderSweetPizzaDemo builderSweetPizzaDemo = new BuilderSweetPizzaDemo
                .Builder(BuilderSweetPizzaDemo.Size.MEDIUM)
                .addTopping(BuilderPizzaDemo.Topping.ONION)
                .addTopping(BuilderPizzaDemo.Topping.MUSHROOM)
                .build();

        System.out.println("builderSweetPizzaDemo: " + builderSweetPizzaDemo);
        System.out.println("Toppings: " + builderSweetPizzaDemo.getToppings());


    }

}