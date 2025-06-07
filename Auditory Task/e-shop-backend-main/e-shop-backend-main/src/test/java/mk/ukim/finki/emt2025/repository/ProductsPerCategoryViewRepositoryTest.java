package mk.ukim.finki.emt2025.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsPerCategoryViewRepositoryTest {

    @Autowired
    private ProductsPerCategoryViewRepository productsPerCategoryViewRepository;

    @Test
    public void testFindAll() {
        Assert.assertEquals(3, this.productsPerCategoryViewRepository.findByCategoryId(1L).getNumProducts().intValue());
    }
}
