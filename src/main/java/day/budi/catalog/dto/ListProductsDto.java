package day.budi.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListProductsDto {
    private Integer page;
    private Integer size;
    private String sort;
    private String search;
}
