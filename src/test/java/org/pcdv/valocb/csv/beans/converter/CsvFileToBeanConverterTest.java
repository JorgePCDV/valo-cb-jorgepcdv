package org.pcdv.valocb.csv.beans.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.pcdv.valocb.csv.beans.ForexCsvBean;
import org.pcdv.valocb.csv.beans.PriceCsvBean;
import org.pcdv.valocb.csv.beans.ProductCsvBean;
import org.pcdv.valocb.csv.beans.factory.CsvToBeanFactory;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvFileToBeanConverterTest {

    private CsvToBeanFactory csvToBeanFactory;
    private CsvFileToBeanConverter sut;

    @BeforeEach
    void setUp() {
        this.csvToBeanFactory = new CsvToBeanFactory();
        this.sut = new CsvFileToBeanConverter(csvToBeanFactory);
    }

    @Test
    void parseForexCsvBeans() {
        List<ForexCsvBean> result = sut.parseForexCsvBeans();

        assertAll("results",
                () -> assertEquals("2", result.get(0).getValue()),
                () -> assertEquals("4", result.get(1).getValue()),
                () -> assertEquals("0,5", result.get(2).getValue()),
                () -> assertEquals("8", result.get(3).getValue()),
                () -> assertEquals("10", result.get(4).getValue())
        );
    }

    @Test
    void parseForexCsvBeansNullWhenFileNotFound() throws FileNotFoundException {
        CsvToBeanFactory mockCsvToBeanFactory = Mockito.mock(CsvToBeanFactory.class);
        CsvFileToBeanConverter faultyFileToBeanConverter = new CsvFileToBeanConverter(mockCsvToBeanFactory);
        Mockito.when(mockCsvToBeanFactory.createCsvToBeanForex()).thenThrow(new FileNotFoundException());

        List<ForexCsvBean> result = faultyFileToBeanConverter.parseForexCsvBeans();

        assertNull(result);
    }

    @Test
    void parsePriceCsvBeans() {
        List<PriceCsvBean> result = sut.parsePriceCsvBeans();

        assertAll("results",
                () -> assertEquals("U11", result.get(0).getUnderlying()),
                () -> assertEquals("U12", result.get(1).getUnderlying()),
                () -> assertEquals("U13", result.get(2).getUnderlying()),
                () -> assertEquals("U21", result.get(3).getUnderlying()),
                () -> assertEquals("U31", result.get(4).getUnderlying())
        );
    }

    @Test
    void parsePriceCsvBeansNullWhenFileNotFound() throws FileNotFoundException {
        CsvToBeanFactory mockCsvToBeanFactory = Mockito.mock(CsvToBeanFactory.class);
        CsvFileToBeanConverter faultyFileToBeanConverter = new CsvFileToBeanConverter(mockCsvToBeanFactory);
        Mockito.when(mockCsvToBeanFactory.createCsvToBeanPrice()).thenThrow(new FileNotFoundException());

        List<PriceCsvBean> result = faultyFileToBeanConverter.parsePriceCsvBeans();

        assertNull(result);
    }

    @Test
    void parseProductCsvBeans() {
        List<ProductCsvBean> result = sut.parseProductCsvBeans();

        assertAll("results",
                () -> assertEquals("C1", result.get(0).getClient()),
                () -> assertEquals("C2", result.get(1).getClient()),
                () -> assertEquals("C3", result.get(2).getClient()),
                () -> assertEquals("C4", result.get(3).getClient()),
                () -> assertEquals("C5", result.get(4).getClient())
        );
    }

    @Test
    void parseProductCsvBeansNullWhenFileNotFound() throws FileNotFoundException {
        CsvToBeanFactory mockCsvToBeanFactory = Mockito.mock(CsvToBeanFactory.class);
        CsvFileToBeanConverter faultyFileToBeanConverter = new CsvFileToBeanConverter(mockCsvToBeanFactory);
        Mockito.when(mockCsvToBeanFactory.createCsvToBeanProduct()).thenThrow(new FileNotFoundException());

        List<ProductCsvBean> result = faultyFileToBeanConverter.parseProductCsvBeans();

        assertNull(result);
    }
}