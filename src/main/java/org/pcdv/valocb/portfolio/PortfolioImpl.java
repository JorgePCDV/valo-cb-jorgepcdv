package org.pcdv.valocb.portfolio;

import lombok.Data;
import org.pcdv.valocb.product.Product;

import java.util.List;
import java.util.Map;

@Data
public class PortfolioImpl implements Portfolio {
    private Map<String, List<Product>> productsByName;
    private String portfolioName;

    public PortfolioImpl(String portfolioName, Map<String, List<Product>> productsByName) {
        this.portfolioName = portfolioName;
        this.productsByName = productsByName;
    }
}
