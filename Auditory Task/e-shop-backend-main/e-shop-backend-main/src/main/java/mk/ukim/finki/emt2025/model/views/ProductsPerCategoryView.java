package mk.ukim.finki.emt2025.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
@Entity
@Subselect("SELECT * FROM public.products_per_category")
@Immutable
public class ProductsPerCategoryView {

    @Id
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "num_products")
    private Integer numProducts;
}

