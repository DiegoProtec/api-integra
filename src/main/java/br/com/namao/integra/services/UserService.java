package br.com.namao.integra.services;

import org.springframework.security.core.context.SecurityContextHolder;

class UserService {

    static String userSS() {
        try {
            return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        } catch (Exception e) {
            return "";
        }
    }
}
