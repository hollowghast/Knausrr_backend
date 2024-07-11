package com.knausrr.Knausrr.admin;

import com.knausrr.Knausrr.admin.service.CsvConverterService;
import com.knausrr.Knausrr.admin.service.impl.DefaultCsvConverterService;
import com.knausrr.Knausrr.entities.Base_Product;
import com.knausrr.Knausrr.entities.Store;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/admin") //security needed (oauth?)
public class AdminController {

    private final CsvConverterService converter;

    @Autowired
    private AdminService adminService;

    @Autowired
    public AdminController(DefaultCsvConverterService converter) {
        this.converter = converter;
    }

    @GetMapping("/test")
    public String insertTestData() {
        adminService.doStuff();
        return "";
    }

    @PostMapping(value = "/init", consumes = "multipart/form-data")
    public String addShop(@RequestParam("file") MultipartFile f) {
        //  try {
        Store s = converter.readStoreFromCsvFile(f);
        if (s == null) {
            return "Error";
        } else {
            return "shop?id=626756152"; //show shop
        }
        /* }catch (IOException ioe){
            ioe.printStackTrace(); //log
        }catch(Exception e){
            e.printStackTrace(); //log
        }
        return "somethingWentWrong";*/
    }

    @GetMapping(value = "/indexData")
    public void indexData(@RequestParam Long id) throws SolrServerException, IOException {
        adminService.indexProductForCode(id);
    }
}
