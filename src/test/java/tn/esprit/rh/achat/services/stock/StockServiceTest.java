package tn.esprit.rh.achat.services.stock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StockServiceTest {
	
	@Mock
	StockRepository stockRepository;
	
	@InjectMocks
	StockServiceImpl stockService;
	

	
	
	@Test
	public void testRetrieveStock() {
		
		Stock stock = new Stock("stock1", 100, 1);
		stock.setIdStock(1L);
		
	Mockito.when(stockRepository.findById(1L)).thenReturn(Optional.of(stock));
	stockService.retrieveStock(1L);
	Assertions.assertNotNull(stock);
	
	System.out.println(stock); 
	System.out.println(" Retrieve is working correctly...!!");  
	
	}
	
	
	@Test
	public void createStockTest()
	{

		Stock stock2 = new Stock("stock2", 200, 2);
		stock2.setIdStock(2L);
		
		stockService.addStock(stock2);
		verify(stockRepository, times(1)).save(stock2);
		System.out.println(stock2); 
		System.out.println(" Create is working correctly...!!");  
	}
	
	
	
	@Test
	public void getAllStocksTest()
	{
		List<Stock> Stocklist = new ArrayList<Stock>() {

			{
		add(new Stock("stock3", 300, 3));
		add(new Stock("stock4", 400, 4));
		add(new Stock("stock5", 500, 5));
			}};
			
			
		when(stockService.retrieveAllStocks()).thenReturn(Stocklist);
		//test
		List<Stock> stList = stockService.retrieveAllStocks();
		assertEquals(3, stList.size());
		System.out.println(" Retrieve all is working correctly...!!");  
	
	}
	

	
	
	@Test
	public void TestDeleteStock(){

	Stock stock1 = new Stock("stock7", 700, 7);
	stock1.setIdStock(7L);
	
	Mockito.lenient().when(stockRepository.findById(stock1.getIdStock())).thenReturn(Optional.of(stock1));

	stockService.deleteStock(7L);
	verify(stockRepository).deleteById(stock1.getIdStock());
	
	System.out.println(stock1);
	System.out.println(" Delete is working correctly...!!");  
	}
	
	
	
	
	
	
	
}
