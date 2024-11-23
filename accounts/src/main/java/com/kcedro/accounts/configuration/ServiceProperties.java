package com.kcedro.accounts.configuration;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ServiceProperties {

    @Value("${service.accounts.url}")
    private String accountsUrl;

    @Value("${service.cards.url}")
    private String cardsUrl;

    @Value("${service.operations.url}")
    private String operationUrl;
}
