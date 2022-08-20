package clowoodive.example.lecture.spring.managementmember.repository;

import clowoodive.example.lecture.spring.managementmember.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();  // 동시성 문제를 야기 할 수 있기에 실무에서는 ConcurrentHashMap 써야함
    private static long sequence = 0L;  // 동시성 문제를 야기 할 수 있기에 실무에서는 AtomicLong 써야함

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
