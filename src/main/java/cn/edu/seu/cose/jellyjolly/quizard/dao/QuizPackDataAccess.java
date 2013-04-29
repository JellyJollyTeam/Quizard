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

import cn.edu.seu.cose.jellyjolly.quizard.model.QuizLink;
import cn.edu.seu.cose.jellyjolly.quizard.model.QuizPack;
import cn.edu.seu.cose.jellyjolly.spell.Quiz;
import java.util.List;


/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public interface QuizPackDataAccess {

    QuizPack getQuizPackById(int quizId);

    QuizPack createNewQuizPack(String username, Quiz quiz, String quizSource);

    List<QuizPack> searchQuizPacks(String keyword, int offset, int limit);

    List<QuizPack> getQuizPacks(int offset, int limit);

    List<QuizLink> getQuizLinksOrderByCreationTime(int offset, int limit);

    List<QuizLink> getQuizLinksOrderByAnsweredCount(int offset, int limit);

    List<QuizPack> getQuizPacksByUsername(String username);

    boolean belongsToUser(String username, int quizId);

    void updateQuizPack(QuizPack quiz);

    void deleteQuizPackById(int quizId);
}
