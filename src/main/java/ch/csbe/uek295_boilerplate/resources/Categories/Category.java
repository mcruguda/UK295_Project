package ch.csbe.uek295_boilerplate.resources.Categories;

import ch.csbe.uek295_boilerplate.resources.Products.Product;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "tinyint")
    private String active;

    @Column(columnDefinition = "varchar(255)")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> productsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }
}