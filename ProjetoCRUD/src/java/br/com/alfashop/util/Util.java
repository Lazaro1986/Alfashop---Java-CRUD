package br.com.alfashop.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author Lázaro
 */
public class Util {
    public static String sha1(String txt){
        String varsha1;
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(txt.getBytes("utf-8"));
            varsha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        }catch(Exception e){
            varsha1 = "";
        }
        return varsha1;
    }
}
