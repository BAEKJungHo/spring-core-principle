package com.hello.core.member;

import com.hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    /**
     * @BeforeEach 는 @Test 를 실행하기 전에 무조건 실행한다.
     */
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given : ~ 환경이 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when : ~ 이렇게 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then : ~ 이렇게 된다
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
