package com.Cache;

import com.Sources.MultipleMongoProperties;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MultipleMongoConfig {

    @Autowired
    private MultipleMongoProperties multipleMongoProperties;


//    @Primary
//    @Bean(name = PrimaryMongoConfig.MONGO_TEMPLATE)
//    public MongoTemplate primaryMongoTemplate() throws Exception {
//        return new MongoTemplate(primaryMongoTemplate())
//    }
//
//    @Bean
//    @Primary
//    public MongoDbFactory primaryFactory(MongoProperties mongo) throws Exception {
//        return new MultipleMongoConfig(new MongoClient(mongo.getHost(), mongo.getPort()), mongo.getDatabase());
//    }
}
