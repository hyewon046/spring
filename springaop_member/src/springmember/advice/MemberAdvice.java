package springmember.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MemberAdvice {
	
	@Before("execution(public * springmember.service.*Impl.*(..))")
	public void before(JoinPoint joinPoint) {
		// 타겟클래스의 메소드명
		String methodName = joinPoint.getSignature().getName();
		System.out.println("@Before " + methodName + "메소드 실행전 수행됨!");
		
		//타겟클래스의 메소드가 전달받은 인자들
		for (Object obj : joinPoint.getArgs()) {
			System.out.println("전달된 인자 : " + obj);
		}
	}
	
	
	@AfterReturning(pointcut="execution(public * springmember.service.*Impl.*(..))"
			, returning="returnObj")
	public void afterReturning(JoinPoint joinPoint, Object returnObj) {
		// 타겟클래스의 메소드명
		String methodName = joinPoint.getSignature().getName();
		System.out.println("@AfterReturning " + methodName + "메소드 실행 후 반환값을 가지고 수행됨!");
		
		//타겟클래스의 메소드 리턴한 객체
		System.out.println(returnObj);
	}
	
	@AfterThrowing(pointcut="execution(public * springmember.service.*Impl.*(..))"
			, throwing = "throwable")
	public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
		// 타겟클래스의 메소드명
		String methodName = joinPoint.getSignature().getName();
		System.out.println("@AfterThrowing " + methodName + "메소드 실행시 예외발생하면 수행됨!");
		
		//타겟클래스의 메소드에서 발생한 예외 객체
		System.out.println(throwable);
	}
	
	@After("execution(public * springmember.service.*Impl.*(..))")
	public void after(JoinPoint joinPoint) {
		// 타겟클래스의 메소드명
		String methodName = joinPoint.getSignature().getName();
		System.out.println("@After " + methodName + "메소드 실행 후 수행됨!");
		
		//타겟클래스의 메소드가 전달받은 인자들
		for (Object obj : joinPoint.getArgs()) {
			System.out.println("전달된 인자 : " + obj);
		}
	}
	
	@Around("execution(public * springmember.service.*Impl.*(..))")
	public Object around(ProceedingJoinPoint pjp) {
		// 타겟클래스의 메소드명
		String methodName = pjp.getSignature().getName();
		System.out.println("@Around " + methodName + "메소드 실행 전 수행됨!");
		
		try {
			return pjp.proceed();
		} catch (Throwable th) {
			th.printStackTrace();
			return null;
		} finally {
			System.out.println("@Around " + methodName + "메소드 실행 후 수행됨!");
		}

	}

}
