package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebLogAspect {
	protected static org.slf4j.Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

	/**
	 * 指定切面的作用位置;
	 */
	@Pointcut("execution(public * com.example.web..*.*(..))")
	public void excudeService() {
	}

	/**
	 * 通知；
	 * 
	 * @param joinPoint
	 * @throws Throwable
	 */
	/*
	 * @Before("webLog()") public void doBefore(JoinPoint joinPoint) throws
	 * Throwable { System.out.println("进入doBefore切面"); // 接收到请求，记录请求内容
	 * ServletRequestAttributes attributes = (ServletRequestAttributes)
	 * RequestContextHolder.getRequestAttributes(); HttpServletRequest request =
	 * attributes.getRequest();
	 * 
	 * // 记录下请求内容 logger.info("URL : " + request.getRequestURL().toString());
	 * logger.info("HTTP_METHOD : " + request.getMethod()); logger.info("IP : "
	 * + request.getRemoteAddr()); logger.info("CLASS_METHOD : " +
	 * joinPoint.getSignature().getDeclaringTypeName() + "." +
	 * joinPoint.getSignature().getName()); logger.info("ARGS : " +
	 * Arrays.toString(joinPoint.getArgs()));
	 * 
	 * }
	 * 
	 * @AfterReturning(returning = "ret", pointcut = "webLog()") public void
	 * doAfterReturning(Object ret) throws Throwable { // 处理完请求，返回内容
	 * logger.info("RESPONSE : " + ret+"Jun"); }
	 */

	@Before("excudeService()")
	public void before() {
		System.out.println("切面before执行了");
	}

	@After("excudeService()")
	public void after() {
		System.out.println("切面after执行了");
	}

	@AfterReturning(returning = "ret", pointcut = "excudeService()")
	public void afterReturning(Object ret) {
		System.out.println("切面afterReturning执行了");
	}

	@AfterThrowing("excudeService()")
	public void afterThrowing() {
		System.out.println("切面afterThrowing执行了");
	}

	@Around("excudeService()")
	public Object around(ProceedingJoinPoint pjp) {
		Object[] args = pjp.getArgs();
		for (Object obj : args) {
			System.out.println("arguments: " + obj);
		}
		//符合规范和官方回复
		@SuppressWarnings("unused")
		Object args0 = args[0];
		args[0] = "paramTest";
		Object retVal = null;
		try {
			retVal = pjp.proceed(args);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}

}