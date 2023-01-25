package lesson6;

import HomeWorkFive.dto.Product;
import db.model.Products;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
public class GetProductTest extends AbstractTest {




    @SneakyThrows
    @Test
    void getProductById(){
        Response<Product> response = productService.getProductById(1).execute();
        assertThat(response.isSuccessful(), is(true));

        db.model.Products product = new Products();
        product = productsMapper.selectByPrimaryKey(1L);
        assertThat(product.getId(), equalTo(1L));
    }

}
