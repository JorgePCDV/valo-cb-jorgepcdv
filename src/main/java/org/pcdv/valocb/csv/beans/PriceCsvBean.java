package org.pcdv.valocb.csv.beans;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.pcdv.valocb.currency.CurrencyCode;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class PriceCsvBean {
    public PriceCsvBean() {}

    @CsvBindByPosition(position = 0)
    private String portfolio;

    @CsvBindByPosition(position = 1)
    private String product;

    @CsvBindByPosition(position = 2)
    private String underlying;

    @CsvBindByPosition(position = 3)
    private CurrencyCode currency;

    @CsvBindByPosition(position = 4)
    private BigDecimal price;
}
