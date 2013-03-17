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
package cn.edu.seu.cose.jellyjolly.quizard.controller;

import cn.edu.seu.cose.jellyjolly.quizard.model.Quiz;
import cn.edu.seu.cose.jellyjolly.quizard.service.QuizService;
import java.util.LinkedList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Xeon
 */
@Controller
@RequestMapping(value = "/ajax")
public class AjaxUpdateController {

    private static final String JSON_HEADER = "text/json;charset=UTF-8";
    private static HttpStatus STATUS_OK = HttpStatus.OK;
    private QuizService quizService;

    public AjaxUpdateController(QuizService quizService) {
        this.quizService = quizService;
    }

    public ResponseEntity<String> updateAdminQuizzes(@RequestParam int userId,
            @RequestParam int offset, @RequestParam int limit) {
        List<Quiz> quizzes = quizService.findQuizzes(userId, offset, limit);
        List<SimpleQuiz> simpleQuizzes = new LinkedList<SimpleQuiz>();
        for (Quiz quiz : quizzes) {
            SimpleQuiz simpleQuiz = new SimpleQuiz();
            simpleQuiz.setTitle(quiz.getTitle());
            simpleQuiz.setUrl("?quizid=" + quiz.getId());
            simpleQuizzes.add(simpleQuiz);
        }
        JSONArray jsonArray = JSONArray.fromObject(simpleQuizzes);
        JSONObject jsonObj = new JSONObject();
        jsonObj.accumulate("quizzes", jsonArray);
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", JSON_HEADER);
        ResponseEntity<String> blocksResponse =
                new ResponseEntity<String>(jsonObj.toString(), header, STATUS_OK);
        return blocksResponse;
    }

    private static class SimpleQuiz {

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
