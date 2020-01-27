package com.instinctools.snippet.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

@Service
public class SignatureService {

    private static final String SIGNATURE_PATH = "classpath:static/signature.sign";

    public boolean checkSignature(PublicKey publicKey, String message) throws SignatureException, IOException,
            InvalidKeyException, NoSuchAlgorithmException {
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initVerify(publicKey);
        signature.update(message.getBytes());
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(ResourceUtils.getFile(SIGNATURE_PATH)))) {
            return signature.verify(bis.readAllBytes());
        }
    }
}
