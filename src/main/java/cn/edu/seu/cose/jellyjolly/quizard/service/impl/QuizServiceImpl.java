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
package cn.edu.seu.cose.jellyjolly.quizard.service.impl;

import cn.edu.seu.cose.jellyjolly.quizard.dao.QuizPackDataAccess;
import cn.edu.seu.cose.jellyjolly.quizard.model.AdminUser;
import cn.edu.seu.cose.jellyjolly.quizard.model.QuizLink;
import cn.edu.seu.cose.jellyjolly.quizard.model.QuizPack;
import cn.edu.seu.cose.jellyjolly.quizard.service.QuizService;
import cn.edu.seu.cose.jellyjolly.spell.Quiz;
import cn.edu.seu.cose.jellyjolly.spell.SpellParser;
import java.util.List;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class QuizServiceImpl implements QuizService {

    private QuizPackDataAccess quizPackDataAccess;
    private SpellParser spellParser;

    public QuizServiceImpl(QuizPackDataAccess quizPackDataAccess,
            SpellParser spellParser) {
        this.quizPackDataAccess = quizPackDataAccess;
        this.spellParser = spellParser;
    }

    @Override
    public QuizPack getQuizPackById(int id) {
        return quizPackDataAccess.getQuizPackById(id);
    }

    @Override
    public List<QuizPack> getQuizPackByUsername(String username) {
        return quizPackDataAccess.getQuizPacksByUsername(username);
    }

    @Override
    public List<QuizLink> getNewestQuizLinks(int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<QuizLink> getHottestQuizLinks(int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<QuizPack> searchQuizPackWithKeyword(String keyword,
            int offset, int limit) {
        return quizPackDataAccess.searchQuizPacks(keyword, offset, limit);
    }

    @Override
    public List<QuizPack> getQuizPacks(int offset, int limit) {
        return quizPackDataAccess.getQuizPacks(offset, limit);
    }

    @Override
    public List<QuizPack> getQuizPacks(int userId, int offset, int limit) {
        return quizPackDataAccess.getQuizPacks(offset, limit);
    }

    @Override
    public void addQuiz(String username, String quizSource) {
        Quiz quiz = spellParser.getQuiz(quizSource);
        quizPackDataAccess.createNewQuizPack(username, quiz, quizSource);
    }

    @Override
    public void deleteQuizById(String username, int quizId) {
        if (quizPackDataAccess.belongsToUser(username, quizId)) {
            quizPackDataAccess.deleteQuizPackById(quizId);
        }
    }

    @Override
    public void updateQuiz(AdminUser adminUser, int quizdId,
            String quizSource) {
        Quiz quiz = spellParser.getQuiz(quizSource);
        QuizPack quizPack = new QuizPack();
        quizPack.setOwner(adminUser);
        quizPack.setQuizSource(quizSource);
        quizPack.setQuiz(quiz);
        quizPackDataAccess.updateQuizPack(quizPack);
    }
}
