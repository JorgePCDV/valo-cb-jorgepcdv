package org.pcdv.valocb.csv.beans.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.pcdv.valocb.csv.beans.ForexCsvBean;
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

    /*@Test
    void parsePriceCsvBeans() {
    }

    @Test
    void parseProductCsvBeans() {

    }*/
}