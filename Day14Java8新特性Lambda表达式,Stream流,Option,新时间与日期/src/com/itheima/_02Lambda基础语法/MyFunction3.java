package com.itheima._02Lambda基础语法;

@FunctionalInterface
public interface MyFunction3<T,R> {
    R getValue(T t1 , T t2);
}
