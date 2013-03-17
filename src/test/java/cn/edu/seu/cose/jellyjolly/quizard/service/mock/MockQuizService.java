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
package cn.edu.seu.cose.jellyjolly.quizard.service.mock;

import cn.edu.seu.cose.jellyjolly.quizard.model.AdminUser;
import cn.edu.seu.cose.jellyjolly.quizard.model.ChoiceType;
import cn.edu.seu.cose.jellyjolly.quizard.model.Question;
import cn.edu.seu.cose.jellyjolly.quizard.model.Quiz;
import cn.edu.seu.cose.jellyjolly.quizard.model.SingleChoice;
import cn.edu.seu.cose.jellyjolly.quizard.service.QuizService;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Xeon
 */
public class MockQuizService implements QuizService {
    
    private List<Quiz> quizzes = new LinkedList<Quiz>();
    private List<Question> questiones = new LinkedList<Question>();
    private SingleChoice question1 = new SingleChoice();
    private AdminUser adminUser = new AdminUser();
    private Date date = new Date();
    private Quiz quiztest1 = new Quiz();
    private String[] tags = {"test"};
    public MockQuizService() {
        //question1.setId(1);
        question1.setTitle("test");
        question1.setDefaultChoice(1);
        question1.setChoiceType(ChoiceType.SINGLE_CHOICE);
        questiones.add(question1);
        //adminUser.setId(1);
        adminUser.setUsername("test");
        adminUser.setEmail("test@test.com");
        //quiztest1.setId(1);
        quiztest1.setAnsweredCount(1);
        quiztest1.setCreationDate(date);
        quiztest1.setOwner(adminUser);
        quiztest1.setQuestionList(questiones);
        quiztest1.setTags(tags);
        quiztest1.setTitle("test");
    }

    @Override
    public void addQuiz(Quiz quiz) {
        
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Quiz findQuizById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Quiz> findQuizByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Quiz> findQuizByTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Quiz> findQuizzes(int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Quiz> findQuizzes(int userId, int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteQuizById(AdminUser adminUser, int quizId) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void changeQuiz(AdminUser adminUser, int quizdId, Quiz quizard) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
