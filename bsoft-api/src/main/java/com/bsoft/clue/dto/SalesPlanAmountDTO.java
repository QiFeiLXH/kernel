package com.bsoft.clue.dto;

import java.io.Serializable;

public class SalesPlanAmountDTO implements Serializable {
    private Double estimateSoftware;
    private Double estimateNetSales;
    private Double estimateHardware;

    public Double getEstimateSoftware() {
        return estimateSoftware;
    }

    public void setEstimateSoftware(Double estimateSoftware) {
        this.estimateSoftware = estimateSoftware;
    }

    public Double getEstimateNetSales() {
        return estimateNetSales;
    }

    public void setEstimateNetSales(Double estimateNetSales) {
        this.estimateNetSales = estimateNetSales;
    }

    public Double getEstimateHardware() {
        return estimateHardware;
    }

    public void setEstimateHardware(Double estimateHardware) {
        this.estimateHardware = estimateHardware;
    }
}
