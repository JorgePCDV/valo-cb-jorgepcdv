package org.pcdv.valocb.portfolio;

import org.pcdv.valocb.product.Product;

import java.util.Queue;
import java.util.concurrent.ConcurrentMap;

public interface Portfolio {
    ConcurrentMap<String, Queue<Product>> getProductsByName();
}
