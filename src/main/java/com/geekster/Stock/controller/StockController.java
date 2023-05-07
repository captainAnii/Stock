package com.geekster.Stock.controller;

import com.geekster.Stock.model.Stock;
import com.geekster.Stock.model.StockType;
import com.geekster.Stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {
    @Autowired
    StockService stockService;
    @GetMapping(value = "/type/{stockType}")
    public List<Stock> getStockBasedOnType(@PathVariable StockType stockType){
        return stockService.getStockByType(stockType);
    }

    @GetMapping(value = "/cap/{capPercentage}")
    public List<Stock> getAllStockAboveMarketCap(@PathVariable Double capPercentage){
        return stockService.getAllStockAboveMarketCap(capPercentage);
    }
    @GetMapping(value = "/abovePrice/price/{price}/lowerData/date/{date}")
    public List<Stock> getStockAbovePriceAndLowerDate(@PathVariable Double price, String date){
        return stockService.getStockAbovePriceAndLowerDate(price,date);
    }
    @PostMapping(value = "/")
    public String insertStocks(@RequestBody List<Stock> stockList){
        return stockService.addStocks(stockList);
    }
    @PutMapping(value = "/marketCAp/{marketCap}/id/{id}")
    public void insertStocks(@PathVariable Double marketCap,@PathVariable Integer id){
        stockService.updateMarketCap(marketCap,id);
    }
    @PutMapping(value = "/stock/type/id")
    public void updateTypeById(@RequestParam StockType stockType, @RequestParam Integer id){
        stockService.updateTypeById(stockType,id);
    }
    @DeleteMapping(value="/ownerCount/{count}")
    public void removeStocksByOwnerCount(@PathVariable Integer count){
        stockService.deleteStocksBasedOnCount(count);
    }


}
