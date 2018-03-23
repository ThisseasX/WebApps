package utils;

import org.mindrot.jbcrypt.BCrypt;

public class HashingUtils {

    public static String hashPass(String pass) {
        String generatedPass = BCrypt.hashpw(pass, BCrypt.gensalt(12));
        System.out.println("GENERATED PASS: " + generatedPass);
        return generatedPass;
    }

    public boolean checkHash(String pass, String passHashed) {
        return BCrypt.checkpw(pass, passHashed);
    }
}
