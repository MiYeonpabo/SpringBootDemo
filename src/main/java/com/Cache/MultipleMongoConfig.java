//package com.Cache;
//
//import com.Sources.MultipleMongoProperties;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//
//@Configuration
//public class MultipleMongoConfig {
//
//    @Autowired
//    private MultipleMongoProperties mongoProperties;
//
//
//    @Primary
//    @Bean(name = PrimaryMongoConfig.MONGO_TEMPLATE)
//    public MongoTemplate primaryMongoTemplate() throws Exception {
//        return null;
//    }
//
//}
