package com.itheima._01策略设计模式匿名内部类以及Lambda表达式优化代码;

/**
     接口中只有一个抽象方法的接口，称为函数式接口,并用 @FunctionalInterface 修饰这个接口，用于检查该接口只有一个抽象方法
 */
@FunctionalInterface
public interface MyPredicate<T> {

    public boolean filter(T t);
}
