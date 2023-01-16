package HomeWorkFiveTest;

import HomeWorkFive.api.ProductService;
import HomeWorkFive.dto.Product;
import HomeWorkFive.utils.RetrofitUtils;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class DeleteProductTest {

    static ProductService productService;

    @BeforeAll
    static void beforeAll(){
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @SneakyThrows
    @Test
    void deleteProductTest(){
        Response<Product> createTempProduct = productService
                .createProduct(new Product(null, "Ak-47", 1800, "Electronic")).execute();
        assertThat(createTempProduct.isSuccessful(), is(true));

        Response<ResponseBody> deleteTempProduct = productService
                .deleteProduct(createTempProduct.body().getId()).execute();
        assertThat(deleteTempProduct.isSuccessful(), is(true));
    }
}
