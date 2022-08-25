package clowoodive.example.lecture.spring.managementmember.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
// Spring Config 파일에 bean으로 등록하는 방식을 사용할 경우
//    @Around("execution(* clowoodive.example.lecture.spring.managementmember..*(..)) && !target(clowoodive.example.lecture.spring.managementmember" +
//            ".SpringConfig)")
    @Around("execution(* clowoodive.example.lecture.spring.managementmember..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
