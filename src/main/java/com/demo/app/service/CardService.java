package com.demo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.app.model.Card;

public interface CardService{

	void saveCard(Card card);
	
	void updateCard(Card card);
	
	void deleteCardByCardId(int id);

	List<Card> findAllCards();

	void deleteCardByCardNumber(String cardNumber);

	Card findByCardNumber(String cardNumber);

	List<Card> findCardsByCriteria(String cardNumber, Integer cardId,
			String cardType);

}