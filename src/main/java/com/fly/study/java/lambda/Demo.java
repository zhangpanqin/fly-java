package com.fly.study.java.lambda;

import com.fly.study.java.lambda.enitity.UserDTO;
import org.junit.Test;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author 张攀钦
 * @date 2019-09-29-14:45
 * @description
 */
public class Demo {

    @Test
    public void run1() {
        final Stream<String> stream = Stream.of("陈平安", "宁姚");
    }

}
