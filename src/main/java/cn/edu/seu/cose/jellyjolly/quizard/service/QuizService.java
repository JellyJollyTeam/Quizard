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
package cn.edu.seu.cose.jellyjolly.quizard.service;

import cn.edu.seu.cose.jellyjolly.quizard.model.AdminUser;
import cn.edu.seu.cose.jellyjolly.quizard.model.Quiz;
import java.util.List;

/**
 *
 * @author xeon
 */
public interface QuizService {

    public void addQuiz(Quiz quiz);

    public Quiz findQuizById(int id);

    public List<Quiz> findQuizByUsername(String username);

    public List<Quiz> findQuizByTitle(String title);

    public List<Quiz> findQuizzes(int offset, int limit);

    public void deleteQuizById(AdminUser adminUser, int quizId);

    public void changeQuiz(AdminUser adminUser, int quizdId,
            Quiz quizard);
}
