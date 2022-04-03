package org.pcdv.valocb.csv.beans;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;

@Getter
public class ProductCsvBean {
    @CsvBindByPosition(position = 0)
    private String product;

    @CsvBindByPosition(position = 1)
    private String client;

    @CsvBindByPosition(position = 2)
    private int quantity;
}
