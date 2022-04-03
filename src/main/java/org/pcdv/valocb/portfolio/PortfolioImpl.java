package org.pcdv.valocb.portfolio;

import lombok.Data;
import org.pcdv.valocb.product.Product;

import java.util.Queue;
import java.util.concurrent.ConcurrentMap;

@Data
public class PortfolioImpl implements Portfolio {
    private final ConcurrentMap<String, Queue<Product>> productsByName;
}
