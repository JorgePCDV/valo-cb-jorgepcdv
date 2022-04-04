package org.pcdv.valocb.calculator;

import org.pcdv.valocb.portfolio.Portfolio;

import java.math.BigDecimal;

public class PortfolioPriceCalculator {
    public BigDecimal calculatePortfolioPrice(Portfolio portfolio) {
        portfolio.getProductsByName().entrySet().iterator().next().getKey();

        return new BigDecimal("10");
    }
}
