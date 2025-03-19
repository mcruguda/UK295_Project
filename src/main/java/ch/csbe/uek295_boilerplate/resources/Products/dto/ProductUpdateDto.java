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
public class ProductUpdateDto {
    @NotNull(message = "ID cannot be empty!")
    private Integer id;
    @NotNull(message = "Sku cannot be empty!")
    private String sku;
    @NotNull(message = "Name cannot be empty!")
    private String name;
    private String description;
    @NotNull(message = "Price cannot be empty!")
    private float price;
    private Integer stock;
    private Long categoryId;
}
