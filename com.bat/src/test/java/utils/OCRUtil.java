package utils;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class OCRUtil {

    public static String readCaptcha(File imageFile) {
        ITesseract tess = new Tesseract();
        tess.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // update path
        tess.setLanguage("eng");

        try {
            return tess.doOCR(imageFile).replaceAll("[^a-zA-Z0-9]", "");
        } catch (TesseractException e) {
            e.printStackTrace();
            return "";
        }
    }
}
