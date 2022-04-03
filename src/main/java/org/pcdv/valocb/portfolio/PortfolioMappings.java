package org.pcdv.valocb.portfolio;

import lombok.Data;
import org.pcdv.valocb.csv.beans.PriceCsvBean;
import org.pcdv.valocb.product.Product;
import org.pcdv.valocb.product.ProductImpl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
public class PortfolioMappings {
    private Map<String, Portfolio> portfolioMap;

    public PortfolioMappings(Map<String, Portfolio> portfolioMap, List<PriceCsvBean> priceCsvBeans) {
        this.portfolioMap = portfolioMap;

        priceCsvBeans.forEach(e -> {
            portfolioMap.putIfAbsent(e.getPortfolio(), new PortfolioImpl(new HashMap<>()));
            Portfolio portfolio = portfolioMap.get(e.getPortfolio());
            Map<String, List<Product>> portfolioProductMap = portfolio.getProductsByName();
            portfolioProductMap.putIfAbsent(e.getProduct(), new LinkedList<>());
            List<Product> portfolioProductList = portfolioProductMap.get(e.getProduct());
            portfolioProductList.add(new ProductImpl(e.getProduct(), e.getUnderlying(), e.getCurrency(), e.getPrice()));
        });
    }
}
