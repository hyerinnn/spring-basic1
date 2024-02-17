package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        // 1. 직접  memberRepository를 이용한 코드 -> memberRepository에 의존하게 됨
        //MemberService memberService = new MemberServiceImpl(memberRepository);

        // 2. AppConfig를 통한 의존성 주입
        //AppConfig appConfig = new AppConfig();
        //MemberService  memberService = appConfig.memberService();


        //3. 스프링 컨테이너를 통한 관리 -> appConfig에 어노테이션붙은 것들을 객체생성해서 스프링 컨터이너에 등록하여 관리
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class); // memberService라는 이름의 객체를 찾아서 MemberService 타입으로 반환할거야.



        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("Member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());


    }
}
