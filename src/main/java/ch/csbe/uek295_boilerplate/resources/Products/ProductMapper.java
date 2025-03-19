package ch.csbe.uek295_boilerplate.resources.Products;

import ch.csbe.uek295_boilerplate.resources.Products.dto.ProductCreateDto;
import ch.csbe.uek295_boilerplate.resources.Products.dto.ProductDetailsDto;
import ch.csbe.uek295_boilerplate.resources.Products.dto.ProductUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper (
    componentModel = "spring"
        //uses = CategoryMapper.class
)
public abstract class ProductMapper {
    /*@Autowired
    CategoryRepo categoryRepo;*/

    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "stock", target = "stock")
    //@Mapping(source = "categoryId", target = "category", ignore = true)
    public abstract Product fromCreateDto(ProductCreateDto dto);

    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "stock", target = "stock")
    //@Mapping(source = "categoryId", target = "category", ignore = true)
    public abstract Product fromUpdateDto(ProductUpdateDto dto);

    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "stock", target = "stock")
    //@Mapping(source = "categoryId", target = "category", ignore = true)
    public abstract ProductDetailsDto toDetailsDto(Product product);
}
