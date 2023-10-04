package com.example.backend.model;

@FunctionalInterface
public interface TestFunction<T> {
    T test(T t);
}
