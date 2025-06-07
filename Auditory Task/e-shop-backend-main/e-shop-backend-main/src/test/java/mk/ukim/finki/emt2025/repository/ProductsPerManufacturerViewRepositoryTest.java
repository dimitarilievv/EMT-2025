package mk.ukim.finki.emt2025.repository;

import mk.ukim.finki.emt2025.model.domain.Product;
import mk.ukim.finki.emt2025.model.views.ProductsPerManufacturerView;
import mk.ukim.finki.emt2025.service.domain.CategoryService;
import mk.ukim.finki.emt2025.service.domain.ManufacturerService;
import mk.ukim.finki.emt2025.service.domain.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsPerManufacturerViewRepositoryTest {

    @Autowired
    private ProductsPerManufacturerViewRepository productsPerManufacturerViewRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ProductService productService;

    //todo: improve testing
    @Test
    public void testCreateNewProduct() {
        List<ProductsPerManufacturerView> list1 = this.productsPerManufacturerViewRepository.findAll();

        Product product = new Product();
        product.setName("Ski Jacket 557");
        product.setManufacturer(this.manufacturerService.findAll().get(2));
        product.setCategory(this.categoryService.findAll().get(1));
        this.productService.save(product);

        List<ProductsPerManufacturerView> list2 = this.productsPerManufacturerViewRepository.findAll();
    }
}
