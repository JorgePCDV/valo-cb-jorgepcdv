package org.pcdv.valocb.calculator;

import lombok.Getter;
import org.pcdv.valocb.csv.beans.ProductCsvBean;

import java.util.List;
import java.util.Map;

@Getter
public class ProductQuantityCalculator {
    private Map<String, Integer> productQuantityMappings;

    public ProductQuantityCalculator(Map<String, Integer> productQuantityMappings, List<ProductCsvBean> productCsvBeans) {
        this.productQuantityMappings = productQuantityMappings;

        productCsvBeans.forEach(e -> {
            String productKey = e.getProduct();
            int productQuantity = e.getQuantity();

            productQuantityMappings.computeIfPresent(productKey, (k, v) -> v + productQuantity);
            productQuantityMappings.putIfAbsent(productKey, productQuantity);
        });
    }

    public int getProductQuantity(String productName) {
        return productQuantityMappings.get(productName);
    }
}
