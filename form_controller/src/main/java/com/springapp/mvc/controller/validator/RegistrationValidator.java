package com.springapp.mvc.controller.validator;


import com.springapp.mvc.model.User;
import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RegistrationValidator implements Validator {

    public boolean supports(Class<?> paramClass) {
        return User.class.equals(paramClass);
    }

    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "valid.surname");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "valid.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password");

     User user = (User)obj;

        if(!(user.getPassword().equals(user.getConfirmPassword()))){
            errors.rejectValue("confirmPassword", "valid.confirmPassword");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.confirmPassword");
        }

    }
}