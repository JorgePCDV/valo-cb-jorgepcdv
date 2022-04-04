package org.pcdv.valocb.calculator;

import lombok.Getter;
import org.pcdv.valocb.csv.beans.PriceCsvBean;
import org.pcdv.valocb.currency.CurrencyCode;
import org.pcdv.valocb.forex.ForexConverter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Getter
public class ProductPriceCalculator {
    private CurrencyCode currencyCode;
    private ForexConverter forexConverter;
    private Map<String, BigDecimal> productPriceMappings;

    public ProductPriceCalculator(CurrencyCode convertTo,
                                  Map<String, BigDecimal> productPriceMappings,
                                  ForexConverter forexConverter,
                                  List<PriceCsvBean> priceCsvBeans) {
        this.currencyCode = convertTo;
        this.forexConverter = forexConverter;
        this.productPriceMappings = productPriceMappings;

        priceCsvBeans.forEach(e -> {
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
        });
    }
}
