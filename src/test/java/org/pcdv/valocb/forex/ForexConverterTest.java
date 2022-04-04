package org.pcdv.valocb.forex;

import org.junit.jupiter.api.Test;
import org.pcdv.valocb.csv.beans.ForexCsvBean;
import org.pcdv.valocb.currency.CurrencyCode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForexConverterTest {

    @Test
    void forexConverterInitializesForexConversionRatesWithReverseAndIdentity() {
        List<ForexCsvBean> forexCsvBeans = new ArrayList<>();
        forexCsvBeans.add(new ForexCsvBean(CurrencyCode.EUR, CurrencyCode.USD, "2"));
        ForexConverter forexConverter = new ForexConverter(forexCsvBeans);

        EnumMap<CurrencyCode, EnumMap<CurrencyCode, BigDecimal>> result = forexConverter.getForexConversionRates();

        assertAll("results",
                () -> assertTrue(result.containsKey(CurrencyCode.EUR)),
                () -> assertTrue(result.containsKey(CurrencyCode.USD)),
                () -> assertTrue(result.get(CurrencyCode.EUR).containsKey(CurrencyCode.USD)),
                () -> assertTrue(result.get(CurrencyCode.EUR).containsKey(CurrencyCode.EUR)),
                () -> assertTrue(result.get(CurrencyCode.USD).containsKey(CurrencyCode.EUR))
        );
    }

    @Test
    void forexConverterConvertsToExpectedRates() {
        List<ForexCsvBean> forexCsvBeans = new ArrayList<>();
        forexCsvBeans.add(new ForexCsvBean(CurrencyCode.EUR, CurrencyCode.USD, "2"));
        ForexConverter forexConverter = new ForexConverter(forexCsvBeans);

        assertAll("results",
                () -> assertEquals(new BigDecimal("2"), forexConverter.convertCurrency(CurrencyCode.EUR, CurrencyCode.USD)),
                () -> assertEquals(new BigDecimal("0.5"), forexConverter.convertCurrency(CurrencyCode.USD, CurrencyCode.EUR)),
                () -> assertEquals(new BigDecimal("1"), forexConverter.convertCurrency(CurrencyCode.EUR, CurrencyCode.EUR))
        );
    }
}