package com.ragheb.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encryptor {

    private final static String ALGORITHM = "MD5";
    private static final Logger LOGGER = LogManager.getLogger();

    private MD5Encryptor() {}

    /**
     * @param toBeEncrypted is the text that we want to encrypt it
     * @return encrypted value
     */
    public static String encrypt(String toBeEncrypted) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);

            byte[] bytes = toBeEncrypted.getBytes();
            byte[] digested = messageDigest.digest(bytes);


            for (byte b : digested) {
                sb.append(Integer.toHexString(0xff & b));
            }
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("NoSuchAlgorithmException in MD5Encryptor Class: {}", String.valueOf(e));
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }
}
