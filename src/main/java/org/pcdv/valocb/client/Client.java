package org.pcdv.valocb.client;

import org.pcdv.valocb.portfolio.Portfolio;

import java.util.Map;

public interface Client {
    public Map<String, Portfolio> getPortfoliosByName();
    public Map<String, Integer> getProductQuantities();
}
