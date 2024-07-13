/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos_master.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Isuru
 */
public class ReportManager {
    
    private static ReportManager instance;

    public static ReportManager getInstance() {
        if (instance == null) {
            instance = new ReportManager();
        }
        return instance;
    }

    private ReportManager() {
    }

    public void printReportInvoice(ParameterReportInvoice data) {
        try {
            File initialFile = new File("src/pos_master/report/report_invoice.jrxml");
            JasperReport reportInvoice = JasperCompileManager.compileReport(new FileInputStream(initialFile));
            Map para = new HashMap();
            para.put("total", data.getTotal());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(null);
            JasperPrint print = JasperFillManager.fillReport(reportInvoice, para);
            view(print);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }
}
