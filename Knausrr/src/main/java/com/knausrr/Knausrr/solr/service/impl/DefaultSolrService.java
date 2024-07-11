package com.knausrr.Knausrr.solr.service.impl;

import com.knausrr.Knausrr.entities.Base_Product;
import com.knausrr.Knausrr.entities.Local_Product;
import com.knausrr.Knausrr.solr.service.SolrService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DefaultSolrService implements SolrService {

    public static final String PRODUCTS_COLLECTION = "products";

    @Autowired
    private SolrClient solrClient;

    @Override
    public void indexProduct(Local_Product product) throws SolrServerException, IOException {
        SolrInputDocument solrInputDocument = new SolrInputDocument();
        solrInputDocument.addField("id", product.getId());
        solrInputDocument.addField("name", product.getBase_product().getName());
        solrInputDocument.addField("brand", product.getBase_product().getBrand().getName());

        final UpdateResponse updateResponse = solrClient.add(PRODUCTS_COLLECTION, solrInputDocument);
        solrClient.commit(PRODUCTS_COLLECTION);
    }

    @Override
    public void indexBaseProduct(Base_Product product) throws SolrServerException, IOException {
        SolrInputDocument solrInputDocument = new SolrInputDocument();
        solrInputDocument.addField("id", product.getId());
        solrInputDocument.addField("name", product.getName());
        solrInputDocument.addField("brand", product.getBrand().getName());
        solrInputDocument.addField("serialNumber", product.getSerial_number());

        final UpdateResponse updateResponse = solrClient.add(PRODUCTS_COLLECTION, solrInputDocument);
        solrClient.commit(PRODUCTS_COLLECTION);
    }

    @Override
    public Base_Product searchProductBySearchTerm(String searchTerm) throws SolrServerException, IOException {
        final SolrQuery solrQuery = new SolrQuery("*:*");
        final QueryResponse response = solrClient.query(solrQuery);
        final SolrDocumentList results = response.getResults();
        return null;
    }

}
