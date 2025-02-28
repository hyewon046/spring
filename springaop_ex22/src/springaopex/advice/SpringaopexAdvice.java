package springaopex.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import springaopex.model.Springaopex;
import springaopex.service.SpringaopexService;

@Aspect
@Component
public class SpringaopexAdvice { //실제로는 db에서 trigger로 처리하는 것이 더 나음
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SpringaopexService springaopexService;
	
	@After("execution(public * springaopex.service.*Impl.insertSpringaopex(..))")
	public void before(JoinPoint joinPoint) throws Throwable {
		
		Springaopex obj = (Springaopex)joinPoint.getArgs()[0];
	
		String sql = " insert into log values(seq_log.nextval, seq_springaopex.currval, ?, ?, 'INSERT', sysdate) ";
		jdbcTemplate.update(sql, obj.getSpass(), null);
		
	} // before
	
	@Around("execution(public * springaopex.service.*Impl.updateSpringaopex(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Springaopex paramObj = (Springaopex)joinPoint.getArgs()[0];
		Springaopex orgObj = springaopexService.getSpringaopex(paramObj.getSid());
		
		try {
			return joinPoint.proceed();
		} finally {
			String sql = " insert into log values(seq_log.nextval, ?, ?, ?, 'UPDATE', sysdate) ";
			jdbcTemplate.update(sql, paramObj.getSid(), orgObj.getSpass(), paramObj.getSpass());
		}
	}
	
	@Around("execution(public * springaopex.service.*Impl.deleteSpringaopex(..))")
	public Object around2(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			Object obj = joinPoint.getArgs()[0]; //21
			String sql = " insert into log values(seq_log.nextval, ?, ?, ?, 'DELETE', sysdate) ";
			//int sid = Integer.parseInt((String)obj);
			jdbcTemplate.update(sql, obj, null, null);
			return joinPoint.proceed();
		} finally {
		} 		
	}

}




