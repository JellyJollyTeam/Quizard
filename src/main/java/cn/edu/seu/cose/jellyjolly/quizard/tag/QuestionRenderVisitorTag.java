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
package cn.edu.seu.cose.jellyjolly.quizard.tag;

import cn.edu.seu.cose.jellyjolly.spell.MultipleChoice;
import cn.edu.seu.cose.jellyjolly.spell.MultipleTextbox;
import cn.edu.seu.cose.jellyjolly.spell.Quiz;
import cn.edu.seu.cose.jellyjolly.spell.QuizElement;
import cn.edu.seu.cose.jellyjolly.spell.QuizText;
import cn.edu.seu.cose.jellyjolly.spell.QuizTitle;
import cn.edu.seu.cose.jellyjolly.spell.QuizVisitor;
import cn.edu.seu.cose.jellyjolly.spell.SingleChoice;
import cn.edu.seu.cose.jellyjolly.spell.SingleTextbox;
import org.apache.commons.lang.StringEscapeUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class QuestionRenderVisitorTag extends TagSupport {

    private QuizHtmlPrinter printer = new QuizHtmlPrinter();

    @Override
    public int doStartTag() throws JspException {
        return Tag.EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    public void setQuiz(Quiz quiz) {
        quiz.accept(printer);
    }

    private JspWriter getWriter() {
        return pageContext.getOut();
    }
}
