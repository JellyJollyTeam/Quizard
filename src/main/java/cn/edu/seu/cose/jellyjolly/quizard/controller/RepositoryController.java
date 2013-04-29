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

import cn.edu.seu.cose.jellyjolly.quizard.model.QuizLink;
import cn.edu.seu.cose.jellyjolly.quizard.service.QuizService;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
@Component
@Controller
public class RepositoryController {

    private QuizService quizService;
    private int quizPerPage = 10;

    public RepositoryController(QuizService quizService) {
        this.quizService = quizService;
    }

    public void setQuizPerPage(int quizPerPage) {
        this.quizPerPage = quizPerPage;
    }

    @RequestMapping(value = "/repository", method = RequestMethod.GET,
            params = "!type")
    public String getQuizzes(Model model) {
        return getNewestQuizzes(1, model);
    }

    @RequestMapping(value = "/repository", method = RequestMethod.GET,
            params = "type=new")
    public String getNewestQuizzes(@RequestParam(defaultValue = "1") int page,
            Model model) {
        int offset = (page <= 0) ? 0 : ((page - 1) * quizPerPage);
        int limit = quizPerPage;
        List<QuizLink> quizLinks = quizService
                .getNewestQuizLinks(offset, limit);
        model.addAttribute("quizLinks", quizLinks);
        return "repository";
    }

    @RequestMapping(value = "/repository", method = RequestMethod.GET,
            params = "type=hot")
    public String getHotQuizzes(@RequestParam(defaultValue = "1") int page,
            Model model) {
        int offset = (page <= 0) ? 0 : ((page - 1) * quizPerPage);
        int limit = quizPerPage;
        List<QuizLink> quizLinks = quizService
                .getHottestQuizLinks(offset, limit);
        model.addAttribute("quizLinks", quizLinks);
        return "repository";
    }

    @RequestMapping(value = "/repository", method = RequestMethod.POST)
    public String getQuizzesByKeyword(String keyword) {
        return "resository";
    }
}
