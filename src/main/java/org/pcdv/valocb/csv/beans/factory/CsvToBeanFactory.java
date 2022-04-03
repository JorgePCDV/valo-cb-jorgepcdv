package org.pcdv.valocb.csv.beans.factory;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.pcdv.valocb.csv.beans.ForexCsvBean;
import org.pcdv.valocb.csv.beans.PriceCsvBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

public class CsvToBeanFactory {
    public CsvToBean<ForexCsvBean> createCsvToBeanForex() throws FileNotFoundException {
        return createCsvToBean("csv/Forex.csv", 5, ForexCsvBean.class);
    }

    public CsvToBean<PriceCsvBean> createCsvToBeanPrice() throws FileNotFoundException {
        return createCsvToBean("csv/Prices.csv", 4, PriceCsvBean.class);
    }

    private <T> CsvToBean<T> createCsvToBean(String fileName, int skipLines, Class beanClass) throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        String filePath = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile()).getAbsolutePath();

        return new CsvToBeanBuilder(new FileReader(filePath))
                .withType(beanClass)
                .withSkipLines(skipLines)
                .build();
    }
}
