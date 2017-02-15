package com.demo.app.dao;

import java.util.List;

import com.demo.app.model.Card;

public interface CardDao {

	void saveCard(Card card);

	List<Card> findAllCards();

	void deleteCardByCardNumber(String cardNumber);

	Card findByCardNumber(String cardNumber);

	List<Card> findCardsByCriteria(String cardNumber, Integer cardId,
			String cardType);

	void updateCard(Card card);
	
	void deleteCardByCardId(int id);
}
