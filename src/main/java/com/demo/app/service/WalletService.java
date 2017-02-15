package com.demo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.app.model.Card;
import com.demo.app.model.Wallet;

public interface WalletService {

	void saveWallet(Wallet wallet);

	List<Wallet> findAllWallets();

	void deleteWalletByWalletId(int id);

	Wallet findByWalletId(int id);

	void updateWallet(Wallet wallet);
	
	List<Wallet> findWalletsByCriteria(String walletType, Integer walletId,
			Integer userId);
}