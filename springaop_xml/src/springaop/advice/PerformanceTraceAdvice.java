package springaop.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	
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
