package org.pcdv.valocb.utils;

import org.pcdv.valocb.csv.beans.ForexCsvBean;
import org.pcdv.valocb.csv.beans.PriceCsvBean;
import org.pcdv.valocb.currency.CurrencyCode;
import org.pcdv.valocb.forex.ForexConverter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {
    public static ForexConverter generateForexConverter() {
        List<ForexCsvBean> forexCsvBeans = new ArrayList<>();
        forexCsvBeans.add(new ForexCsvBean(CurrencyCode.EUR, CurrencyCode.USD, "2"));
        ForexConverter forexConverter = new ForexConverter(forexCsvBeans);

        return forexConverter;
    }

    public static List<PriceCsvBean> generatePriceCsvBeans() {
        List<PriceCsvBean> priceCsvBeans = new ArrayList<>();
        priceCsvBeans.add(new PriceCsvBean("PTF1", "A1", "U1", CurrencyCode.EUR, new BigDecimal("5.5")));
        priceCsvBeans.add(new PriceCsvBean("PTF2", "A2", "U2", CurrencyCode.USD, new BigDecimal("10.7")));

        return priceCsvBeans;
    }
}
