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

        /*productCsvBeans.forEach(e -> {
            CurrencyCode convertFrom = e.getCurrency();
            BigDecimal conversionRate = forexConverter.convertCurrency(convertFrom, convertTo);
            String productKey = e.getProduct();
            BigDecimal priceRateConverted = e.getPrice().multiply(conversionRate);

            if (productPriceMappings.containsKey(productKey)) {
                BigDecimal oldPrice = productPriceMappings.get(productKey);
                BigDecimal newPrice = oldPrice.add(priceRateConverted);
                productPriceMappings.put(productKey, newPrice);
            } else {
                productPriceMappings.put(productKey, priceRateConverted);
            }

            productQuantityMappings.comp
        });*/
    }
}
