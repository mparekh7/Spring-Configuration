package com.demo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.app.dao.WalletDao;
import com.demo.app.model.Card;
import com.demo.app.model.Wallet;

@Service("walletService")
@Transactional
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletDao dao;

	public void saveWallet(Wallet wallet) {
		dao.saveWallet(wallet);
	}

	public List<Wallet> findAllWallets() {
		return dao.findAllWallets();
	}

	public void deleteWalletByWalletId(int id) {
		dao.deleteWalletByWalletId(id);
	}

	public void updateWallet(Wallet wallet) {
		dao.updateWallet(wallet);
	}

	public Wallet findByWalletId(int id) {
		return dao.findByWalletId(id);
	}

	public List<Wallet> findWalletsByCriteria(String walletType,
			Integer walletId, Integer userId) {
		return dao.findWalletsByCriteria(walletType, walletId, userId);
	}
}