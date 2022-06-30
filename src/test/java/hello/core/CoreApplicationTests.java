package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreApplicationTests {
    MemberService memberService;
    OrderService orderService ;

    @Test
    void contextLoads() {
        Long memberID = 1L;
		Member member = new Member(memberID, "memberA", Grade.VIP);
		memberService.joint(member);

		Order order = orderService.createOrder(memberID, "itemA", 10000);
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

	}

}
