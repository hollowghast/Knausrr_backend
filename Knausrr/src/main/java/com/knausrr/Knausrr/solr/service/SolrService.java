package com.knausrr.Knausrr.solr.service;

import com.knausrr.Knausrr.entities.Base_Product;
import com.knausrr.Knausrr.entities.Local_Product;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

public interface SolrService {

    void indexProduct(Local_Product product) throws SolrServerException, IOException;

    void indexBaseProduct(Base_Product product) throws SolrServerException, IOException;

    Base_Product searchProductBySearchTerm(String searchTerm) throws SolrServerException, IOException;
}
