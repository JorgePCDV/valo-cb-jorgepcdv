package org.pcdv.valocb.portfolio;

import lombok.Data;
import org.pcdv.valocb.product.Product;

import java.util.List;
import java.util.Map;

@Data
public class PortfolioImpl implements Portfolio {
    private final Map<String, List<Product>> productsByName;
}
