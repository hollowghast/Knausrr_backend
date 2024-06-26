package com.knausrr.Knausrr.admin;

import com.knausrr.Knausrr.admin.service.CsvConverterService;
import com.knausrr.Knausrr.admin.service.impl.DefaultCsvConverterService;
import com.knausrr.Knausrr.entities.Store;
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
}
