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

        System.out.println(date1);
    }
}