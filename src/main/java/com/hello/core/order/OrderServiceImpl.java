package com.hello.core.order;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderServiceImpl implements OrderService {

    // private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 할인 정책을 변경하려면 클라이언트인 OrderServiceImpl 코드를 고쳐야한다. = OCP 위반
    // 아래 코드는 인터페이스에도 의존하지만 구현체에도 의존하고 있다. = DIP 위반
    // DIP : 역할(인터페이스)에 의존해야지 구현(Impl)에 의존하면 안된다.
    // OCP : 확장에는 열려있고 변경에는 닫혀있어야 한다. = 기존 코드의 변경 없이 새로운 기능을 추가할 수 있어야 한다.
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 역할에만 의존하게 변경 -> 하지만 구현체가 없어서 NPE 발생
    // 해결방안 : 누군가 클라이언트인 OrderServiceImpl 에 DiscountPolicy 의 구현 객체를 대신 생성하고 주입해줘야 한다.
    // private DiscountPolicy discountPolicy;

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /**
     * 다형성에 의해 생성자 주입 (어떤 구현 객체가 들어오는지는 알 수 없고 알 필요도 없다.)
     * 알 필요가 없다는건 역할(인터페이스)에 의존해야하기 때문이다.
     * 어떤 구현 객체를 주입할지는 외부(AppConfig)에서 결정된다.
     *
     * DI(Dependency Injection) : 의존관계 주입 (의존성 주입이라는 말도 있지만 의존은 관계가 중요하기 때문에 의존관계 주입이 더 와닫는다.)
     * @param memberRepository
     * @param discountPolicy
     */
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }


    /**
     * SRP(단일 책임 원칙)을 잘 지켰다.
     * 할인정책에 관한 수정은 DiscountPolicy 에서 담당
     * 만약에 잘 안지켜졌으면 할인정책에 대한 수정도 OrderServiceImpl 에서 이루어진다.
     * @param memberId
     * @param itemName
     * @param itemPrice
     * @return
     */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도도
   public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
