package com.kcedro.cards.controller;

import com.kcedro.cards.constants.CardsConstants;
import com.kcedro.cards.dto.CardDebtDto;
import com.kcedro.cards.dto.CardDto;
import com.kcedro.cards.dto.ResponseDto;
import com.kcedro.cards.service.ICardsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1/cards", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class CardsController {

    private ICardsService iCardsService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@Valid @RequestBody CardDto cardDto) {
        iCardsService.createCard(cardDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CardsConstants.STATUS_201, CardsConstants.MESSAGE_201));
    }


    @GetMapping("/available-amount")
    public ResponseEntity<Integer> fetchCardAvailableAmount(@RequestParam Long accountId) {
        int availableAmount = iCardsService.getAvailableAmount(accountId);
        return ResponseEntity.status(HttpStatus.OK).body(availableAmount);
    }

    @GetMapping("/get-limit")
    public ResponseEntity<Integer> fetchCardLimit(@RequestParam Long accountId) {
        int cardLimit = iCardsService.getCardLimit(accountId);
        return ResponseEntity.status(HttpStatus.OK).body(cardLimit);
    }

    @PutMapping("/update-available-amount")
    public ResponseEntity<ResponseDto> updateCardAvailableAmount(@Valid @RequestBody CardDebtDto cardDebtDto) {
        iCardsService.updateCardAvailableAmount(cardDebtDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CardsConstants.STATUS_201, CardsConstants.MESSAGE_201));
    }

    @PutMapping("/pay-debt")
    public ResponseEntity<ResponseDto> payDebt(@Valid @RequestBody CardDebtDto cardDebtDto) {
        boolean isUpdated = iCardsService.payDebt(cardDebtDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCardDetails(@RequestParam Long cardId) {
        boolean isDeleted = iCardsService.deleteCard(cardId);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_DELETE));
        }
    }

}
