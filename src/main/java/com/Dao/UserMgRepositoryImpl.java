package com.Dao;

import com.Model.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @author guanzhiding
 * @date 2021/1/5 16:41
 */
@Component
public class UserMgRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(User user) {
        mongoTemplate.save(user);
    }

    public User findUserByName(String userName) {
        Query query = new Query(Criteria.where("name").is(userName));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

    public long update(User user) {
        Query query = new Query(Criteria.where("name").is(user.getName()));
        Update update = new Update().set("passWord", user.getPassWord());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, User.class);
        if (update == null)
            return 0;
        else
            return updateResult.getMatchedCount();
    }

    public void delete(User user) {
        Query query = new Query(Criteria.where("name").is(user.getName()));
        mongoTemplate.remove(query, User.class);
    }
}
