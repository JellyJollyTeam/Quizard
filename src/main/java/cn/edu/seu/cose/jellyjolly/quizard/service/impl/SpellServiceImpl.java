package cn.edu.seu.cose.jellyjolly.quizard.service.impl;

import cn.edu.seu.cose.jellyjolly.quizard.service.SpellService;
import cn.edu.seu.cose.jellyjolly.spell.Quiz;
import cn.edu.seu.cose.jellyjolly.spell.SpellParser;
import cn.edu.seu.cose.jellyjolly.spell.parser.SpellParserImpl;

/**
 * Copyright (c) 2013 Ray <predator.ray@gmail.com>
 */
public class SpellServiceImpl implements SpellService {

    @Override
    public String getSampleHtmlForm(String spellSource) {
        QuizHtmlPrinter printer = new QuizHtmlPrinter();
        SpellParser spellParser = new SpellParserImpl();
        Quiz quiz = spellParser.getQuiz(spellSource);
        quiz.accept(printer);
        return printer.getHtml();
    }
}
