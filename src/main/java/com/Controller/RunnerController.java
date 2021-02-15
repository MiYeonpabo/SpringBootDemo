package com.Controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author guanzhiding
 * @date 2021/1/29 14:06
 */
@Component
@Order(1)
public class RunnerController implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("The Runner1 start to initialize ...");
    }
}
