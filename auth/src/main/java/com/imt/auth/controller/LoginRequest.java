package com.imt.auth.controller;

public record LoginRequest (
        String email,
        String password
){}