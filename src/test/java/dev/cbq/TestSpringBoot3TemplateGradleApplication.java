package dev.cbq;

import org.springframework.boot.SpringApplication;

public class TestSpringBoot3TemplateGradleApplication {

    public static void main(String[] args) {
        SpringApplication.from(SpringBoot3TemplateGradleApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
