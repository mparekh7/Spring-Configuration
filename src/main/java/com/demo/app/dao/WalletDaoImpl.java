package com.demo.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.demo.app.model.Card;
import com.demo.app.model.Wallet;

@Repository("walletDao")
public class WalletDaoImpl extends AbstractDao implements WalletDao {

	public void saveWallet(Wallet wallet) {
		persist(wallet);
	}

	@SuppressWarnings("unchecked")
	public List<Wallet> findAllWallets() {
		Criteria criteria = getSession().createCriteria(Wallet.class);
		return (List<Wallet>) criteria.list();
	}

	public void deleteWalletByWalletId(int id) {
		Query query = getSession().createSQLQuery(
				"delete from Wallets where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	public void updateWallet(Wallet wallet) {
		getSession().update(wallet);
	}

	public Wallet findByWalletId(int id) {
		Criteria criteria = getSession().createCriteria(Wallet.class);
		criteria.add(Restrictions.eq("id", id));
		return (Wallet) criteria.uniqueResult();
	}

	public List<Wallet> findWalletsByCriteria(String walletType,
			Integer walletId, Integer userId) {
		Criteria criteria = getSession().createCriteria(Wallet.class);
		if (walletType != null)
			criteria.add(Restrictions.eq("walletType", walletType));
		if (walletId != null)
			criteria.add(Restrictions.eq("id", walletId));
		if (userId != null)
			criteria.add(Restrictions.eq("userId", userId));
		return (List<Wallet>) criteria.list();
	}

}