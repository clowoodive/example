package clowoodive.example.lecture.spring.managementmember.repository;

import clowoodive.example.lecture.spring.managementmember.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // findBy까지 시그니처를 맞추고 뒤에 붙는 Name을 이용해서 아래 JPQL 내부적으로 생성
    // select m from Member where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
