package com.pablinchapin.laliz;

import com.pablinchapin.laliz.model.Category;
import com.pablinchapin.laliz.model.Product;
import com.pablinchapin.laliz.service.CategoryService;
import com.pablinchapin.laliz.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LalizApplication {

	public static void main(String[] args) {
		SpringApplication.run(LalizApplication.class, args);
	}
        
        
        /*
        
        public Category(Long id, String name, String pictureUrl, boolean active) {
            this.id = id;
            this.name = name;
            this.pictureUrl = pictureUrl;
            this.active = active;
        }
        
        
        public Product(Long id, String name, String description, Double price, String pictureUrl, Category category) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
            this.pictureUrl = pictureUrl;
            this.category = category;
        }
        
        */
        
        @Bean
        CommandLineRunner runnerCategory(CategoryService categoryService){
        
            return args -> {
                
                categoryService.save(new Category(1L, "Fruta", "http://placehold.it/200x200", true));
                categoryService.save(new Category(2L, "Verdura", "http://placehold.it/200x200", true));
                categoryService.save(new Category(3L, "Despensa", "http://placehold.it/200x200", true));
                categoryService.save(new Category(4L, "Bodega", "http://placehold.it/200x200", true));
            
            };
        }
        
        
        @Bean
        CommandLineRunner runnerProduct(ProductService productService, CategoryService categoryService){
            
            return args -> {
                
                Category fruit = categoryService.getCategory(1L);
            
                //Category fruit = new Category(1L, "Fruta", "http://placehold.it/200x200", true);
                
                productService.save(new Product(1L, "Papaya", "Vaya vaya la papaya", 15.00, "http://placehold.it/200x200", fruit));
                productService.save(new Product(2L, "Manzana", "Manzana roja", 15.00, "http://placehold.it/200x200", fruit));
                productService.save(new Product(3L, "Piña", "Piña dulce", 15.00, "http://placehold.it/200x200", fruit));
                productService.save(new Product(4L, "Sandia", "Sandia jugosa", 15.00, "http://placehold.it/200x200", fruit));
            };
        
        }

}
