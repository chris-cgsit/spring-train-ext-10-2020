package at.cgsit.training.persistence.mongo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages="at.cgsit.training.persistence.mongo.repository")
public class MongoDbConfiguration {


}
