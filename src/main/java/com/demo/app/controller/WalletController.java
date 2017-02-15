package com.demo.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.model.Wallet;
import com.demo.app.service.WalletService;

@RestController
@RequestMapping(value = "wallet")
public class WalletController {

	@Autowired
	WalletService walletService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Wallet> getWallets(@RequestParam(required = false) String walletType,@RequestParam(required = false) Integer userId,@RequestParam(required = false) Integer id) {
		List<Wallet> wallets = new ArrayList<Wallet>();
		wallets = walletService.findWalletsByCriteria(walletType, id, userId); 
		return wallets;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void saveWallet(@RequestBody Wallet wallet) {
		walletService.saveWallet(wallet); 
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateWallet(@RequestBody Wallet wallet) {
		walletService.updateWallet(wallet); 
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteWallet(@RequestParam int id) {
		walletService.deleteWalletByWalletId(id);
	}

}
