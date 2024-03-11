package com.dennis.api.proxy;

import java.util.function.Function;

public class TypeProxy {
    //data 전달 시 mutable한 값들을 immutable 한 값으로 바꾸기
    public static Function<?,String> string=String::valueOf;
    public static Function<String,Integer> integer=Integer::valueOf;
    public static Function<String,Double> doubleOf=Double::valueOf;
    public static Function<String,Float> floatOf=Float::valueOf;


}
