package org.pcdv.valocb.product;

import lombok.Data;
import org.pcdv.valocb.currency.CurrencyCode;

@Data
public class ProductImpl implements Product {
    private final String name;
    private final String underlying;
    private final CurrencyCode currencyCode;
    private final int price;
}
