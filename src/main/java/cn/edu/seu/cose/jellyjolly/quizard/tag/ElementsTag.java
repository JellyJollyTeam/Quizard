package cn.edu.seu.cose.jellyjolly.quizard.tag;

import cn.edu.seu.cose.jellyjolly.spell.Quiz;
import cn.edu.seu.cose.jellyjolly.spell.QuizElement;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.LoopTagSupport;
import java.util.Iterator;

/**
 * Copyright (c) 2013 Ray <predator.ray@gmail.com>
 */
public class ElementsTag extends LoopTagSupport {

    private String var;
    private String no;
    private Quiz quiz;
    private Iterator<QuizElement> quizElementIterator;

    @Override
    protected void prepare() throws JspTagException {
        quizElementIterator = quiz.iterator();
    }

    @Override
    protected boolean hasNext() throws JspTagException {
        return quizElementIterator.hasNext();
    }

    @Override
    protected Object next() throws JspTagException {
        return quizElementIterator.next();
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
