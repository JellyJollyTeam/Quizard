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

import cn.edu.seu.cose.jellyjolly.quizard.dao.QuizPackDataAccess;
import cn.edu.seu.cose.jellyjolly.quizard.model.AdminUser;
import cn.edu.seu.cose.jellyjolly.quizard.model.QuizLink;
import cn.edu.seu.cose.jellyjolly.quizard.model.QuizPack;
import cn.edu.seu.cose.jellyjolly.spell.Quiz;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class MockQuizPackDataAccess implements QuizPackDataAccess {

    private Map<Integer, QuizPack> idMapped;
    private Map<String, List<QuizPack>> usernameMapped;
    private int counter = 0;

    public MockQuizPackDataAccess() {
        idMapped = new HashMap<Integer, QuizPack>();
        usernameMapped = new HashMap<String, List<QuizPack>>();
    }

    @Override
    public QuizPack getQuizPackById(int quizId) {
        return idMapped.get(quizId);
    }

    @Override
    public QuizPack createNewQuizPack(String username, Quiz quiz,
            String quizSource) {
        QuizPack pack = new QuizPack();
        AdminUser owner = new AdminUser();
        int id = ++counter;
        owner.setUsername(username);
        pack.setId(id);
        pack.setOwner(owner);
        pack.setQuiz(quiz);
        pack.setQuizSource(quizSource);
        idMapped.put(id, pack);
        List<QuizPack> list = usernameMapped.get(username);
        if (list == null) {
            list = new LinkedList<QuizPack>();
        }
        list.add(pack);
        return pack;
    }

    @Override
    public List<QuizPack> searchQuizPacks(String keyword, int offset,
            int limit) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<QuizPack> getQuizPacks(int offset, int limit) {
        List<QuizPack> list = new LinkedList<QuizPack>();
        int i = 0;
        for (QuizPack pack : idMapped.values()) {
            if (i < offset) {
                continue;
            }
            if (i >= limit) {
                break;
            }
            list.add(pack);
            ++i;
        }
        return list;
    }

    @Override
    public List<QuizLink> getQuizLinksOrderByCreationTime(int offset,
            int limit) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<QuizLink> getQuizLinksOrderByAnsweredCount(int offset,
            int limit) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<QuizPack> getQuizPacksByUsername(String username) {
        return usernameMapped.get(username);
    }

    @Override
    public boolean belongsToUser(String username, int quizId) {
        QuizPack pack = idMapped.get(quizId);
        List<QuizPack> list = usernameMapped.get(username);
        return list.contains(pack);
    }

    @Override
    public void updateQuizPack(QuizPack quiz) {
        int id = quiz.getId();
        String username = quiz.getOwner().getUsername();
        List<QuizPack> list = usernameMapped.get(username);
        for (QuizPack p : list) {
            if (p.getId() == id) {
                p.setOwner(quiz.getOwner());
                p.setQuiz(quiz.getQuiz());
                p.setQuizSource(quiz.getQuizSource());
            }
        }
    }

    @Override
    public void deleteQuizPackById(int quizId) {
        QuizPack quizPack = idMapped.remove(quizId);
        if (quizPack == null) {
            return;
        }
        String username = quizPack.getOwner().getUsername();
        List<QuizPack> list = usernameMapped.get(username);
        list.remove(quizPack);
    }
}
