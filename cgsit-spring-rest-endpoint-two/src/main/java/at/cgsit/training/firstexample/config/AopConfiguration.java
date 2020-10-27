package at.cgsit.training.firstexample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * In Spring Boot projects, we don't have to explicitly use the @EnableAspectJAutoProxy.
 * There's a dedicated AopAutoConfiguration that enables Spring's AOP
 * support if the Aspect is on the classpath.
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfiguration {

}
