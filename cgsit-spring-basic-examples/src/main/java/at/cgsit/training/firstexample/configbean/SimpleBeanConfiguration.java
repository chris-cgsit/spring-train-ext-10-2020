package at.cgsit.training.firstexample.configbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SimpleBeanConfiguration {

    /**
     *  specify a Name
     * 	 The name of this bean, or if several names, a primary bean name plus aliases.
     * 	 <p>If left unspecified, the name of the bean is the name of the annotated method.
     * 	 If specified, the method name is ignored.
     */
    //@Bean("mySimpleTest")
    @Bean
    // @Primary // mark it as the primary default candidate for injection
    public Simple simpleTTT() {
        SimpleOne bean = new SimpleOne();
        return bean;
    }

    @Bean
    public Simple simpleTwo() {
        SimpleTwo bean = new SimpleTwo();
        return bean;
    }

}

