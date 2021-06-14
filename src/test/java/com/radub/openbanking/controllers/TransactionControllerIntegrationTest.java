package com.radub.openbanking.controllers;

import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import javax.annotation.PostConstruct;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.http.HttpStatus.OK;
import static io.restassured.http.ContentType.JSON;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.radub.openbanking.models.Transaction;
import com.radub.openbanking.services.TransactionService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class TransactionControllerIntegrationTest {

	@LocalServerPort
	private int port;

	private String uri;

	@PostConstruct
	public void init() {
		uri = "http://localhost:" + port;
	}
	
	
    @MockBean
    private TransactionService transactionService;
    
    private static final String ACCOUNT_NUMBER="1239939";
    private static final BigDecimal AMOUNT = new BigDecimal(28.45);
      
   
    @Test
    public void givenMatchingTransactionsWhenFindAllByAccountNumberThenRespondWithStatusOk() {    
    	    
    	Transaction transaction= Transaction.builder().accountNumber(ACCOUNT_NUMBER).amount(AMOUNT).build();    
    	List<Transaction> transactions=new ArrayList<>();
    	transactions.add(transaction);
    	
        when(transactionService.findAllByAccountNumber(ACCOUNT_NUMBER)).thenReturn(transactions);

        given()
        .when()
          .get(uri + "/transactions/"+ACCOUNT_NUMBER)
        .then()
          .log().ifValidationFails()
          .statusCode(OK.value())
          .contentType(JSON)
          .body("$.size()", Matchers.equalTo(1))
          .body("[0].accountNumber", Matchers.equalTo(ACCOUNT_NUMBER))
          .body("[0].amount", Matchers.comparesEqualTo(AMOUNT.floatValue()));
    }


}
