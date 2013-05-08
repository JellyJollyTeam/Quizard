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

import cn.edu.seu.cose.jellyjolly.spell.*;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Copyright (c) 2013 Ray <predator.ray@gmail.com>
 */
public class QuizHtmlPrinter implements QuizVisitor {

    private StringBuilder builder;
    private int questionNo;

    public QuizHtmlPrinter() {
        builder = new StringBuilder();
        questionNo = 1;
    }

    public String getHtml() {
        return builder.toString();
    }

    @Override
    public void visit(QuizTitle quizTitle) {
        String title = quizTitle.getText();
        builder.append("<legend>");
        builder.append(StringEscapeUtils.escapeHtml(title));
        builder.append("</legend>");
    }

    @Override
    public void visit(QuizText quizText) {
        String text = quizText.getText();
        builder.append("<p>");
        builder.append(StringEscapeUtils.escapeHtml(text));
        builder.append("</p>");
    }

    @Override
    public void visit(SingleChoice singleChoice) {
        String labelTxt = singleChoice.getTitle();
        appendQuestionLabel(labelTxt);
        int defaultIndex = singleChoice.getDefaultIndex();
        for (int index = 0; index < singleChoice.getOptions().length; ++index) {
            String option = singleChoice.getOptions()[index];
            builder.append("<label class=\"radio\">");
            builder.append("<input type=\"radio\" name=\"");
            builder.append(getQuestionName());
            builder.append("\"");
            if (defaultIndex == index) {
                builder.append(" checked=\"checked\"");
            }
            builder.append(">");
            builder.append(StringEscapeUtils.escapeHtml(option));
            builder.append("</input>");
            builder.append("</label>");
        }
        ++questionNo;
    }

    @Override
    public void visit(MultipleChoice multipleChoice) {
        String labelTxt = multipleChoice.getTitle();
        appendQuestionLabel(labelTxt);
        Integer[] defaultIndices = multipleChoice.getDefaultIndices();
        for (int index = 0; index < multipleChoice.getOptions().length; ++index) {
            String option = multipleChoice.getOptions()[index];
            builder.append("<label class=\"checkbox\">");
            builder.append("<input type=\"checkbox\" name=\"");
            builder.append(getChoiceName(index));
            builder.append("\"");
            if (contains(index, defaultIndices)) {
                builder.append(" checked=\"checked\"");
            }
            builder.append(">");
            builder.append(StringEscapeUtils.escapeHtml(option));
            builder.append("</input>");
            builder.append("</label>");
        }
        ++questionNo;
    }

    @Override
    public void visit(SingleTextbox singleTextBox) {
        String title = singleTextBox.getTitle();
        appendQuestionLabel(title);
        String defaultValue = singleTextBox.getDefaultValue();
        builder.append("<input name=\"");
        builder.append(getQuestionName());
        builder.append("\" type=\"text\"");
        if (defaultValue != null) {
            builder.append(" value=\"");
            builder.append(StringEscapeUtils.escapeHtml(defaultValue));
            builder.append("\"");
        }
        builder.append(">");
        ++questionNo;
    }

    @Override
    public void visit(MultipleTextbox multipleTextBox) {
        String title = multipleTextBox.getTitle();
        appendQuestionLabel(title);
        String defaultValue = multipleTextBox.getDefaultValue();
        builder.append("<textarea class=\"span4\" name=\"");
        builder.append(getQuestionName());
        builder.append("\" rows=\"10\">");
        if (defaultValue != null) {
            builder.append(StringEscapeUtils.escapeHtml(defaultValue));
        }
        builder.append("</textarea>");
        ++questionNo;
    }

    @Override
    public void visit(Quiz quiz) {
    }

    @Override
    public void visit(QuizElement quizElement) {
    }

    private void appendQuestionLabel(String labelText) {
        builder.append("<label class=\"title\" for=\"");
        builder.append(getQuestionName());
        builder.append("\">");
        builder.append(getQuestionNo());
        builder.append(StringEscapeUtils.escapeHtml(labelText));
        builder.append("</label>");
    }

    private String getQuestionNo() {
        return questionNo + ". ";
    }

    private String getQuestionName() {
        return "q_" + questionNo;
    }

    private String getChoiceName(int index) {
        return "q_" + questionNo + "_" + index;
    }

    private static boolean contains(int n, Integer[] integers) {
        for (int i : integers) {
            if (n == i) {
                return true;
            }
        }
        return false;
    }
}
