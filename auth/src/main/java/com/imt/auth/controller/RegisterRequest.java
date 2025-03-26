package com.imt.auth.controller;

public record RegisterRequest (
        String email,
        String password,
        String name
) { }
