package org.pcdv.valocb.csv.beans.converter;

import com.opencsv.bean.CsvToBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pcdv.valocb.csv.beans.ForexCsvBean;
import org.pcdv.valocb.csv.beans.factory.CsvToBeanFactory;

import java.io.FileNotFoundException;
import java.util.List;

public class CsvFileToBeanConverter {
    private static final Logger logger = LogManager.getLogger(CsvFileToBeanConverter.class);

    private final CsvToBeanFactory csvToBeanFactory;

    public CsvFileToBeanConverter(CsvToBeanFactory csvToBeanFactory) {
        this.csvToBeanFactory = csvToBeanFactory;
    }

    public List<ForexCsvBean> convertForexCsvToBeans() {
        List<ForexCsvBean> forexCsvBeans = null;
        try  {
            CsvToBean<ForexCsvBean> csvToBean = csvToBeanFactory.createCsvToBeanForex();
            forexCsvBeans = csvToBean.parse();
        } catch (FileNotFoundException e) {
            logger.error("Error while findind Forex CSV file: {}", e);
        }

        return forexCsvBeans;
    }
}
