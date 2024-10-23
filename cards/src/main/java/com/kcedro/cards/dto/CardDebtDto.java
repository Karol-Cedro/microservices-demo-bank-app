package com.kcedro.cards.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CardDebtDto {
    @Positive(message = "Card id should be greater than zero")
    private Long cardId;

    @Positive(message = "Amount should be greater than zero")
    private int amount;
}
