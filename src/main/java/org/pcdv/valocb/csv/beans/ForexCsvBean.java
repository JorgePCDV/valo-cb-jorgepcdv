package org.pcdv.valocb.csv.beans;

import com.opencsv.bean.CsvBindByPosition;

public class ForexCsvBean {
    @CsvBindByPosition(position = 0)
    private String fromCurrency;

    @CsvBindByPosition(position = 1)
    private String toCurrency;

    @CsvBindByPosition(position = 2)
    private String value;
}
