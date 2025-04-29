package com.imt.auth.controller;

public record TokenResponse(
    String accessToken,
    String refreshToken
) {}