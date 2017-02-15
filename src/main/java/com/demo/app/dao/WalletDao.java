package com.demo.app.dao;

import java.util.List;

import com.demo.app.model.Card;
import com.demo.app.model.Wallet;

public interface WalletDao {

	void saveWallet(Wallet wallet);

	List<Wallet> findAllWallets();

	void deleteWalletByWalletId(int id);

	Wallet findByWalletId(int id);

	void updateWallet(Wallet wallet);
	
	List<Wallet> findWalletsByCriteria(String walletType, Integer walletId,
			Integer userId);
}
