package com.kcedro.cards.service.impl;

import com.kcedro.cards.constants.CardsConstants;
import com.kcedro.cards.dto.CardDebtDto;
import com.kcedro.cards.dto.CardDto;
import com.kcedro.cards.entity.Card;
import com.kcedro.cards.exception.CardAlreadyExistsException;
import com.kcedro.cards.exception.ResourceNotFoundException;
import com.kcedro.cards.mapper.CardsMapper;
import com.kcedro.cards.repository.CardsRepository;
import com.kcedro.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

    private CardsRepository cardsRepository;

    @Override
    public void createCard(CardDto cardDto) {
        Optional<Card> optionalCards = cardsRepository.findByAccountId(cardDto.getAccountId());
        if (optionalCards.isPresent()) {
            throw new CardAlreadyExistsException("Card already registered with this account " + cardDto.getAccountId());
        }
        cardsRepository.save(createNewCard(cardDto));
    }

    private Card createNewCard(CardDto cardDto) {
        Card newCard = CardsMapper.mapToCards(cardDto, new Card());
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    @Override
    public int getAvailableAmount(Long cardId) {
        Card card = cardsRepository.findById(cardId).orElseThrow(
                () -> new ResourceNotFoundException("Card", "cardId", cardId.toString())
        );
        return card.getAvailableAmount();
    }

    @Override
    public boolean payDebt(CardDebtDto cardDebtDto) {
        Card card = cardsRepository.findById(cardDebtDto.getCardId()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "cardId", cardDebtDto.getCardId().toString()));
        card.setAvailableAmount(card.getAvailableAmount() + cardDebtDto.getAmount());
        cardsRepository.save(card);
        return true;
    }

    @Override
    public boolean deleteCard(Long cardId) {
        cardsRepository.findById(cardId).orElseThrow(
                () -> new ResourceNotFoundException("Card", "cardId", cardId.toString())
        );
        cardsRepository.deleteById(cardId);
        return true;
    }

}
