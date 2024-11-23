package com.kcedro.cards.service;

import com.kcedro.cards.dto.CardDebtDto;
import com.kcedro.cards.dto.CardDto;
import jakarta.validation.Valid;

public interface ICardsService {

    void createCard(CardDto cardDto);

    void updateCardAvailableAmount(CardDebtDto cardDebtDto);

    boolean deleteCard(Long accountId);

    int getAvailableAmount(Long accountId);

    int getCardLimit(Long accountId);

    boolean payDebt(CardDebtDto cardDebtDto);
}
