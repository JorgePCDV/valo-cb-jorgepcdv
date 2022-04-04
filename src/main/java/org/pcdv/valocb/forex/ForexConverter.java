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
            forexConversionRates.putIfAbsent(e.getFromCurrency(), new EnumMap<>(CurrencyCode.class));
            EnumMap<CurrencyCode, BigDecimal> fromCurrencyMapping = forexConversionRates.get(e.getFromCurrency());
            fromCurrencyMapping.put(e.getToCurrency(), sanitizeBadForexValue(e.getValue()));

            // Reverse conversion rate
            forexConversionRates.putIfAbsent(e.getToCurrency(), new EnumMap<>(CurrencyCode.class));
            EnumMap<CurrencyCode, BigDecimal> toCurrencyMapping = forexConversionRates.get(e.getToCurrency());
            toCurrencyMapping.put(e.getFromCurrency(), BigDecimal.ONE.divide(sanitizeBadForexValue(e.getValue())));

            // Identity convertsion rate
            forexConversionRates.putIfAbsent(e.getFromCurrency(), new EnumMap<>(CurrencyCode.class));
            EnumMap<CurrencyCode, BigDecimal> identityCurrencyMapping = forexConversionRates.get(e.getFromCurrency());
            identityCurrencyMapping.put(e.getFromCurrency(), BigDecimal.ONE);
        });
    }

    public BigDecimal convertCurrency(CurrencyCode from, CurrencyCode to) {
        return forexConversionRates.get(from).get(to);
    }

    private BigDecimal sanitizeBadForexValue(String value) {
        return new BigDecimal(value.replace(',','.'));
    }
}
