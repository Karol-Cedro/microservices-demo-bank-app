package com.kcedro.cards.service;

import com.kcedro.cards.dto.CardDebtDto;
import com.kcedro.cards.dto.CardDto;
import jakarta.validation.Valid;

public interface ICardsService {

    void createCard(CardDto cardDto);

    boolean deleteCard(Long accountId);

    int getAvailableAmount(Long cardId);

    boolean payDebt(CardDebtDto cardDebtDto);
}
