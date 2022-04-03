package org.pcdv.valocb.portfolio;

import org.pcdv.valocb.product.Product;

import java.util.List;
import java.util.Map;

public interface Portfolio {
    Map<String, List<Product>> getProductsByName();
}
