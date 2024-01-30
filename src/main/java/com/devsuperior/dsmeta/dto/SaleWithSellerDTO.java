package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

import java.time.LocalDate;

public class SaleWithSellerDTO {

    private Long id;
    private LocalDate date;
	private Double amount;
    private String sellerName;

    public SaleWithSellerDTO() {
    }

    public SaleWithSellerDTO(Long id, Double amount, LocalDate date, String sellerName) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.sellerName = sellerName;
    }

    public SaleWithSellerDTO(Sale sale) {
        id = sale.getId();
        amount = sale.getAmount();
        date = sale.getDate();
        sellerName = sale.getSeller().getName();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getSellerName() {
        return sellerName;
    }
}
