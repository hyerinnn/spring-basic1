package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Configuration이 없으면 Bean만으로도 스프링컨테이너에 등록되지만, 싱글톤은 보장하지 않음
public class AppConfig {
// 각각의 역할을 분명하게!


    @Bean
    public MemberService memberService() {
        // Service 객체에 memberRepository의 구현체를 생성해 주입
        return new MemberServiceImpl(memberRepository());
        //return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());

    }
    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        // 정률할인으로 바뀌는 경우 아래만 바꾸면 됨.
        return new RateDiscountPolicy();

    }


}
