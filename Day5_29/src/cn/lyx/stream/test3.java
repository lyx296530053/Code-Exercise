package cn.lyx.stream;

import org.junit.Test;

import java.util.Optional;

public class test3 {
   @Test
    public void test1(){
       Integer a=null;
//       Optional optional=Optional.of(a);
       Optional<Object> o = Optional.ofNullable(a);
       System.out.println(o);
   }
}
