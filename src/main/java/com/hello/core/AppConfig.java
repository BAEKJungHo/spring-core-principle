package com.hello.core;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.member.MemoryMemberRepository;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig.java
 * 애플리케이션에 대한 전반적인 동작 방식(환경 설정)
 * 구현 객체 생성 담당 및 생성자를 통한 주입
 */
@Configuration
public class AppConfig {

    // 싱글톤이 깨지는건 아닐까?
    // 자바코드로 객체를 생성하기 때문에 1번과 2번의 인스턴스 참조값이 달라야 할거 같은데 같은 이유?
    // 1. @Bean memberService -> new MemoryMemberRepository();
    // 2. @Bean orederService -> new MemoryMemberRepository();

    // 아래의 코드 결과 sysout 은 각 1번씩만 호출된다.

    /**
     * call AppConfig.memberService
     * call AppConfig.memberRepository
     * call AppConfig.orderService
     */

    /**
     * 스프링 컨테이너는 싱글톤 레지스트리다. 따라서 스프링 빈이 싱글톤이 되도록 보장해주어야 한다. 그런데
     * 스프링이 자바 코드까지 어떻게 하기는 어렵다. 저 자바 코드를 보면 분명 3번 호출되어야 하는 것이 맞다.
     * 그래서 스프링은 클래스의 바이트코드를 조작하는 라이브러리를 사용한다.
     * 모든 비밀은 @Configuration 을 적용한 AppConfig 에 있다
     */

    @Bean
    public MemberService memberService() {
        // 1번
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //1번
        System.out.println("call AppConfig.memberService");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        // 3번
        System.out.println("call AppConfig.memberRepository");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
