package ch.csbe.uek295_boilerplate.resources.Products.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsDto {
    private Integer id;
    private String sku;
    private String name;
    private String description;
    private float price;
    private Integer stock;
    private Long categoryId;
}
