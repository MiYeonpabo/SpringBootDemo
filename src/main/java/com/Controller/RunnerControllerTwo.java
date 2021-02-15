package com.Controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author guanzhiding
 * @date 2021/1/29 14:26
 */
@Component
@Order(2)
public class RunnerControllerTwo implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("The Runner2 start to initialize ...");
    }
}
