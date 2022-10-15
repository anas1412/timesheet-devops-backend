package tn.esprit.rh.achat.services.stock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import tn.esprit.rh.achat.services.IStockService;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class StockServiceTest {

@Autowired
IStockService ss;

@Autowired
StockRepository sr;


@Test
@Order(1)
public void testRetrieveAllStock() 
{
List<Stock> listStocks = ss.retrieveAllStocks();
Assertions.assertEquals(3, listStocks.size());
}

@Test
@Order(2)
public void testCreateStock() {
    Stock savedstock = sr.save(new Stock("stock1", 100, 1));
     
    assertThat(savedstock.getIdStock()).isGreaterThan(0);
   
}



@Test
@Order(3)
public void testRetrieveStock() {
Stock stock = ss.retrieveStock(2L);
assertEquals(2L, stock.getIdStock().longValue());
}


@Test
@Order(4)
public void testDeleteStock() {
ss.deleteStock(6L);
assertNull(ss.retrieveStock(6L));
}

@Test
@Order(5)
public void testUpdateStock() {
    Stock stock = ss.retrieveStock(2L);
    stock.setQte(5);     
    sr.save(stock);     
    Stock updatedStock = ss.retrieveStock(2L);     
    assertThat(updatedStock.getQte()).isEqualTo(5);
}


}
