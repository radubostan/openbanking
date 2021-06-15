package com.radub.openbanking.controller;

import java.io.File;
import io.swagger.model.OBErrorResponse1;
import io.swagger.model.OBReadAccount6;
import io.swagger.model.OBReadBalance1;
import io.swagger.model.OBReadBeneficiary5;
import io.swagger.model.OBReadDirectDebit2;
import io.swagger.model.OBReadOffer1;
import io.swagger.model.OBReadParty2;
import io.swagger.model.OBReadParty3;
import io.swagger.model.OBReadProduct2;
import io.swagger.model.OBReadScheduledPayment3;
import io.swagger.model.OBReadStandingOrder6;
import io.swagger.model.OBReadStatement2;
import io.swagger.model.OBReadTransaction6;
import org.threeten.bp.OffsetDateTime;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-15T10:33:38.546Z[GMT]")
@RestController
public class AccountsApiController implements AccountsApi {

    private static final Logger log = LoggerFactory.getLogger(AccountsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AccountsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }


    public ResponseEntity<OBReadTransaction6> getAccountsAccountIdTransactions(@Parameter(in = ParameterIn.PATH, description = "AccountId", required=true, schema=@Schema()) @PathVariable("AccountId") String accountId,@Parameter(in = ParameterIn.HEADER, description = "An Authorisation Token as per https://tools.ietf.org/html/rfc6750" ,required=true,schema=@Schema()) @RequestHeader(value="Authorization", required=true) String authorization,@Parameter(in = ParameterIn.HEADER, description = "The time when the PSU last logged in with the TPP.  All dates in the HTTP headers are represented as RFC 7231 Full Dates. An example is below:  Sun, 10 Sep 2017 19:43:31 UTC" ,schema=@Schema()) @RequestHeader(value="x-fapi-auth-date", required=false) String xFapiAuthDate,@Parameter(in = ParameterIn.HEADER, description = "The PSU's IP address if the PSU is currently logged in with the TPP." ,schema=@Schema()) @RequestHeader(value="x-fapi-customer-ip-address", required=false) String xFapiCustomerIpAddress,@Parameter(in = ParameterIn.HEADER, description = "An RFC4122 UID used as a correlation id." ,schema=@Schema()) @RequestHeader(value="x-fapi-interaction-id", required=false) String xFapiInteractionId,@Parameter(in = ParameterIn.HEADER, description = "Indicates the user-agent that the PSU is using." ,schema=@Schema()) @RequestHeader(value="x-customer-user-agent", required=false) String xCustomerUserAgent,@Parameter(in = ParameterIn.QUERY, description = "The UTC ISO 8601 Date Time to filter transactions FROM NB Time component is optional - set to 00:00:00 for just Date. If the Date Time contains a timezone, the ASPSP must ignore the timezone component." ,schema=@Schema()) @Valid @RequestParam(value = "fromBookingDateTime", required = false) OffsetDateTime fromBookingDateTime,@Parameter(in = ParameterIn.QUERY, description = "The UTC ISO 8601 Date Time to filter transactions TO NB Time component is optional - set to 00:00:00 for just Date. If the Date Time contains a timezone, the ASPSP must ignore the timezone component." ,schema=@Schema()) @Valid @RequestParam(value = "toBookingDateTime", required = false) OffsetDateTime toBookingDateTime) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<OBReadTransaction6>(objectMapper.readValue("{\n  \"Meta\" : {\n    \"FirstAvailableDateTime\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"TotalPages\" : 0\n  },\n  \"Links\" : {\n    \"Last\" : \"http://example.com/aeiou\",\n    \"Prev\" : \"http://example.com/aeiou\",\n    \"Next\" : \"http://example.com/aeiou\",\n    \"Self\" : \"http://example.com/aeiou\",\n    \"First\" : \"http://example.com/aeiou\"\n  },\n  \"Data\" : {\n    \"Transaction\" : [ {\n      \"Status\" : \"Booked\",\n      \"SupplementaryData\" : { },\n      \"CreditorAgent\" : {\n        \"PostalAddress\" : {\n          \"StreetName\" : \"StreetName\",\n          \"CountrySubDivision\" : \"CountrySubDivision\",\n          \"Department\" : \"Department\",\n          \"AddressLine\" : [ \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\" ],\n          \"BuildingNumber\" : \"BuildingNumber\",\n          \"TownName\" : \"TownName\",\n          \"Country\" : \"Country\",\n          \"SubDepartment\" : \"SubDepartment\",\n          \"AddressType\" : \"Business\",\n          \"PostCode\" : \"PostCode\"\n        },\n        \"SchemeName\" : \"SchemeName\",\n        \"Identification\" : \"Identification\",\n        \"Name\" : \"Name\"\n      },\n      \"DebtorAccount\" : { },\n      \"AccountId\" : \"AccountId\",\n      \"TransactionReference\" : \"TransactionReference\",\n      \"ProprietaryBankTransactionCode\" : {\n        \"Issuer\" : \"Issuer\",\n        \"Code\" : \"Code\"\n      },\n      \"AddressLine\" : \"AddressLine\",\n      \"Amount\" : {\n        \"Amount\" : \"Amount\",\n        \"Currency\" : \"Currency\"\n      },\n      \"CreditorAccount\" : {\n        \"SecondaryIdentification\" : \"SecondaryIdentification\",\n        \"SchemeName\" : \"SchemeName\",\n        \"Identification\" : \"Identification\",\n        \"Name\" : \"Name\"\n      },\n      \"CreditDebitIndicator\" : \"Credit\",\n      \"CurrencyExchange\" : {\n        \"SourceCurrency\" : \"SourceCurrency\",\n        \"ExchangeRate\" : 0.8008281904610115,\n        \"QuotationDate\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"UnitCurrency\" : \"UnitCurrency\",\n        \"ContractIdentification\" : \"ContractIdentification\",\n        \"InstructedAmount\" : { },\n        \"TargetCurrency\" : \"TargetCurrency\"\n      },\n      \"StatementReference\" : [ \"StatementReference\", \"StatementReference\" ],\n      \"ChargeAmount\" : { },\n      \"TransactionId\" : \"TransactionId\",\n      \"TransactionInformation\" : \"TransactionInformation\",\n      \"BookingDateTime\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"TransactionMutability\" : \"Mutable\",\n      \"BankTransactionCode\" : {\n        \"SubCode\" : \"SubCode\",\n        \"Code\" : \"Code\"\n      },\n      \"MerchantDetails\" : {\n        \"MerchantName\" : \"MerchantName\",\n        \"MerchantCategoryCode\" : \"MerchantCategoryCode\"\n      },\n      \"CardInstrument\" : {\n        \"AuthorisationType\" : \"ConsumerDevice\",\n        \"Identification\" : \"Identification\",\n        \"CardSchemeName\" : \"AmericanExpress\",\n        \"Name\" : \"Name\"\n      },\n      \"ValueDateTime\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"DebtorAgent\" : { },\n      \"Balance\" : {\n        \"Type\" : \"ClosingAvailable\",\n        \"Amount\" : { },\n        \"CreditDebitIndicator\" : \"Credit\"\n      }\n    }, {\n      \"Status\" : \"Booked\",\n      \"SupplementaryData\" : { },\n      \"CreditorAgent\" : {\n        \"PostalAddress\" : {\n          \"StreetName\" : \"StreetName\",\n          \"CountrySubDivision\" : \"CountrySubDivision\",\n          \"Department\" : \"Department\",\n          \"AddressLine\" : [ \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\", \"AddressLine\" ],\n          \"BuildingNumber\" : \"BuildingNumber\",\n          \"TownName\" : \"TownName\",\n          \"Country\" : \"Country\",\n          \"SubDepartment\" : \"SubDepartment\",\n          \"AddressType\" : \"Business\",\n          \"PostCode\" : \"PostCode\"\n        },\n        \"SchemeName\" : \"SchemeName\",\n        \"Identification\" : \"Identification\",\n        \"Name\" : \"Name\"\n      },\n      \"DebtorAccount\" : { },\n      \"AccountId\" : \"AccountId\",\n      \"TransactionReference\" : \"TransactionReference\",\n      \"ProprietaryBankTransactionCode\" : {\n        \"Issuer\" : \"Issuer\",\n        \"Code\" : \"Code\"\n      },\n      \"AddressLine\" : \"AddressLine\",\n      \"Amount\" : {\n        \"Amount\" : \"Amount\",\n        \"Currency\" : \"Currency\"\n      },\n      \"CreditorAccount\" : {\n        \"SecondaryIdentification\" : \"SecondaryIdentification\",\n        \"SchemeName\" : \"SchemeName\",\n        \"Identification\" : \"Identification\",\n        \"Name\" : \"Name\"\n      },\n      \"CreditDebitIndicator\" : \"Credit\",\n      \"CurrencyExchange\" : {\n        \"SourceCurrency\" : \"SourceCurrency\",\n        \"ExchangeRate\" : 0.8008281904610115,\n        \"QuotationDate\" : \"2000-01-23T04:56:07.000+00:00\",\n        \"UnitCurrency\" : \"UnitCurrency\",\n        \"ContractIdentification\" : \"ContractIdentification\",\n        \"InstructedAmount\" : { },\n        \"TargetCurrency\" : \"TargetCurrency\"\n      },\n      \"StatementReference\" : [ \"StatementReference\", \"StatementReference\" ],\n      \"ChargeAmount\" : { },\n      \"TransactionId\" : \"TransactionId\",\n      \"TransactionInformation\" : \"TransactionInformation\",\n      \"BookingDateTime\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"TransactionMutability\" : \"Mutable\",\n      \"BankTransactionCode\" : {\n        \"SubCode\" : \"SubCode\",\n        \"Code\" : \"Code\"\n      },\n      \"MerchantDetails\" : {\n        \"MerchantName\" : \"MerchantName\",\n        \"MerchantCategoryCode\" : \"MerchantCategoryCode\"\n      },\n      \"CardInstrument\" : {\n        \"AuthorisationType\" : \"ConsumerDevice\",\n        \"Identification\" : \"Identification\",\n        \"CardSchemeName\" : \"AmericanExpress\",\n        \"Name\" : \"Name\"\n      },\n      \"ValueDateTime\" : \"2000-01-23T04:56:07.000+00:00\",\n      \"DebtorAgent\" : { },\n      \"Balance\" : {\n        \"Type\" : \"ClosingAvailable\",\n        \"Amount\" : { },\n        \"CreditDebitIndicator\" : \"Credit\"\n      }\n    } ]\n  }\n}", OBReadTransaction6.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<OBReadTransaction6>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<OBReadTransaction6>(HttpStatus.NOT_IMPLEMENTED);
    }

}
