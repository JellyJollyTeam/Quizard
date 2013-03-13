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
package cn.edu.seu.cose.jellyjolly.quizard.dao;
import cn.edu.seu.cose.jellyjolly.quizard.model.AdminUser;
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
import org.bson.types.ObjectId;
/**
 *
 * @author Yan
 */
public class QuizDAO {
    private DB db;
    private Mongo mongo;
    private DBCollection dbcollection;
    private DBCursor cursor;
    public QuizDAO() throws UnknownHostException{
        mongo = new Mongo();
        db = mongo.getDB("quizard");
        dbcollection = db.getCollection("quiz");
    }
    public void insertQuiz (Quiz quiz){//待完成，属性不全
        BasicDBObject temp = new BasicDBObject();
        temp.put("creationDate", quiz.getCreationDate());
        temp.put("tags", quiz.getTags());
        temp.put("questionList", quiz.getQuestionList());
        temp.put("ownerid", quiz.getOwner().getId());
        temp.put("title",quiz.getTitle());
        temp.put("description", quiz.getDescription());
        dbcollection.save(temp);
        ObjectId objectid = (ObjectId)temp.get("_id");
        String id = objectid.toStringMongod();
        quiz.setId(id); 
    }
    public void deleteQuiz (String quizId){//待完成，会有后续关联操作
        ObjectId objId = new ObjectId(quizId);
        BasicDBObject query = new BasicDBObject();
        query.put("_id", objId);
        dbcollection.remove(query);
    }
    public void updateQuiz (Quiz quiz){
        
    }
}
