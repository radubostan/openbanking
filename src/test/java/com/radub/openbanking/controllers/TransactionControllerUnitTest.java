package com.radub.openbanking.controllers;

import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.http.HttpStatus.OK;
import static io.restassured.http.ContentType.JSON;

import com.radub.openbanking.models.Transaction;
import com.radub.openbanking.services.TransactionService;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
@ActiveProfiles("test")
class TransactionControllerUnitTest {

    @MockBean
    private TransactionService transactionService;
    
    private static final String ACCOUNT_NUMBER="1239939";
    private static final BigDecimal AMOUNT = new BigDecimal(28.45);
      
   
    @BeforeEach
    public void setUp() {     	
     	RestAssuredMockMvc.standaloneSetup(new TransactionController(transactionService));
    }
    
    @Test
    public void givenMatchingTransactionsWhenFindAllByAccountNumberThenRespondWithStatusOk() {    
    	    
    	Transaction transaction= Transaction.builder().accountNumber(ACCOUNT_NUMBER).amount(AMOUNT).build();    
    	List<Transaction> transactions=new ArrayList<>();
    	transactions.add(transaction);
    	
        when(transactionService.findAllByAccountNumber(ACCOUNT_NUMBER)).thenReturn(transactions);

        given()
        .when()
          .get("/transactions/"+ACCOUNT_NUMBER)
        .then()
          .log().ifValidationFails()
          .statusCode(OK.value())
          .contentType(JSON)
          .body("$.size()", Matchers.equalTo(1))
          .body("[0].accountNumber", Matchers.equalTo(ACCOUNT_NUMBER))
          .body("[0].amount", Matchers.comparesEqualTo(AMOUNT.floatValue()));
    }


}
