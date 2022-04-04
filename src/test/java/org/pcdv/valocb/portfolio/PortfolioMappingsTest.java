package org.pcdv.valocb.portfolio;

import org.junit.jupiter.api.Test;
import org.pcdv.valocb.csv.beans.PriceCsvBean;
import org.pcdv.valocb.utils.TestDataGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PortfolioMappingsTest {
    @Test
    void initializesPortfolioMappingsByNameFromCsvBeans() {
        List<PriceCsvBean> priceCsvBeans = TestDataGenerator.generatePriceCsvBeans();

        PortfolioMappings portfolioMappings = new PortfolioMappings(new HashMap<>(), priceCsvBeans);
        Map<String, Portfolio> result = portfolioMappings.getPortfolioMappingsByName();

        assertAll("results",
                () -> assertEquals("A1", result.get("PTF1").getProductsByName().get("A1").get(0).getName()),
                () -> assertEquals("A2", result.get("PTF2").getProductsByName().get("A2").get(0).getName())
        );
    }
}