package org.pcdv.valocb.csv.beans;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import org.pcdv.valocb.currency.CurrencyCode;

@Getter
public class PriceCsvBean {
    @CsvBindByPosition(position = 0)
    private String portfolio;

    @CsvBindByPosition(position = 1)
    private String product;

    @CsvBindByPosition(position = 2)
    private String underlying;

    @CsvBindByPosition(position = 3)
    private CurrencyCode currency;

    @CsvBindByPosition(position = 4)
    private int price;
}
