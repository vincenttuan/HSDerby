package com.web.mvc.validator;

import com.web.mvc.entity.Member;
import com.web.mvc.repository.spec.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MemberValidator implements Validator{
    
    @Autowired
    private LoginDao dao;
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Member.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", null, "Username 不可空白");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null, "Password 不可空白");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null, "Email 不可空白");
        
        Member member = (Member)target;
        String username = member.getUsername().trim();
        
        if(username.length() > 0 && username.length() < 4) {
            errors.rejectValue("username", null, "Username 不可以少於四個字");
        } else if(dao.findUsername(username)) {
            errors.rejectValue("username", null, username + " 已經註冊過了");
        }
        
        if(member.getPassword().length() > 0 && member.getPassword().length() < 4) {
            errors.rejectValue("password", null, "Password 不可以少於四個字");
        }
    
    }
    
}
