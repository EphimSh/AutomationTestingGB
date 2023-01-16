package HomeWorkFiveTest;

import HomeWorkFive.api.ProductService;
import HomeWorkFive.dto.Product;
import HomeWorkFive.utils.RetrofitUtils;
import okhttp3.ResponseBody;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
public class PutProductTest {
    static ProductService productService;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }


    @SneakyThrows
    @Test
    void modifyProductTest() {
        //Creating new temporary product for modify product test
        Response<Product> createdTempProduct = productService
                .createProduct(new Product(null, "Purple Kush", 2000, "Food")).execute();
        assertThat(createdTempProduct.body().getTitle(), is("Purple Kush"));
        //Modifying temporary product
        Response<Product> modifiedTempProduct = productService
                .modifyProduct(new Product(createdTempProduct.body().getId(), "Purple Kali Kush", 2000, "Food")).execute();
        assertThat(modifiedTempProduct.body().getTitle(), containsString("Kali"));
        //Deleting testing object
        Response<ResponseBody> deletedProduct = productService
                .deleteProduct(modifiedTempProduct.body().getId()).execute();
        assertThat(deletedProduct.isSuccessful(), is(true));
    }
}
