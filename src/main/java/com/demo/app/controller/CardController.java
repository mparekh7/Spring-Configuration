package com.demo.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.model.Card;
import com.demo.app.model.Wallet;
import com.demo.app.service.CardService;
import com.demo.app.service.WalletService;

@RestController
@RequestMapping(value = "card")
public class CardController {

	@Autowired
	CardService cardService;

	@Autowired
	WalletService walletService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Card> getCards(
			@RequestParam(required = false) String cardNumber,
			@RequestParam(required = false) String cardType,
			@RequestParam(required = false) Integer id) {
		List<Card> cards = new ArrayList<Card>();
		cards = cardService.findCardsByCriteria(cardNumber, id, cardType);
		return cards;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void saveCard(@RequestBody Card card) {
		System.out.println(card.getWallet());
		Wallet wallet = walletService.findByWalletId(card.getWallet().getId());
		System.out.println(wallet);
		card.setWallet(wallet);
		cardService.saveCard(card);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateCard(@RequestBody Card card) {
		cardService.updateCard(card);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteCard(@RequestParam int id) {
		cardService.deleteCardByCardId(id);
	}

}
