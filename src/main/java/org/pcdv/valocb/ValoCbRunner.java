package org.pcdv.valocb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.pcdv.valocb.currency.CurrencyCode;
import org.pcdv.valocb.product.Product;
import org.pcdv.valocb.product.ProductImpl;

public class ValoCbRunner {
    private static final Logger logger = LogManager.getLogger(ValoCbRunner.class);

    public static void main(String[] args) {
        logger.info("Init ValoCB App.");

        Product testProduct = new ProductImpl("P1", "U1", CurrencyCode.EUR, 10);
        logger.info("Test product is {}", testProduct);
    }
}
