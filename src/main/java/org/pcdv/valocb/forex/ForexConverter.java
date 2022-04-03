package org.pcdv.valocb.forex;

import lombok.Getter;
import org.pcdv.valocb.csv.beans.ForexCsvBean;
import org.pcdv.valocb.currency.CurrencyCode;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;

@Getter
public class ForexConverter {
    private final EnumMap<CurrencyCode, EnumMap<CurrencyCode, BigDecimal>> forexConversionRates;

    public ForexConverter(List<ForexCsvBean> forexBeans) {
        forexConversionRates = new EnumMap<>(CurrencyCode.class);

        forexBeans.forEach(e -> {
            EnumMap<CurrencyCode, BigDecimal> fromCurrencyMapping = new EnumMap<>(CurrencyCode.class);
            fromCurrencyMapping.put(e.getToCurrency(), sanitizeBadForexValue(e.getValue()));
            forexConversionRates.put(e.getFromCurrency(), fromCurrencyMapping);

            // Reverse conversion rate
            EnumMap<CurrencyCode, BigDecimal> toCurrencyMapping = new EnumMap<>(CurrencyCode.class);
            toCurrencyMapping.put(e.getFromCurrency(), BigDecimal.ONE.divide(sanitizeBadForexValue(e.getValue())));
            forexConversionRates.put(e.getToCurrency(), toCurrencyMapping);
        });
    }

    private BigDecimal sanitizeBadForexValue(String value) {
        return new BigDecimal(value.replace(',','.'));
    }
}
