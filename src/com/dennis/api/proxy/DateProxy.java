package com.dennis.api.proxy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class DateProxy {
    //Date Constructor
    //현재 날짜
    public static Supplier<LocalDate> localDateNow= LocalDate::now;

    //문자열로부터 날짜
    public static Function<String,LocalDate> dateTimeFormatter= a-> {
        return LocalDate.parse(a,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    };
    //문자열 변환
    public static Function<LocalDate,String> dateToString=LocalDate::toString;
//    public static Function<String,LocalDate> dateTimeFormatter=Da::toString;

    //날짜 정보 접근
    public static Supplier<Integer> year=localDateNow.get()::getYear;
    public static Supplier<Integer> month=localDateNow.get()::getMonthValue;
    public static Supplier<Integer> dayOfMonth=localDateNow.get()::getDayOfMonth;
    public static Supplier<DayOfWeek> dayOfWeek=localDateNow.get()::getDayOfWeek;

    //날짜 조작
    public static BiFunction<LocalDate,LocalDate,Boolean> isBefore= LocalDate::isBefore;
    public static BiFunction<LocalDate,LocalDate,Boolean> isAfter= LocalDate::isAfter;
    public static BiFunction<LocalDate,LocalDate,Boolean> isEqual= LocalDate::isEqual;

}
