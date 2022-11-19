package store.utils.validators;

import org.junit.jupiter.api.*;
import store.exceptions.UserDetailsValidationException;

import static org.junit.jupiter.api.Assertions.*;

class UserDetailsValidatorTest {


    @Test
    void isValidPhoneNumber() {
        String phoneNumber = "08065923833";
        assertTrue(UserDetailsValidator.isValidPhoneNumber(phoneNumber));

    }
    @Test
    void exceptionIsThrownForAPhoneNumberWhoseLengthIsNotEqualToEleven(){
        assertThrows(UserDetailsValidationException.class,()->UserDetailsValidator.isValidPhoneNumber("09876"));
    }

    @Test
    void isValidEmail() {
        String email = "kabir@gmail.com";
        assertTrue(UserDetailsValidator.isValidEmail(email));
    }
    @Test
    void exceptionIsThrownForAnEmailThatIsNotValid(){
        assertThrows(UserDetailsValidationException.class,()->UserDetailsValidator.isValidEmail("kabirgmail.com"));
    }

    @Test
    void isValidPassword() {
        String password = "Kabir128%";
        assertTrue(UserDetailsValidator.isValidPassword(password));
    }

    @Test
    void exceptionIsThrownForAPasswordThatIsNotValid(){
        assertThrows(UserDetailsValidationException.class,()->UserDetailsValidator.isValidPassword("kabir689"));
    }
}