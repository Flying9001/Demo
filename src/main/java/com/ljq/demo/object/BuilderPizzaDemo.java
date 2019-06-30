package com.ljq.demo.object;

import lombok.Data;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Description: builder 模式创建对象 - class 级别 - pizza 模型
 * @Author: junqiang.lu
 * @Date: 2019/6/30
 */
@Data
public class BuilderPizzaDemo {

    public enum Topping{
        HAM,
        MUSHROOM,
        ONION,
        PEPPER,
        SAUSAGE
    }

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        /**
         * @return
         */
        abstract BuilderPizzaDemo build();

        /**
         * subclass must override this method to return "this"
         *
         * @return
         */
        protected abstract T self();

    }

    BuilderPizzaDemo(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

}
