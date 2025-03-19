package ch.csbe.uek295_boilerplate.resources.Products;

import ch.csbe.uek295_boilerplate.resources.Products.dto.ProductCreateDto;
import ch.csbe.uek295_boilerplate.resources.Products.dto.ProductDetailsDto;
import ch.csbe.uek295_boilerplate.resources.Products.dto.ProductUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"products"})
public class ProductController {
    public ProductController() {
    }

    @Autowired
    ProductService productService;

    @PostMapping
    public ProductDetailsDto save(@RequestBody ProductCreateDto product) {
        return productService.create(product);
    }

    @GetMapping("{id}")
    public ProductDetailsDto findById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping
    public List<ProductDetailsDto> findAll() {
        return productService.getAll();
    }

    @PutMapping("{id}")
    public ProductDetailsDto update(@PathVariable Long id, @RequestBody ProductUpdateDto product) {
        return productService.update(id, product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

}
