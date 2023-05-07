package com.geekster.Stock.repository;

import com.geekster.Stock.model.Stock;
import com.geekster.Stock.model.StockType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IStockRepository extends CrudRepository<Stock,Integer> {
    public List<Stock> findByStockType(StockType stockType);
    public List<Stock> findByStockPriceGreaterThanAndStockBirthTimeStampLessThanOrderByStockName(Double price, LocalDateTime date);
    @Query(value = "Select * from STOCK where STOCK_MARKET_CAP > : capPercentage" ,nativeQuery = true)
    public List<Stock> getAllStocksAboveMarketCap(Double capPercentage);
    @Modifying
    @Query(value = "update STOCK set STOCK_MARKET_CAP = :capPercentage where Stock_Id = :id" ,nativeQuery = true)
    public void updateMarketCapById(Double capPercentage,Integer id);
    @Modifying
    @Query(value = "delete from STOCk where Stock_Owner_Count <= :clientCount" ,nativeQuery = true)
    public void deleteStocksBasedOnCount(Integer clientCount);
    @Modifying
    @Query(value = "update Stock set STOCK_TYPE = :myType where STOCK_id :id", nativeQuery = true)
    public void modifyStockTypeById(String myType, Integer id);

}
