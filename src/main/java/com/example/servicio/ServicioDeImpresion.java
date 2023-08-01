package com.example.servicio;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ServicioDeImpresion {

    final String PIE_DE_PAGINA = "/reportes/PiePagina.jasper";
    final String CABECERA = "/reportes/Cabecera.jasper";

    public JasperPrint obtenerJasperPrint(Collection<?> coleccion) throws JRException, IOException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("TITULO_REPORTE", "el titulo del parametro");

        URL urlPieDePagina = getClass().getResource(PIE_DE_PAGINA);
        if (urlPieDePagina != null) {
            try {
                URI uriPieDePagina = urlPieDePagina.toURI();
                parametros.put("SUBREPORTE_PIE_DE_PAGINA", new File(uriPieDePagina).getCanonicalPath());
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        URL urlCabecera = getClass().getResource(CABECERA);
        if (urlCabecera != null) {
            try {
                URI uriCabecera = urlCabecera.toURI();
                parametros.put("SUBREPORTE_ENCABEZADO", new File(uriCabecera).getCanonicalPath());
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(coleccion);
        JasperPrint jasperPrint = JasperFillManager.fillReport(ServicioDeImpresion.class.getClassLoader().getResourceAsStream("reportes/personas.jasper"), parametros, dataSource);
        return jasperPrint;
    }

    public void mostrarImpresionEnPantalla(Collection<?> coleccion) throws JRException, IOException {
        JasperPrint jasperPrint = obtenerJasperPrint(coleccion);
        JasperViewer vista = new JasperViewer(jasperPrint, Boolean.FALSE);
        vista.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        vista.setVisible(Boolean.TRUE);
    }

    private byte[] exportarPdf(Collection<?> coleccion) throws JRException, IOException {
        JasperPrint jasperPrint = obtenerJasperPrint(coleccion);

        JRPdfExporter exporter = new JRPdfExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

        SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);

        SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();

        exporter.setConfiguration(reportConfig);
        exporter.setConfiguration(exportConfig);
        exporter.exportReport();
        return outputStream.toByteArray();
    }
}
