package com.hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ================================================
 * MemberServiceImpl
 * - 구현체가 1개인 경우 관례상 Impl 이라고 많이 사용한다.
 * ================================================
 */
@Component
public class MemberServiceImpl implements MemberService {

    // 단축키 : ctrl + shift + enter 세미콜론까지 붙여준다.
    // private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;

    /**
     * 생성자를 통해서 구현체를 주입 받는다.
     * @param memberRepository
     */
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
