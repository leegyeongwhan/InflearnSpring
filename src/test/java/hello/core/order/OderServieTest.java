package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OderServieTest {

    MemberService memberService;
    OrderService orderService;


    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

//    @Test
//    void createOder() {
//        Long memberID = 1L;
//        Member member = new Member(1L, "memberA", Grade.VIP);
//        memberService.joint(member);
//
//        Order order = orderService.createOrder(memberID, "itemA", 10000);
//        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
//    }
}
