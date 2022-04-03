package org.pcdv.valocb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pcdv.valocb.csv.beans.ForexCsvBean;
import org.pcdv.valocb.csv.beans.PriceCsvBean;
import org.pcdv.valocb.csv.beans.ProductCsvBean;
import org.pcdv.valocb.csv.beans.converter.CsvFileToBeanConverter;
import org.pcdv.valocb.csv.beans.factory.CsvToBeanFactory;
import org.pcdv.valocb.currency.CurrencyCode;
import org.pcdv.valocb.forex.ForexConverter;
import org.pcdv.valocb.portfolio.PortfolioMappings;
import org.pcdv.valocb.product.Product;
import org.pcdv.valocb.product.ProductImpl;

import java.util.HashMap;
import java.util.List;

public class ValoCbRunner {
    private static final Logger logger = LogManager.getLogger(ValoCbRunner.class);

    public static void main(String[] args) {
        logger.info("Init ValoCB App.");

        Product testProduct = new ProductImpl("P1", "U1", CurrencyCode.EUR, 10);
        logger.info("Test product is {}", testProduct);

        CsvFileToBeanConverter csvFileToBeanConverter = new CsvFileToBeanConverter(new CsvToBeanFactory());
        List<ForexCsvBean> forexCsvBeans = csvFileToBeanConverter.parseForexCsvBeans();
        List<PriceCsvBean> priceCsvBeans = csvFileToBeanConverter.parsePriceCsvBeans();
        List<ProductCsvBean> productCsvBeans = csvFileToBeanConverter.parseProductCsvBeans();

        ForexConverter forexConverter = new ForexConverter(forexCsvBeans);
        PortfolioMappings portfolioMappings = new PortfolioMappings(new HashMap<>(), priceCsvBeans);
    }
}
