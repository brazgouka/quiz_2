package com.instinctools.snippet.controller;

import com.instinctools.snippet.service.AccessService;
import com.instinctools.snippet.service.QuizService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {

    private final AccessService accessService;
    private final QuizService quizService;

    public AccessController(final AccessService accessService, final QuizService quizService) {
        this.accessService = accessService;
        this.quizService = quizService;
    }

    @GetMapping
    public String getAccess() {
        try {
            if (accessService.hasAccess()) {
                return "Success! Your token: " + quizService.getToken();
            }
        } catch (Exception ignored) { }
        return "Failed...";
    }
}
