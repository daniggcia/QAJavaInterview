package com.qainterview.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String nombreArchivo) {
        File carpeta = new File("screenshots");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File captura = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destino = new File(carpeta, nombreArchivo + "_" + timestamp + ".png");

        try {
            Files.copy(captura.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Captura guardada en: " + destino.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al guardar la captura de pantalla: " + e.getMessage());
        }
    }

    public static void abrirCarpetaCapturas() {
        try {
            File carpeta = new File("screenshots");
            if (carpeta.exists() && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(carpeta);
            } else {
                System.err.println("La carpeta no existe o no es compatible con el escritorio.");
            }
        } catch (IOException e) {
            System.err.println("Error al abrir la carpeta de capturas: " + e.getMessage());
        }
    }
}