package ch.csbe.uek295_boilerplate.resources.Products;

import ch.csbe.uek295_boilerplate.resources.Products.dto.ProductCreateDto;
import ch.csbe.uek295_boilerplate.resources.Products.dto.ProductDetailsDto;
import ch.csbe.uek295_boilerplate.resources.Products.dto.ProductUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ProductMapperImpl productMapperImpl;

    @Autowired
    ProductMapper productMapper;


    public ProductDetailsDto create(ProductCreateDto productToSave) {
        return productMapper.toDetailsDto(this.productRepository.save(productMapper.fromCreateDto(productToSave)));
    }

    public ProductDetailsDto getById(Long id) {
        return productMapper.toDetailsDto(this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with the id " + id + " could not be found!")));
    }


    public List<ProductDetailsDto> getAll() {
        List<Product> products = this.productRepository.findAll();
        return products.stream().map(product -> productMapper.toDetailsDto(product)).toList();
    }

    public ProductDetailsDto update(Long id, ProductUpdateDto productToUpdateData) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product with the id " + id + " could not be found!"));
        Product productToUpdate = productMapper.fromUpdateDto(productToUpdateData);
        product.setActive(productToUpdate.getActive());
        product.setCategory(productToUpdate.getCategory());
        product.setDescription(productToUpdate.getDescription());
        product.setName(productToUpdate.getName());
        product.setImage(productToUpdate.getImage());
        product.setSku(productToUpdate.getSku());
        product.setStock(productToUpdate.getStock());
        return productMapper.toDetailsDto(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
