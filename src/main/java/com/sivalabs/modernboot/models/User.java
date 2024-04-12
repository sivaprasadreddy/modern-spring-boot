package com.sivalabs.modernboot.models;

public record User(
       Long id,
       String name,
       String username,
       String email,
       String phone,
       String website) {}
