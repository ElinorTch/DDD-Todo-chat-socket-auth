package com.example.chattrix.account.domain.model;

import org.springframework.util.Assert;

import java.util.UUID;

public record UserId(UUID id) {

    public UserId {
        Assert.notNull(id, "Id must not be null");
    }

    public UserId() {
        this(UUID.randomUUID());
    }


}
