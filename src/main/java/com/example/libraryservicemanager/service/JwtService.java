package com.example.libraryservicemanager.service;

import com.example.libraryservicemanager.domain.Token;
import com.example.libraryservicemanager.domain.TokenData;
import com.example.libraryservicemanager.dto.User;
import com.example.libraryservicemanager.model.enumeration.TokenType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Optional;
import java.util.function.Function;

public interface JwtService {

    String createToken(User user, Function<Token, String > tokenFunction);

    Optional<String> extractToken(HttpServletRequest request, String tokenType);

    void addCookie(HttpServletResponse response, User user, TokenType type);

    <T> T getTokenData(String token, Function<TokenData, T> tokenFunction);

    void removeCookie(HttpServletRequest request, HttpServletResponse response, String cookieName);

}
