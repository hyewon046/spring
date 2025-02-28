package springaop.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//메소드 시작 시간
		long startTime = System.currentTimeMillis();
		
		//타겟메소드명
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+ "메소드 수행 시작!");
		
		try {
			//타겟메소드 호출
			return joinPoint.proceed();
		
		} finally {
			//메소드 종료 시간
			long endTime = System.currentTimeMillis();
			System.out.println(methodName + "메소드 수행 종료!");
			
			//메소드 수행 시간
			long runTime = endTime - startTime;
			System.out.println(methodName + " 수행 시간은 " + runTime + "밀리초 입니다!");
		}
		
	}

}
