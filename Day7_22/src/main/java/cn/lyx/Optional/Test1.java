package cn.lyx.Optional;

import org.junit.Test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Optional;

public class Test1 {
    @Test
    public void test() {
        Date date = new Date();

        Optional<Date> date1 = Optional.ofNullable(date);
        date1.ifPresent(e -> e = new DateFormat());
        System.out.println(date1);
    }
}