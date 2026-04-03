package day.budi.catalog.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import day.budi.catalog.dto.ListProductsDto;
import day.budi.catalog.dto.ProductDetailResponse;
import day.budi.catalog.dto.ProductResponse;
import day.budi.catalog.entities.Product;
import day.budi.catalog.repositories.ProductRepository;
import day.budi.catalog.repositories.specification.ProductSpec;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // public Page<ProductResponse> listProducts(String search, String sort, int
    // page, int size) {
    // Sort sorting = switch (sort) {
    // case "lowest_price" -> Sort.by(Sort.Direction.ASC, "price");
    // default -> Sort.by(Sort.Direction.DESC, "createdAt");
    // };

    // Pageable pageable = PageRequest.of(page, size, sorting);

    // if (search == null || search.isBlank()) {
    // return productRepository.findAll(pageable).map(ProductResponse::from);
    // }
    // return productRepository.search(search, pageable).map(ProductResponse::from);
    // }

    public Page<ProductResponse> listProducts(ListProductsDto dto) {
        Specification<Product> spec = (root, query, cb) -> cb.conjunction();

        System.out.println("Searching for: " + dto.getSearch());

        if (dto.getSearch() != null && !dto.getSearch().isBlank()) {
            spec = spec.and(ProductSpec.hasNameLike(dto.getSearch()));
        }

        Sort sorting = switch (dto.getSort()) {
            case "lowest_price" -> Sort.by(Sort.Direction.ASC, "price");
            default -> Sort.by(Sort.Direction.DESC, "createdAt");
        };

        Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize(), sorting);
        return productRepository.findAll(spec, pageable).map(ProductResponse::from);
    }

    public Optional<ProductDetailResponse> getProduct(UUID id) {
        return productRepository.findByUuid(id).map(ProductDetailResponse::from);
    }
}
