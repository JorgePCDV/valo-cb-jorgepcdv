package org.pcdv.valocb.portfolio;

import lombok.Data;
import org.pcdv.valocb.csv.beans.PriceCsvBean;
import org.pcdv.valocb.product.Product;
import org.pcdv.valocb.product.ProductImpl;

import java.util.*;

@Data
public class PortfolioMappings {
    private Map<String, Portfolio> portfolioMappingsByName;

    public PortfolioMappings(Map<String, Portfolio> portfolioMap, List<PriceCsvBean> priceCsvBeans) {
        this.portfolioMappingsByName = portfolioMap;

        priceCsvBeans.forEach(e -> {
            portfolioMappingsByName.putIfAbsent(e.getPortfolio(), new PortfolioImpl(e.getPortfolio(), new HashMap<>()));
            Portfolio portfolio = portfolioMappingsByName.get(e.getPortfolio());
            Map<String, List<Product>> portfolioProductMap = portfolio.getProductsByName();

            portfolioProductMap.putIfAbsent(e.getProduct(), new LinkedList<>());
            List<Product> portfolioProductList = portfolioProductMap.get(e.getProduct());
            portfolioProductList.add(new ProductImpl(e.getProduct(), e.getUnderlying(), e.getCurrency(), e.getPrice()));
        });
    }

    public Collection<Portfolio> getPortfolios() {
        return portfolioMappingsByName.values();
    }
}
