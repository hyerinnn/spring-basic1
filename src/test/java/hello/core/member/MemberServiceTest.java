package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();


    @Test
    void join(){
        //System.out.println("test");

        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("findMember : " + findMember);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}



