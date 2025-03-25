package com.imt.reportes.controller;

import com.imt.reportes.model.Report;
import com.imt.reportes.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/reports/summary")
    public Report generateSummaryReport(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return reportService.generateSummaryReport(startDate, endDate);
    }

    @GetMapping("/reports/status")
    public List<Report> generateStatusReport(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return reportService.generateStatusReport(startDate, endDate);
    }
}
