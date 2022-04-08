package org.pcdv.valocb.csv.beans;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.pcdv.valocb.currency.CurrencyCode;

@Getter
@AllArgsConstructor
public class ForexCsvBean {
    public ForexCsvBean() {};

    @CsvBindByPosition(position = 0)
    private CurrencyCode fromCurrency;

    @CsvBindByPosition(position = 1)
    private CurrencyCode toCurrency;

    @CsvBindByPosition(position = 2)
    private String value;
}
