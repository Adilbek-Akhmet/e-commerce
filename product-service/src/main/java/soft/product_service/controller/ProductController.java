package soft.product_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soft.ecommercelib.dto.product.ProductDto;
import soft.ecommercelib.dto.product.ProductWithPort;
import soft.product_service.service.ProductService;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final Environment environment;

    @PostConstruct
    public void init() {
        productService.deleteAll();
        productService.save(ProductDto.builder()
                .name("phone")
                .description("A mobile phone is a wireless handheld device that allows users to make and receive calls. While the earliest generation of mobile phones could only make and receive calls, today's mobile phones do a lot more, accommodating web browsers, games, cameras, video players and navigational systems.")
                .price(BigDecimal.valueOf(2000))
                .quantity(555)
                .build());
    }

    @GetMapping
    public ProductWithPort findAll() {
        return ProductWithPort.builder()
                .productDtoList(productService.findAll())
                .port("Product service port is " + environment.getProperty("local.server.port"))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable String id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/{productName}")
    public ResponseEntity<Boolean> exists(@PathVariable String productName) {
        return ResponseEntity.ok(productService.exists(productName));
    }

    @GetMapping("/range")
    public List<ProductDto> findProductInRange(@RequestParam double min, @RequestParam double max) {
        return productService.findProductInRange(min, max);
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.save(productDto), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable String id, @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.update(productDto, id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        productService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}



