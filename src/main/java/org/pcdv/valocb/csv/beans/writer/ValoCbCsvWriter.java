package org.pcdv.valocb.csv.beans.writer;

import com.opencsv.CSVWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pcdv.valocb.ValoCbRunner;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.opencsv.ICSVParser.DEFAULT_ESCAPE_CHARACTER;
import static com.opencsv.ICSVParser.DEFAULT_SEPARATOR;
import static com.opencsv.ICSVWriter.DEFAULT_LINE_END;
import static com.opencsv.ICSVWriter.NO_QUOTE_CHARACTER;

public class ValoCbCsvWriter {
    private static final Logger logger = LogManager.getLogger(ValoCbRunner.class);

    public void createCsvReportFile(List<String[]> csvList, String filename) {
        String outputFilePath = System.getProperty("user.dir") + filename;

        try (CSVWriter writer = new CSVWriter(
                new FileWriter(outputFilePath),
                DEFAULT_SEPARATOR,
                NO_QUOTE_CHARACTER,
                DEFAULT_ESCAPE_CHARACTER,
                DEFAULT_LINE_END
        )) {
            writer.writeAll(csvList);
        } catch (IOException e) {
            logger.error("Error while generating CSV pricing report: {}", e);
        }
    }

    public List<String[]> createPortfolioCsvData(Map<String, BigDecimal> portfolioPrices) {
        List<String[]> portfolioCsvList = new ArrayList<>();
        String[] header = {"Portfolio", "Price"};

        portfolioCsvList.add(header);

        portfolioPrices.forEach((k, v) -> {
            String[] record = {k, v.toString()};
            portfolioCsvList.add(record);
        });

        return portfolioCsvList;
    }
}
