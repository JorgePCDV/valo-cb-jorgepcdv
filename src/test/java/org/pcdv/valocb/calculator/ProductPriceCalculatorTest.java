package org.pcdv.valocb.calculator;

import org.junit.jupiter.api.Test;
import org.pcdv.valocb.csv.beans.PriceCsvBean;
import org.pcdv.valocb.currency.CurrencyCode;
import org.pcdv.valocb.forex.ForexConverter;
import org.pcdv.valocb.utils.TestDataGenerator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductPriceCalculatorTest {

    @Test
    void initializesProductPriceMappingsCorrectlyWithRespectToForexRates() {
        ForexConverter forexConverter = TestDataGenerator.generateForexConverter();
        List<PriceCsvBean> priceCsvBeans = TestDataGenerator.generatePriceCsvBeans();

        ProductPriceCalculator productPriceCalculator = new ProductPriceCalculator(CurrencyCode.EUR, new HashMap<>(), forexConverter, priceCsvBeans);

        assertAll("results",
                () -> assertEquals(new BigDecimal("5.5"), productPriceCalculator.getProductPrice("A1")),
                () -> assertEquals(new BigDecimal("5.35"), productPriceCalculator.getProductPrice("A2"))
        );
    }
}