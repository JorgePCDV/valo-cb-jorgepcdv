package org.pcdv.valocb.product;


import org.pcdv.valocb.currency.CurrencyCode;

public interface Product {
    String getName();
    String getUnderlying();
    CurrencyCode getCurrencyCode();
    int getPrice();
}
