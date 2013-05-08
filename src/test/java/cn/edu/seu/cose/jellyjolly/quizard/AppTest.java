package cn.edu.seu.cose.jellyjolly.quizard;

import cn.edu.seu.cose.jellyjolly.quizard.service.impl.QuizHtmlPrinter;
import cn.edu.seu.cose.jellyjolly.spell.Quiz;
import cn.edu.seu.cose.jellyjolly.spell.SpellParser;
import cn.edu.seu.cose.jellyjolly.spell.parser.SpellParserImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Copyright (c) 2013 Ray <predator.ray@gmail.com>
 */
public class AppTest extends TestCase {

    private static final String SAMPLE_PATH =
            "cn/edu/seu/cose/jellyjolly/quizard/spell/sample.spell";

    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testQuizHtmlPrinter() throws IOException {
        QuizHtmlPrinter printer = new QuizHtmlPrinter();
        SpellParser parser = new SpellParserImpl();
        String source = getSourceFromClassPath(SAMPLE_PATH);
        Quiz quiz = parser.getQuiz(source);
        quiz.accept(printer);
        String html = printer.getHtml();
        System.out.println(html);
    }

    private String getSourceFromClassPath(String path) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream in = AppTest.class.getClassLoader()
                .getResourceAsStream( path);
        byte[] buffer = new byte[1024];
        while (true) {
            int len = in.read(buffer);
            if (len <= 0) {
                break;
            }
            baos.write(buffer, 0, len);
        }
        byte[] byteArr = baos.toByteArray();
        String source = new String(byteArr, Charset.forName("UTF-8"));
        return source;
    }
}
