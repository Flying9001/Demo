package com.ljq.demo.object;

import lombok.Data;

import java.util.Objects;

/**
 * @Description: builder 模式创建对象 - class 级别 - sweet pizza 模型(pizza 子类)
 * @Author: junqiang.lu
 * @Date: 2019/6/30
 */
@Data
public class BuilderSweetPizzaDemo extends BuilderPizzaDemo {
    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }
    private final Size size;

    public static class Builder extends BuilderPizzaDemo.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public BuilderSweetPizzaDemo build() {
            return new BuilderSweetPizzaDemo(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    BuilderSweetPizzaDemo(Builder builder) {
        super(builder);
        this.size = builder.size;
    }
}
