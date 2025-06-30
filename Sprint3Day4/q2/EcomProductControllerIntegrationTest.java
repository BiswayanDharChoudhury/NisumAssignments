package com.nisum.NisumAssignments;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EcomProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateAndGetProduct() throws Exception {
        EcomProductEntity product = new EcomProductEntity();
        product.setName("Test Product");
        product.setPrice(BigDecimal.valueOf(29.99));
        product.setCategory("Test");

        mockMvc.perform(post("/api/ecom-products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Test Product"));

        mockMvc.perform(get("/api/ecom-products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Test Product"));
    }

    @Test
    void testUpdateProduct() throws Exception {
        EcomProductEntity product = new EcomProductEntity();
        product.setName("Old Name");
        product.setPrice(BigDecimal.valueOf(19.99));
        product.setCategory("Test");

        String response = mockMvc.perform(post("/api/ecom-products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andReturn().getResponse().getContentAsString();

        EcomProductEntity created = objectMapper.readValue(response, EcomProductEntity.class);

        created.setName("Updated Name");
        mockMvc.perform(put("/api/ecom-products/" + created.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(created)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Name"));
    }

    @Test
    void testDeleteProduct() throws Exception {
        EcomProductEntity product = new EcomProductEntity();
        product.setName("To Delete");
        product.setPrice(BigDecimal.valueOf(9.99));

        String response = mockMvc.perform(post("/api/ecom-products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andReturn().getResponse().getContentAsString();

        EcomProductEntity created = objectMapper.readValue(response, EcomProductEntity.class);

        mockMvc.perform(delete("/api/ecom-products/" + created.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/api/ecom-products/" + created.getId()))
                .andExpect(status().isNotFound());
    }

    @Test
    void testSearchEndpoint() throws Exception {
        EcomProductEntity p1 = new EcomProductEntity();
        p1.setName("Premium Laptop");
        p1.setCategory("Electronics");
        p1.setPrice(BigDecimal.valueOf(1299.99));
     
        mockMvc.perform(get("/api/ecom-products/search/custom")
                .param("keyword", "premium")
                .param("category", "Electronics"))
                .andExpect(status().isOk())
               
    }
}
