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

public class GetProductListTest {
    static ProductService productService;

    @BeforeAll
    static void beforeAll(){
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @SneakyThrows
    @Test
    void getProductList(){
        Response<ResponseBody> response = productService.getProducts().execute();
        assertThat(response.body().string(), containsString("Electronic"));
    }
}
