package com.knausrr.Knausrr.admin.service;

import com.knausrr.Knausrr.entities.Local_Product;
import com.knausrr.Knausrr.entities.Store;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CsvConverterService {

    /**
     * reads Products from given CSV File
     *
     * @param file file
     * @return List of Local_Product
     */
    List<Local_Product> readProductsFromCsvFile(MultipartFile file);

    /**
     * reads Store from CSV File
     *
     * @param file file
     * @return Store
     */
    Store readStoreFromCsvFile(MultipartFile file);
}
