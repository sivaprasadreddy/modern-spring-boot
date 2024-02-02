package com.sivalabs.modernboot.models;

public record User(int id,
                   String name,
                   String username,
                   String email,
                   Address address,
                   String phone,
                   String website,
                   Company company) {

    public record Address(String street,
                   String suite,
                   String city,
                   String zipcode,
                   Geo geo) {
    }

    public record Geo(String lat, String lng) {
    }

    public record Company(String name, String catchPhrase, String bs) {
    }
}

