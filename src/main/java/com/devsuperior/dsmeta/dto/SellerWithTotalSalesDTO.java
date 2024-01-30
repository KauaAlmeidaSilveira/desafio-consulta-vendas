package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

public class SellerWithTotalSalesDTO {

    private String sellerName;
    private Double total;

    public SellerWithTotalSalesDTO() {
    }

    public SellerWithTotalSalesDTO(String sellerName, Double total) {
        this.sellerName = sellerName;
        this.total = total;
    }

    public SellerWithTotalSalesDTO(Sale sale) {
        sellerName = sale.getSeller().getName();
        total = sale.getAmount();
    }

    public String getSellerName() {
        return sellerName;
    }

    public Double getTotal() {
        return total;
    }
}
