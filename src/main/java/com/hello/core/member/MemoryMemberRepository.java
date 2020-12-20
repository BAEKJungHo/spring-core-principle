package com.hello.core.member;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ================================================
 * MemoryMemberRepository
 * - 단순히 메모리에 저장하기 때문에 테스트 용도로만 사용한다.
 * ================================================
 */
@Component
public class MemoryMemberRepository implements MemberRepository {

    // 실무에서는 동시성 이슈가 있을 수 있기 때문에 ConcurrentHashMap 을 사용한다.
    private static Map<Long, Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        store.putIfAbsent(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

}
