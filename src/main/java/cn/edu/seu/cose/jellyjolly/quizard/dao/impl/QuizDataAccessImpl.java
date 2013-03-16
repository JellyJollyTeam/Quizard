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

import cn.edu.seu.cose.jellyjolly.quizard.dao.QuizDataAccess;
import cn.edu.seu.cose.jellyjolly.quizard.model.AdminUser;
import cn.edu.seu.cose.jellyjolly.quizard.model.Question;
import cn.edu.seu.cose.jellyjolly.quizard.model.Quiz;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Yan
 */
public class QuizDataAccessImpl implements QuizDataAccess {

    private DB db;
    private DBCollection quizdbcollection;
    private DBCollection admindbcollection;

    public QuizDataAccessImpl(Mongo mongo) throws UnknownHostException {
        db = mongo.getDB("quizard");
        quizdbcollection = db.getCollection("quiz");
        admindbcollection = db.getCollection("adminuser");
    }

    @Override
    public void insertQuiz(Quiz quiz) {//待完成，属性不全
        BasicDBObject temp = new BasicDBObject();
        temp.put("creationdate", quiz.getCreationDate());
        temp.put("tags", quiz.getTags());
        temp.put("questionlist", quiz.getQuestionList());
        temp.put("ownerid", quiz.getOwner().getId());
        temp.put("title", quiz.getTitle());
        temp.put("description", quiz.getDescription());
        quizdbcollection.save(temp);
        ObjectId objectid = (ObjectId) temp.get("_id");
        String id = objectid.toStringMongod();
        quiz.setId(id);
    }

    @Override
    public void deleteQuiz(String quizId) {//待完成，会有后续关联操作
        ObjectId objId = new ObjectId(quizId);
        BasicDBObject query = new BasicDBObject();
        query.put("_id", objId);
        quizdbcollection.remove(query);
    }

    @Override
    public void updateQuiz(Quiz quiz) {
        BasicDBObject query = new BasicDBObject();
        ObjectId quizid = new ObjectId(quiz.getId());
        query.put("_id", quizid);
        DBObject dbobject = quizdbcollection.findOne(query);
        dbobject.put("creationdate", quiz.getCreationDate());
        dbobject.put("tags", quiz.getTags());
        dbobject.put("questionList", quiz.getQuestionList());
        dbobject.put("ownerid", quiz.getOwner().getId());
        dbobject.put("title", quiz.getTitle());
        dbobject.put("description", quiz.getDescription());
        quizdbcollection.update(query, dbobject);
    }

    @Override
    public Quiz findQuiz(String quizId) {
        try {
            Quiz quiz = new Quiz();
            BasicDBObject query1 = new BasicDBObject();
            ObjectId quizobjectId = new ObjectId(quizId);

            //初始化_id
            query1.put("_id", quizobjectId);
            DBObject quizdbobject = quizdbcollection.findOne(query1);
            Object id = quizdbobject.get("_id");
            quiz.setId(id.toString());

            //初始化creationdate
            Object creationdate = quizdbobject.get("creationdate");
            String creationDate = creationdate.toString();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            date = format.parse(creationDate);
            quiz.setCreationDate(date);

            //初始化tags
            List<String> tags = (List<String>) quizdbobject.get("tags");//待检验
            quiz.setTags(tags.toArray(new String[0]));

            //初始化title
            Object title = quizdbobject.get("title");
            quiz.setTitle(title.toString());

            //初始化description
            Object description = quizdbobject.get("description");
            quiz.setDescription(description.toString());

            //初始化owner
            Object ownerid = quizdbobject.get("ownerid");
            BasicDBObject query2 = new BasicDBObject();
            ObjectId adminobjectId = (ObjectId) ownerid;
            query2.put("_id", adminobjectId);
            DBObject admindbobject = admindbcollection.findOne(query2);
            AdminUser adminuser = null;
            String userid = admindbobject.get("_id").toString();
            String username = admindbobject.get("username").toString();
            String email = admindbobject.get("email").toString();
            adminuser.setId(userid);
            adminuser.setUsername(username);
            adminuser.setEmail(email);
            quiz.setOwner(adminuser);

            //初始化questionlist
    //        List<? extends Question> questionlist;
    //        questionlist = (List<? extends Question>) quizdbobject.get("questionlist");//待检验
    //        quiz.setQestionList();
            return quiz;
        } catch (Exception ex) {
            // TODO catch the exception during process and throw a pre-defines exception
            return null;
        }
    }
}
