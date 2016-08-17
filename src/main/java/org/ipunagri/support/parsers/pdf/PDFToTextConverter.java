package org.ipunagri.support.parsers.pdf;


import java.io.File;

public interface PDFToTextConverter {

    default String convertToText(File file){
        return null;
    }

}
