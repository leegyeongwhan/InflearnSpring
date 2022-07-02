package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SinglettonTest {

    @Test
    @DisplayName("스프링 없는 순수한 di 컨테이너")
    void pureCOntatiner() {
        AppConfig appConfig = new AppConfig();

        //1 조회 호출할 떄 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        //2 조회 호출할 떄 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조갑이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberservice1 != memberservice2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletionService singletionService1 = SingletionService.getInstance();
        SingletionService singletionService2 = SingletionService.getInstance();

        System.out.println("singletionService1 = " + singletionService1);
        System.out.println("singletionService2 = " + singletionService2);

        assertThat(singletionService1).isSameAs(singletionService2);

    }


    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void sprongContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService MemberService1 = ac.getBean("memberService", MemberService.class);
        MemberService MemberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("MemberService1 = " + MemberService1);
        System.out.println("MemberService2 = " + MemberService2);

        assertThat(MemberService1).isSameAs(MemberService2);

    }
}
