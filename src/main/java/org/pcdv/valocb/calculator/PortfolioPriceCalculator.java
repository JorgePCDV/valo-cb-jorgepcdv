package org.pcdv.valocb.calculator;

import lombok.Getter;
import org.pcdv.valocb.portfolio.PortfolioMappings;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

@Getter
public class PortfolioPriceCalculator {
    private Map<String, BigDecimal> portfolioPriceMappings;
    private ProductPriceCalculator productPriceCalculator;
    private ProductQuantityCalculator productQuantityCalculator;

    public PortfolioPriceCalculator(Map<String, BigDecimal> portfolioPriceMappings,
                                    PortfolioMappings portfolioMappings,
                                    ProductPriceCalculator productPriceCalculator,
                                    ProductQuantityCalculator productQuantityCalculator) {
        this.portfolioPriceMappings = portfolioPriceMappings;
        this.productPriceCalculator = productPriceCalculator;
        this.productQuantityCalculator = productQuantityCalculator;

        portfolioMappings.getPortfolios().forEach(p -> {
            String portfolioName = p.getPortfolioName();
            Set<String> productSet = p.getProductsByName().keySet();
            portfolioPriceMappings.put(portfolioName, BigDecimal.ZERO);
            productSet.forEach(pr -> {
                BigDecimal productPrice = BigDecimal.valueOf(productQuantityCalculator.getProductQuantity(pr)).multiply(productPriceCalculator.getProductPrice(pr));
                portfolioPriceMappings.computeIfPresent(portfolioName, (k, v) -> v.add(productPrice));
            });
        });
    }
}
