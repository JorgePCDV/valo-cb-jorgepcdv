package org.pcdv.valocb.product;

import org.pcdv.valocb.currency.CurrencyCode;

import java.math.BigDecimal;

public interface Product {
    String getName();

    String getUnderlying();

    CurrencyCode getCurrencyCode();

    BigDecimal getPrice();
}
