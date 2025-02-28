package springaop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceTraceAdvice {
	
	@Pointcut("execution(public * springaop.service..*(..))")
	public void pointcut() {
	}
	
	@Around("pointcut()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//�޼ҵ� ���� �ð�
		long startTime = System.currentTimeMillis();
		
		//Ÿ�ٸ޼ҵ��
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+ "�޼ҵ� ���� ����!");
		
		try {
			//Ÿ�ٸ޼ҵ� ȣ��
			return joinPoint.proceed();
		
		} finally {
			//�޼ҵ� ���� �ð�
			long endTime = System.currentTimeMillis();
			System.out.println(methodName + "�޼ҵ� ���� ����!");
			
			//�޼ҵ� ���� �ð�
			long runTime = endTime - startTime;
			System.out.println(methodName + " ���� �ð��� " + runTime + "�и��� �Դϴ�!");
		}
		
	}

}
