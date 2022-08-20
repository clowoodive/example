package clowoodive.example.lecture.spring.managementmember;

import clowoodive.example.lecture.spring.managementmember.repository.MemberRepository;
import clowoodive.example.lecture.spring.managementmember.repository.MemoryMemberRepository;
import clowoodive.example.lecture.spring.managementmember.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
