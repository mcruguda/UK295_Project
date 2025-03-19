package ch.csbe.uek295_boilerplate.resources.Products;

import ch.csbe.uek295_boilerplate.resources.Products.dto.ProductCreateDto;
import ch.csbe.uek295_boilerplate.resources.Products.dto.ProductDetailsDto;
import ch.csbe.uek295_boilerplate.resources.Products.dto.ProductUpdateDto;

import java.util.List;

public interface ProductService {
    ProductDetailsDto create(ProductCreateDto product);
    ProductDetailsDto getById(Long id);
    List<ProductDetailsDto> getAll();
    ProductDetailsDto update(Long id, ProductUpdateDto product);
    void delete(Long id);
}
