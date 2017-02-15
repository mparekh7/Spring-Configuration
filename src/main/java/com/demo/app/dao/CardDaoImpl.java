package com.demo.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.demo.app.model.Card;

@Repository("cardDao")
public class CardDaoImpl extends AbstractDao implements CardDao {

	public void saveCard(Card card) {
		persist(card);
	}

	@SuppressWarnings("unchecked")
	public List<Card> findAllCards() {
		Criteria criteria = getSession().createCriteria(Card.class);
		return (List<Card>) criteria.list();
	}

	public void deleteCardByCardNumber(String cardNumber) {
		Query query = getSession().createSQLQuery(
				"delete from Card where card_number = :cardNumber");
		query.setText("cardNumber", cardNumber);
		query.executeUpdate();
	}

	public void updateCard(Card card) {
		getSession().update(card);
	}

	public Card findByCardNumber(String cardNumber) {
		Criteria criteria = getSession().createCriteria(Card.class);
		criteria.add(Restrictions.eq("cardNumber", cardNumber));
		return (Card) criteria.uniqueResult();
	}

	public List<Card> findCardsByCriteria(String cardNumber, Integer cardId,
			String cardType) {
		Criteria criteria = getSession().createCriteria(Card.class);
		if (cardNumber != null)
			criteria.add(Restrictions.eq("cardNumber", cardNumber));
		if (cardId != null)
			criteria.add(Restrictions.eq("id", cardId));
		if (cardType != null)
			criteria.add(Restrictions.eq("cardType", cardType));
		return (List<Card>) criteria.list();
	}

	public void deleteCardByCardId(int id) {
		Query query = getSession().createSQLQuery(
				"delete from Card where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
		
	}

}