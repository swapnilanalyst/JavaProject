package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePreprocessor {

    public static File preprocessCaptcha(File inputFile, String outputPath) {
        try {
            BufferedImage original = ImageIO.read(inputFile);
            if (original == null) {
                System.err.println("❌ Failed to read image.");
                return null;
            }

            int width = original.getWidth();
            int height = original.getHeight();

            // Convert to grayscale (grayscale improves contrast and detail detection)
            BufferedImage gray = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
            Graphics2D g = gray.createGraphics();
            g.drawImage(original, 0, 0, null);
            g.dispose();

            // Save grayscale image to debug
            File grayImage = new File("gray_output.png");
            ImageIO.write(gray, "png", grayImage);
            System.out.println("Grayscale image saved for debugging.");

            // Apply adaptive thresholding (better for complex images)
            BufferedImage thresholded = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int grayPixel = gray.getRGB(x, y) & 0xff;  // Get grayscale pixel value
                    int threshold = 128;  // Adaptive thresholding to differentiate text from background
                    int color = grayPixel < threshold ? 0 : 255;  // Black for text, white for background
                    thresholded.setRGB(x, y, new Color(color, color, color).getRGB());
                }
            }

            // Save thresholded image to debug
            File thresholdedImage = new File("thresholded_output.png");
            ImageIO.write(thresholded, "png", thresholdedImage);
            System.out.println("Thresholded image saved for debugging.");

            // Apply simple noise removal (remove small black dots)
            BufferedImage denoised = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
            for (int y = 1; y < height - 1; y++) {
                for (int x = 1; x < width - 1; x++) {
                    int pixel = thresholded.getRGB(x, y) & 0xff;
                    if (pixel == 0) { // black pixel
                        int blackCount = 0;
                        // Check surrounding pixels to remove isolated black pixels (noise)
                        for (int j = -1; j <= 1; j++) {
                            for (int i = -1; i <= 1; i++) {
                                if (i == 0 && j == 0) continue;
                                int neighbor = thresholded.getRGB(x + i, y + j) & 0xff;
                                if (neighbor == 0) blackCount++;
                            }
                        }
                        if (blackCount <= 1) {
                            denoised.setRGB(x, y, new Color(255, 255, 255).getRGB()); // Remove noise
                        } else {
                            denoised.setRGB(x, y, new Color(0, 0, 0).getRGB()); // Keep character
                        }
                    } else {
                        denoised.setRGB(x, y, new Color(255, 255, 255).getRGB());
                    }
                }
            }

            // Save denoised image to debug
            File denoisedImage = new File("denoised_output.png");
            ImageIO.write(denoised, "png", denoisedImage);
            System.out.println("Denoised image saved for debugging.");

            // Save final output
            File finalOutput = new File(outputPath);
            ImageIO.write(denoised, "png", finalOutput);
            return finalOutput;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
