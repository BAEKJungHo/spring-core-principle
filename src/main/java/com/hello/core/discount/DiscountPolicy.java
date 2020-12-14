package com.hello.core.discount;

import com.hello.core.member.Member;

/**
 * 할인정책인터페이스 (역할)
 */
public interface DiscountPolicy {

    /**
     * @return 할인대상금액
     */
    int discount(Member member, int price);

}
