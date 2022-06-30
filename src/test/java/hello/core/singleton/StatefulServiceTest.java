package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statfulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int price1 = statefulService1.order("userA", 10000);
        int price2 = statefulService2.order("userB", 20000);

//        price1 = statefulService1.getPrice();
//        System.out.println("price = " + price);

        Assertions.assertThat(statefulService1).isEqualTo(20000);

    }

    static class TestConfig {

        @Bean
        private StatefulService statefulService() {
            return new StatefulService();
        }
    }
}