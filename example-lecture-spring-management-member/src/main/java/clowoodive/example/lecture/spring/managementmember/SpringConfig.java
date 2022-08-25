package clowoodive.example.lecture.spring.managementmember;

import clowoodive.example.lecture.spring.managementmember.aop.TimeTraceAop;
import clowoodive.example.lecture.spring.managementmember.repository.JdbcMemberRepository;
import clowoodive.example.lecture.spring.managementmember.repository.JdbcTemplateMemberRepository;
import clowoodive.example.lecture.spring.managementmember.repository.JpaMemberRepository;
import clowoodive.example.lecture.spring.managementmember.repository.MemberRepository;
import clowoodive.example.lecture.spring.managementmember.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // TimeTraceAop에 @component 를 붙이는것 보다 이렇게 하는게 명시적이고 좋음
    // 하지만 bean 등록 코드 또한 AOP대상이 되므로 @Around 구문에서 SpringConfig 파일은 제외해야 함
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepository memberRepository() {
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//
//    }
}
