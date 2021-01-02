package com.sample.basic.java8.localdatetimezone;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeTest {
    public static void main(String args[]){
        ZonedDateTimeTest java8tester = new ZonedDateTimeTest();
        java8tester.testZonedDateTime();
    }

    public void testZonedDateTime(){

        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZonedDateTime date2 = ZonedDateTime.now();
        System.out.println("date2: " + date2);

        ZonedDateTime date3 = date2.toLocalDateTime().atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println("date3: " + date3);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }
}