package org.pcdv.valocb.csv.beans.converter;

import com.opencsv.bean.CsvToBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pcdv.valocb.csv.beans.ForexCsvBean;
import org.pcdv.valocb.csv.beans.PriceCsvBean;
import org.pcdv.valocb.csv.beans.ProductCsvBean;
import org.pcdv.valocb.csv.beans.factory.CsvToBeanFactory;

import java.io.FileNotFoundException;
import java.util.List;

public class CsvFileToBeanConverter {
    private static final Logger logger = LogManager.getLogger(CsvFileToBeanConverter.class);

    private final CsvToBeanFactory csvToBeanFactory;

    public CsvFileToBeanConverter(CsvToBeanFactory csvToBeanFactory) {
        this.csvToBeanFactory = csvToBeanFactory;
    }

    public List<ForexCsvBean> parseForexCsvBeans() {
        List<ForexCsvBean> forexCsvBeans = null;
        try  {
            CsvToBean<ForexCsvBean> csvToBean = csvToBeanFactory.createCsvToBeanForex();
            forexCsvBeans = csvToBean.parse();
        } catch (FileNotFoundException e) {
            logger.error("Error while finding Forex CSV file: {}", e);
        }

        return forexCsvBeans;
    }

    public List<PriceCsvBean> parsePriceCsvBeans() {
        List<PriceCsvBean> priceCsvBeans = null;
        try  {
            CsvToBean<PriceCsvBean> csvToBean = csvToBeanFactory.createCsvToBeanPrice();
            priceCsvBeans = csvToBean.parse();
        } catch (FileNotFoundException e) {
            logger.error("Error while finding Price CSV file: {}", e);
        }

        return priceCsvBeans;
    }

    public List<ProductCsvBean> parseProductCsvBeans() {
        List<ProductCsvBean> productCsvBeans = null;
        try {
            CsvToBean<ProductCsvBean> csvToBean = csvToBeanFactory.createCsvToBeanProduct();
            productCsvBeans = csvToBean.parse();
        } catch (FileNotFoundException e) {
            logger.error("Error while finding Product CSV file: {}", e);
        }

        return productCsvBeans;
    }
}
