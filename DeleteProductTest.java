package lesson6;

import HomeWorkFive.dto.Product;
import db.model.Products;
import db.model.ProductsExample;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;
import retrofit2.Response;


import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
public class DeleteProductTest extends AbstractTest {



    @SneakyThrows
    @Test
    void deleteProductTest() {
        Response<Product> tempProduct = productService
                .createProduct(new Product(null, "Ak-47", 1800, "Electronic")).execute();
        db.model.ProductsExample product = new ProductsExample();
        product.createCriteria().andTitleLike("Ak-47");
        List<Products> list = productsMapper.selectByExample(product);
        assertThat(list.get(0).getTitle(), containsString("Ak-47"));

        Response<ResponseBody> deleteTempProduct = productService
                .deleteProduct(tempProduct.body().getId()).execute();
        assertThat(deleteTempProduct.isSuccessful(), is(true));

    }
}
