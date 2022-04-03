package org.pcdv.valocb.client;

import lombok.Data;
import org.pcdv.valocb.portfolio.Portfolio;

import java.util.Map;

@Data
public class ClientImpl implements Client {
    private Map<String, Portfolio> portfoliosByName;
    private Map<String, Integer> productQuantities;
}
