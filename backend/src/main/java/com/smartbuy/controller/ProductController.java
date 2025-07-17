package com.smartbuy.controller;

import com.smartbuy.model.Product;
import com.smartbuy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//package com.smartbuy.controller;
//
//import com.smartbuy.model.Product;
//import com.smartbuy.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/products")
//@CrossOrigin(origins = "http://localhost:3000")
//public class ProductController {
//    @Autowired
//    private ProductService productService;
//
//    private final String uploadir="uploads/";
//
//    @GetMapping
//    public List<Product> getAllProducts(){
//        return productService.getAllProducts();
//    }
//    @PostMapping
//    public ResponseEntity<Product> uploadproduct(
//            @RequestParam("name") String name,
//            @RequestParam("description") String description,
//            @RequestParam("price") double price,
//            @RequestParam("stock") int stock,
//            @RequestParam("category") String category,
//            @RequestParam("image")MultipartFile imageFile
//            ){
//        try{
//            File dir = new File(uploadir);
//            if(!dir.exists()) dir.mkdir();
//            String filename = UUID.randomUUID()+"_"+imageFile.getOriginalFilename();
//            File dest =new File(uploadir+filename);
//            imageFile.transferTo(dest);
//            Product product = new Product();
//            product.setName(name);
//            product.setDescrription(description);
//            product.setPrice(price);
//            product.setStock(stock);
//            product.setCategory(category);
//            product.setImageUrl("/image/"+filename);
//
//            Product saved =productService.saveProduct(product);
//            return new ResponseEntity<>(saved, HttpStatus.CREATED);
//        }catch (Exception e){
//            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;
    private final String uploadDir = System.getProperty("user.dir") + "/uploads/";

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping(value = "/{id}")
        public Product getById(@PathVariable Long id){
            return productService.getProductById(id);
        }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Product> uploadProduct(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam("stock") int stock,
            @RequestParam("category") String category,
            @RequestParam("image") MultipartFile imageFile
    ) {
        try {
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String filename = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
            File dest = new File(uploadDir + filename);
            imageFile.transferTo(dest);

            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setStock(stock);
            product.setCategory(category);
            product.setImageUrl("/uploads/" + filename); // Update this if using static resource mapping

            Product saved = productService.saveProduct(product);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<Product> product = Optional.ofNullable(productService.getProductById(id));
        if (product.isPresent()) {
            productService.deleteProduct(id);
            return ResponseEntity.ok("product deleted");
        }
        return ResponseEntity.ok("product deleted");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updated) {
        Product product = productService.update(id, updated);
        return ResponseEntity.ok(product);
    }
}
