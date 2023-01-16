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
public class PostProductTest {

    static ProductService productService;

    @BeforeAll
    static void beforeAll(){
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }


    @SneakyThrows
    @Test
    void createNewProduct(){
        Response<Product> createdProduct = productService
                .createProduct(new Product(null, "Test product", 6969, "Food")).execute();
        assertThat(createdProduct.isSuccessful(), is(true));
        assertThat(createdProduct.body().getTitle(), containsString("Test"));

        Response<ResponseBody> deleteTempProduct = productService.deleteProduct(createdProduct.body().getId()).execute();
        assertThat(deleteTempProduct.isSuccessful(), is(true));
    }
}
