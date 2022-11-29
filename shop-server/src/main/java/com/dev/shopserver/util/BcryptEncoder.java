package com.dev.shopserver.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class BcryptEncoder {
    public String encodePassword(String rawPassword){
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }

    public boolean isMatch(String rawPassword, String encodedPassword){
        return BCrypt.checkpw(rawPassword, encodedPassword);
    }
}
