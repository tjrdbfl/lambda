package com.dennis.api.proxy;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {
    //Math.abs
    public static Function<Integer,Integer> absInteger = Math::abs;
    public static Function<Double,Double> absDouble = Math::abs;
    public static Function<Float,Float> absFloat = Math::abs;
    public static Function<Long,Long> absLong = Math::abs;

    //Math.max
    public static BiFunction<Integer,Integer,Integer> maxInteger = Math::max;
    public static BiFunction<Double,Double,Double> maxDouble = Math::max;
    public static BiFunction<Float,Float,Float> maxFloat = Math::max;
    public static BiFunction<Long,Long,Long> maxLong = Math::max;

    //Math.min
    public static BiFunction<Integer,Integer,Integer> minInteger = Math::min;
    public static BiFunction<Double,Double,Double> minDouble = Math::min;
    public static BiFunction<Float,Float,Float> minFloat = Math::min;
    public static BiFunction<Long,Long,Long> minLong = Math::min;

    //Math.random - supplier
    public static Supplier<Double> randomSupplierDouble=Math::random;

    //Math.random - function
    public static BiFunction<Integer,Integer,Integer> randomInteger = (a,b)->(int)(Math.random()*(b-a)+a);
    public static BiFunction<Double,Double,Double> randomDouble = (a,b)->(Math.random()*(b-a)+a);
    public static BiFunction<Float,Float,Float> randomFlaot = (a,b)->(float)(Math.random()*(b-a)+a);
    public static BiFunction<Long,Long,Long> randomLong = (a,b)->(long)(Math.random()*(b-a)+a);

    //Math.ceil
    public static Function<Double,Double> ceilDouble =Math::ceil;
    public static Function<Float,Float> ceilFloat =a-> (float) Math.ceil(a);
    public static Function<Long,Long> ceilLong =a-> (long) Math.ceil(a);

    //Math.floor
    public static Function<Double,Double> floorDouble =Math::floor;
    public static Function<Float,Float> floorFloat =a-> (float) Math.floor(a);
    public static Function<Long,Long> floorLong =a-> (long) Math.floor(a);

    //Math.round
    public static Function<Double,Double> roundDouble =a->(double) Math.round(a);
    public static Function<Float,Float> roundFloat =a->(float) Math.round(a);
    public static Function<Long,Long> roundLong =a->(long) Math.round(a);

}
