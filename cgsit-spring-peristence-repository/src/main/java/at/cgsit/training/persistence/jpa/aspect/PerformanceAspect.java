package at.cgsit.training.persistence.jpa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * log all database access request times with Performance Pointcut around repository methods
 */
@Aspect
@Component
public class PerformanceAspect {

  Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

  @Pointcut("execution(* at.cgsit.training.persistence.jpa.repository.ChatMessageRepository.*(..))")
  public void repositoryClassMethods() {};

  @Around("repositoryClassMethods()")
  public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint)  throws Throwable {
    long start = System.nanoTime();

    Object returnValue = joinPoint.proceed();

    long end = System.nanoTime();
        String methodName = joinPoint.getSignature().getName();

    logger.info("Execution of " + methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");

    return returnValue;
  }
}
