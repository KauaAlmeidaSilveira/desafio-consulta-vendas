package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleWithSellerDTO;
import com.devsuperior.dsmeta.dto.SellerWithTotalSalesDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private LocalDate[] stringToLocalDate(String minDate, String maxDate){
         if (maxDate.isEmpty()) {
            maxDate = LocalDate.now().format(formatter);
        }
        if (minDate.isEmpty()) {
            minDate = LocalDate.now().minusYears(1L).format(formatter);
        }
        LocalDate min = LocalDate.parse(minDate, formatter);
        LocalDate max = LocalDate.parse(maxDate, formatter);
        return new LocalDate[]{min,max};
    }

    public SaleMinDTO findById(Long id) {
        Optional<Sale> result = repository.findById(id);
        return new SaleMinDTO(result.get());
    }

    public Page<SaleWithSellerDTO> reportSaleWithSeller(String minDate, String maxDate, String nameSeller, Pageable pageable) {
        LocalDate[] dates = stringToLocalDate(minDate, maxDate);
        return repository.reportSaleWithSeller(dates[0], dates[1], nameSeller, pageable);
    }

    public List<SellerWithTotalSalesDTO> summarySellerWithTotalSales(String minDate, String maxDate) {
        LocalDate[] dates = stringToLocalDate(minDate, maxDate);
        return repository.summarySellerWithTotalSales(dates[0], dates[1]);
    }
}
