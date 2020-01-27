package com.instinctools.snippet.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

@Service
public class KeyService {

    private static final String PUBLIC_KEY_BYTES = "classpath:static/public_bytes";

    public PublicKey getPublicKey(final int start, final int length) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        try (FileInputStream fis = new FileInputStream(ResourceUtils.getFile(PUBLIC_KEY_BYTES))) {
            return KeyFactory.getInstance("RSA")
                    .generatePublic(new X509EncodedKeySpec(Arrays.copyOfRange(fis.readAllBytes(), start, start + length)));
        }
    }

}
