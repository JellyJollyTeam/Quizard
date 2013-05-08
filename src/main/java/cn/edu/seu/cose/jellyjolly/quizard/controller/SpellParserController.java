package cn.edu.seu.cose.jellyjolly.quizard.controller;

import cn.edu.seu.cose.jellyjolly.quizard.service.SpellService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Copyright (c) 2013 Ray <predator.ray@gmail.com>
 */
@Controller
public class SpellParserController {

    private SpellService spellService;

    public SpellParserController(SpellService spellService) {
        this.spellService = spellService;
    }

    @RequestMapping(value = "/spell", method = RequestMethod.GET)
    public String getParserPage() {
        return "spell";
    }

    @RequestMapping(value = "/spell", method = RequestMethod.POST,
            consumes = "text/plain",
            produces = "text/html")
    public ResponseEntity<String> getSample(
            @RequestBody String spellSource) {
        String htmlForm = spellService.getSampleHtmlForm(spellSource);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        return new ResponseEntity<String>(htmlForm, headers, HttpStatus.OK);
    }
}
