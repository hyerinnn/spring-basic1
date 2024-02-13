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

public class AppConfig {

    //@Bean
    public MemberService memberService() {
        // Service 객체에 memberRepository의 구현체를 생성해 주입
        return new MemberServiceImpl(memberRepository());
        //return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // @Bean
        public OrderService orderService() {
            return new OrderServiceImpl(memberRepository(), discountPolicy());

        }

    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        // 정률할인으로 바뀌는 경우 아래만 바꾸면 됨.
        return new RateDiscountPolicy();

    }

/*
        //@Bean
        public MemoryMemberRepository memberRepository() {

            return new MemoryMemberRepository();
        }



        @Bean
        public DiscountPolicy discountPolicy() {
            //return new FixDiscountPolicy();
            // 정률할인으로 바뀌는 경우 아래만 바꾸면 됨.
            return new RateDiscountPolicy();

        }*/


}
