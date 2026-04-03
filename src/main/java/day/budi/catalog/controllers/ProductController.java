package day.budi.catalog.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import day.budi.catalog.dto.ApiResponse;
import day.budi.catalog.dto.ListProductsDto;
import day.budi.catalog.dto.PageResponse;
import day.budi.catalog.dto.ProductDetailResponse;
import day.budi.catalog.dto.ProductResponse;
import day.budi.catalog.services.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // @GetMapping
    // public ResponseEntity<PageResponse<ProductResponse>> listProducts(
    // @RequestParam(defaultValue = "0") int page,
    // @RequestParam(defaultValue = "10") int size,
    // @RequestParam(defaultValue = "newest") String sort,
    // @RequestParam(required = false) String search) {

    // return ResponseEntity.ok(
    // PageResponse.from(productService.listProducts(search, sort, page, size)));
    // }

    @GetMapping
    public ResponseEntity<PageResponse<ProductResponse>> listProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "newest") String sort,
            @RequestParam(required = false) String search) {

        var dto = ListProductsDto.builder()
                .page(page)
                .size(size)
                .sort(sort)
                .search(search)
                .build();

        var result = productService.listProducts(dto);

        return ResponseEntity.ok(PageResponse.from(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDetailResponse>> getProduct(@PathVariable UUID id) {
        return productService.getProduct(id)
                .map(ApiResponse::of)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.of(null)));
    }
}
