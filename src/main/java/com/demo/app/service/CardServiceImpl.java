package com.demo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.app.dao.CardDao;
import com.demo.app.model.Card;

@Service("cardService")
@Transactional
public class CardServiceImpl implements CardService {

	@Autowired
	private CardDao dao;

	public void saveCard(Card card) {
		dao.saveCard(card);
	}

	public List<Card> findAllCards() {
		return dao.findAllCards();
	}

	public void deleteCardByCardNumber(String cardNumber) {
		dao.deleteCardByCardNumber(cardNumber);
	}

	public void updateCard(Card card) {
		dao.updateCard(card);
	}

	public Card findByCardNumber(String cardNumber) {
		return dao.findByCardNumber(cardNumber);
	}

	public List<Card> findCardsByCriteria(String cardNumber, Integer cardId,
			String cardType) {
		return dao.findCardsByCriteria(cardNumber, cardId, cardType);
	}

	public void deleteCardByCardId(int id) {
		dao.deleteCardByCardId(id);
	}
}