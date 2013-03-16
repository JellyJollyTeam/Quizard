/*
 * The MIT License
 *
 * Copyright 2013 Jelly Jolly Team.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package cn.edu.seu.cose.jellyjolly.quizard.dao.impl;

import cn.edu.seu.cose.jellyjolly.quizard.dao.AdminUserDataAccess;
import cn.edu.seu.cose.jellyjolly.quizard.model.AdminUser;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.ServerAddress;
import java.net.UnknownHostException;
import org.bson.types.ObjectId;

/**
 *
 * @author Yan
 */
public class AdminUserDataAccessImpl implements AdminUserDataAccess {

    private DB db;
    private DBCollection dbcollection;

    public AdminUserDataAccessImpl(Mongo mongo) throws UnknownHostException {
        db = mongo.getDB("quizard");
        dbcollection = db.getCollection("adminuser");
    }

    @Override
    public void insertUser(AdminUser adminuser) {
        BasicDBObject temp = new BasicDBObject();
        temp.put("username", adminuser.getUsername());
        temp.put("email", adminuser.getEmail());

        //password未写

        dbcollection.save(temp);
        ObjectId objectid = (ObjectId) temp.get("_id");
        String id = objectid.toStringMongod();
        adminuser.setId(id);                //用数据库生成的id初始化adminuser的id
    }

    @Override
    public void deleteUser(String userId) {
        ObjectId objId = new ObjectId(userId);
        BasicDBObject query = new BasicDBObject();
        query.put("_id", objId);
        dbcollection.remove(query);
    }

    @Override
    public void updateUser(AdminUser adminuser) {//传入新的用户对象
        BasicDBObject query = new BasicDBObject();
        ObjectId userId = new ObjectId(adminuser.getId());
        query.put("_id", userId);
        DBObject dbobject = dbcollection.findOne(query);
        dbobject.put("username", adminuser.getUsername());
        dbobject.put("email", adminuser.getEmail());
        dbcollection.update(query, dbobject);
    }

    @Override
    public AdminUser findUser(String userId) {
        AdminUser adminuser = new AdminUser();
        BasicDBObject query = new BasicDBObject();
        ObjectId objectId = new ObjectId(userId);
        query.put("_id", objectId);
        DBObject dbobject = dbcollection.findOne(query);
        Object id = dbobject.get("_id");
        adminuser.setId(id.toString());

        Object username = dbobject.get("username");
        adminuser.setUsername(username.toString());

        Object email = dbobject.get("email");
        adminuser.setEmail(email.toString());
        return adminuser;
    }
}
