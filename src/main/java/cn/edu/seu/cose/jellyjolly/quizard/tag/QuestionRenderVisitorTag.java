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

import cn.edu.seu.cose.jellyjolly.quizard.model.MultipleChoice;
import cn.edu.seu.cose.jellyjolly.quizard.model.MultipleTextBox;
import cn.edu.seu.cose.jellyjolly.quizard.model.Quiz;
import cn.edu.seu.cose.jellyjolly.quizard.model.QuizElement;
import cn.edu.seu.cose.jellyjolly.quizard.model.QuizVisitor;
import cn.edu.seu.cose.jellyjolly.quizard.model.SingleChoice;
import cn.edu.seu.cose.jellyjolly.quizard.model.SingleTextBox;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class QuestionRenderVisitorTag extends TagSupport
        implements QuizVisitor {

    private QuizElement quizElement;

    @Override
    public int doStartTag() throws JspException {
        quizElement.accept(this);
        return Tag.EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    public void setQuizElement(QuizElement quizElement) {
        this.quizElement = quizElement;
    }

    private JspWriter getWriter() {
        return pageContext.getOut();
    }

    @Override
    public void visit(SingleChoice singleChoice) {
        JspWriter out = getWriter();
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit(MultipleChoice multipleChoice) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit(SingleTextBox singleTextBox) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit(MultipleTextBox multipleTextBox) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit(Quiz quiz) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visit(QuizElement quizElement) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
