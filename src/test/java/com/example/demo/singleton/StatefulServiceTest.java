package com.example.demo.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);


        //ThreadA: A사용자 10000원 주문
        int priceA = statefulService1.order("userA", 10000);
        //ThreadB: B사용자 20000원 주문
        int priceB = statefulService2.order("userB", 20000);

        //ThreadA : 사용자 A 주문 금액 조회
        System.out.println("price = " + priceA);

        Assertions.assertThat(priceA).isEqualTo(10000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}