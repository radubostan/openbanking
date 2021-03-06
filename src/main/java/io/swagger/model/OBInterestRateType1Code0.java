package io.swagger.model;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Rate type for overdraft fee/charge (where it is charged in terms of a rate rather than an amount)
 */
public enum OBInterestRateType1Code0 {
  INBB("INBB"),
    INFR("INFR"),
    INGR("INGR"),
    INLR("INLR"),
    INNE("INNE"),
    INOT("INOT");

  private String value;

  OBInterestRateType1Code0(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static OBInterestRateType1Code0 fromValue(String text) {
    for (OBInterestRateType1Code0 b : OBInterestRateType1Code0.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
