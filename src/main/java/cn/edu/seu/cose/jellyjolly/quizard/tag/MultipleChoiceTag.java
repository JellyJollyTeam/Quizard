package cn.edu.seu.cose.jellyjolly.quizard.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Copyright (c) 2013 Ray <predator.ray@gmail.com>
 */
public class MultipleChoiceTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        return Tag.EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }
}
