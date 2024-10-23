package com.kcedro.cards.repository;

import com.kcedro.cards.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardsRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByAccountId(Long accountId);

    Optional<Card> findByCardNumber(String cardNumber);

}
