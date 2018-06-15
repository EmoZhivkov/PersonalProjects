package org.crypto;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException {

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        String myName = "Emil Zhivkov";
        byte[] nameInBytes = myName.getBytes();

        long start = System.currentTimeMillis();
        byte[] hashedName = messageDigest.digest(nameInBytes);
        long time = System.currentTimeMillis() - start;

        String hexString = DatatypeConverter.printHexBinary(hashedName);
        System.out.println("In SHA1: " + hexString + "//in " + time);

        SecretKeyFactory secretKey = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    /////////////
        char[] myNameInChars = myName.toCharArray();
        byte[] salt = "asd".getBytes();
        KeySpec pbeKeySpec = new PBEKeySpec(myNameInChars, salt, 7, 256);

        long start1 = System.currentTimeMillis();
        byte[] nameInBytesWithPBKDF = secretKey.generateSecret(pbeKeySpec).getEncoded();
        long time1 = System.currentTimeMillis() - start1;

        String hexStringPBKDF = DatatypeConverter.printHexBinary(nameInBytesWithPBKDF);
        System.out.println("In PBKDF: " + hexStringPBKDF + "//in " + time1);

    /////////////

        Mac mac = Mac.getInstance("HmacSHA512");
        SecretKeySpec secretKeySpec = new SecretKeySpec(salt, "HmacSHA512");
        mac.init(secretKeySpec);
        mac.update(nameInBytes);

        long start2 = System.currentTimeMillis();
        byte[] nameInBytesWithHmacSHA512 = mac.doFinal(nameInBytes);
        long time2 = System.currentTimeMillis() - start2;

        String hexStringHMAC = DatatypeConverter.printHexBinary(nameInBytesWithHmacSHA512);
        System.out.println("In HmacSHA512: " + hexStringHMAC + "//in " + time2);
    }
}
