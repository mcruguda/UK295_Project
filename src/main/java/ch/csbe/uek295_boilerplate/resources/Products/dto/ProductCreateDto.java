package ch.csbe.uek295_boilerplate.resources.Products.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDto {
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
