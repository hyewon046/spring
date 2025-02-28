package springaopex.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import springaopex.model.Springaopex;

@Aspect
@Component
public class SpringaopexAdvice {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@After("execution(public * springaopex.service.*Impl.*(..))")
	public void before(JoinPoint joinPoint) throws Throwable {
		Springaopex obj = (Springaopex)joinPoint.getArgs()[0];
		
		String sql= " insert into log values(seq_log.nextval, ?, ?, ?, ?, sysdate) ";
		jdbcTemplate.update(sql, obj.getSid()+1, obj.getSpass(), null, "INSERT");
		
	} //before
	
//	@Around("execution(public * springaopex.service.*Impl.*(..))")
//	public Object around(ProceedingJoinPoint pjp) {
//		
//		
//		
//	}

}
