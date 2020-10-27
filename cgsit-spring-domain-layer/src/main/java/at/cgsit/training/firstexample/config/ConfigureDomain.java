package at.cgsit.training.firstexample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * only use this if programmatic configuration is required by implementing @Bean Constructors
 * otherwise see Autoconfig for properties to configure
 */
@Configuration
//@EnableJpaRepositories(basePackages="at.cgsit.training.persistence.jpa.repository")
public class ConfigureDomain {

  private static final Logger log = LoggerFactory.getLogger(ConfigureDomain.class);

}

