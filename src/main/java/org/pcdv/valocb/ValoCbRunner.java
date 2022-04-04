package org.pcdv.valocb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pcdv.valocb.calculator.PortfolioPriceCalculator;
import org.pcdv.valocb.calculator.ProductPriceCalculator;
import org.pcdv.valocb.calculator.ProductQuantityCalculator;
import org.pcdv.valocb.csv.beans.ForexCsvBean;
import org.pcdv.valocb.csv.beans.PriceCsvBean;
import org.pcdv.valocb.csv.beans.ProductCsvBean;
import org.pcdv.valocb.csv.beans.converter.CsvFileToBeanConverter;
import org.pcdv.valocb.csv.beans.factory.CsvToBeanFactory;
import org.pcdv.valocb.currency.CurrencyCode;
import org.pcdv.valocb.forex.ForexConverter;
import org.pcdv.valocb.portfolio.PortfolioMappings;

import java.util.HashMap;
import java.util.List;

public class ValoCbRunner {
    private static final Logger logger = LogManager.getLogger(ValoCbRunner.class);

    public static void main(String[] args) {
        logger.info("Init ValoCB App.");

        CsvFileToBeanConverter csvFileToBeanConverter = new CsvFileToBeanConverter(new CsvToBeanFactory());
        List<ForexCsvBean> forexCsvBeans = csvFileToBeanConverter.parseForexCsvBeans();
        List<PriceCsvBean> priceCsvBeans = csvFileToBeanConverter.parsePriceCsvBeans();
        List<ProductCsvBean> productCsvBeans = csvFileToBeanConverter.parseProductCsvBeans();

        ForexConverter forexConverter = new ForexConverter(forexCsvBeans);

        PortfolioMappings portfolioMappings = new PortfolioMappings(new HashMap<>(), priceCsvBeans);
        ProductPriceCalculator euroProductPriceCalculator = new ProductPriceCalculator(CurrencyCode.EUR, new HashMap<>(), forexConverter, priceCsvBeans);
        ProductQuantityCalculator productQuantityCalculator = new ProductQuantityCalculator(new HashMap<>(), productCsvBeans);
        PortfolioPriceCalculator portfolioPriceCalculator = new PortfolioPriceCalculator(new HashMap<>(), portfolioMappings, euroProductPriceCalculator, productQuantityCalculator);
    }
}
