package cn.edu.seu.cose.jellyjolly.quizard.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Copyright (c) 2013 Ray <predator.ray@gmail.com>
 */
@Component
@Controller
public class EditorController {

    @RequestMapping(value = "/editor", method = RequestMethod.GET)
    public String getEditor() {
        return "editor";
    }
}
