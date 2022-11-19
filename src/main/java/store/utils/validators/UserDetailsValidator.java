package store.utils.validators;


import store.exceptions.UserDetailsValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDetailsValidator {

    public static boolean isValidPhoneNumber(String phoneNumber){
        if (phoneNumber.length() == 11)return true;
        else {
            throw new UserDetailsValidationException("Not a valid phone number");
        }
    }

    public static boolean isValidEmail(String email){
        if (email.contains("@"))return true;
        else {
            throw new UserDetailsValidationException("Not a valid email address");
        }
    }

    public static boolean isValidPassword(String password){
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches())return true;
        else {
            throw new UserDetailsValidationException("Invalid password");
        }

    }
}
