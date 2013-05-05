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

import cn.edu.seu.cose.jellyjolly.quizard.service.QuizService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Xeon
 */
@Component
@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;
    private int maxQuizCount = 25;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    public void setMaxQuizCount(int maxQuizCount) {
        this.maxQuizCount = maxQuizCount;
    }

    @RequestMapping(value = "/quiz/${id}", method = RequestMethod.GET)
    public String getQuiz(@PathVariable int id, Model model) {
//        Quiz quiz = quizService.findQuizById(id);
//        model.addAttribute("quiz", quiz);
        return "quiz";
    }

    @RequestMapping(value = "/quizzes", method = RequestMethod.GET)
    public String getQuizzes(@RequestParam(defaultValue = "1") int page, Model model) {
        int offset = (page <= 0) ? 1 : page - 1;
//        List<Quiz> quizzes = quizService.findQuizzes(offset, maxQuizCount);
//        model.addAttribute("quizzes", quizzes);
        return "repository";
    }

    @RequestMapping(value = "/quiz/${id}", method = RequestMethod.POST)
    public String sendAnswerSheet() {
        return null;
    }
}
