package org.ipunagri.support.parsers.pdf;


import java.io.File;

public interface PDFToHTMLConverter {

    default String convertToHTML(File file) {
        return null;
    }

}
