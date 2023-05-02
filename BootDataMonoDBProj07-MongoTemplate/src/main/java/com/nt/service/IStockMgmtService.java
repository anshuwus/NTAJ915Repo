package com.nt.service;

import java.util.List;

import com.nt.document.StockDetails;

public interface IStockMgmtService {
	
	public String registerStockDetails(StockDetails details);
	public String registerStockDetailsBatch(List<StockDetails> list);
	
	//finding documents with conditions.criteria
	public List<StockDetails> fetchStocksDetailsByExchange(String exchange);
	public List<StockDetails> fetchStockDetailsByPriceRange(double startPrice,double endPrice);
	public StockDetails fetchStockDetailsByStockId(int stockId);
	public String fetchAndUpdateStockDetailsByStockId(int stockId,double newPrice,String newExchangeName);
	public String modifyExchangeByStockPriceRange(double startPrice,double endPrice,String newExchangeName);
	public String registerOrUpdateStockByStockName(String stockName,double newPrice,String newExchange);
	public String fetchAndRemoveByStockName(String stockName);
	public String removeStocksByPriceRange(double start,double end);
}
