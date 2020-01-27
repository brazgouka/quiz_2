package com.instinctools.snippet.service;

import org.springframework.stereotype.Service;

@Service
public class AccessService {

    private final QuizService quizService;
    private final KeyService keyService;
    private final SignatureService signatureService;

    public AccessService(final QuizService quizService, final KeyService keyService, final SignatureService signatureService) {
        this.quizService = quizService;
        this.keyService = keyService;
        this.signatureService = signatureService;
    }

    public boolean hasAccess() throws Exception {
        return signatureService.checkSignature(keyService.getPublicKey(quizService.getStartByte(), quizService.getKeyLength()),
                "Try to find public key!");
    }

}
