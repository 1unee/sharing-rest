package com.oneune.sharing.rest.config;

import jakarta.annotation.PostConstruct;

public interface Config {

    @PostConstruct
    default void init() {
    }
}
