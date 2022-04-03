package org.pcdv.valocb.csv.beans.converter;

import com.opencsv.bean.CsvToBean;
import org.pcdv.valocb.csv.beans.ForexCsvBean;
import org.pcdv.valocb.csv.beans.factory.CsvToBeanFactory;

import java.io.*;
import java.util.List;

public class CsvFileToBeanConverter {
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
            e.printStackTrace();
        }

        return forexCsvBeans;
    }
}
