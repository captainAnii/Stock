package com.geekster.Stock.service;


import com.geekster.Stock.model.Stock;
import com.geekster.Stock.model.StockType;
import com.geekster.Stock.repository.IStockRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockService{
    @Autowired
    IStockRepository iStockRepo;

    public List<Stock> getStockByType(StockType stockType) {
        return iStockRepo.findByStockType(stockType);
    }


    public String addStocks(List<Stock> stockList) {
        Iterable<Stock> list = iStockRepo.saveAll(stockList);
        if(list!=null){
            return "added list of Stocks";
        }else{
            return "could not added";
        }
    }

    public List<Stock> getStockAbovePriceAndLowerDate(Double price, String date) {
        LocalDateTime myDate = LocalDateTime.parse(date);
        return iStockRepo.findByStockPriceGreaterThanAndStockBirthTimeStampLessThanOrderByStockName(price,myDate);
    }

    public List<Stock> getAllStockAboveMarketCap(Double capPercentage) {
        return iStockRepo.getAllStocksAboveMarketCap(capPercentage);
    }
    @Transactional
    public void updateMarketCap(Double marketCap, Integer id) {
        iStockRepo.updateMarketCapById(marketCap,id);
    }
    @Transactional
    public void deleteStocksBasedOnCount(Integer count) {
        iStockRepo.deleteStocksBasedOnCount(count);
    }

    @Transactional
    public void updateTypeById(StockType stockType, Integer id) {
//        int value = stockType.ordinal();
        String enumValue = stockType.name();
        iStockRepo.modifyStockTypeById(enumValue,id);
    }
}
