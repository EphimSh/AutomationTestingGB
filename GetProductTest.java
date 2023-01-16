package HomeWorkFiveTest;

import HomeWorkFive.api.CategoryService;
import HomeWorkFive.api.ProductService;

import HomeWorkFive.utils.RetrofitUtils;
import HomeWorkFive.dto.Product;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class GetProductTest {
    static ProductService productService;

    @BeforeAll
    static void beforeAll(){
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);

    }



    @SneakyThrows
    @Test
    void getProductById(){
        Response<Product> response = productService.getProductById(1).execute();
        assertThat(response.isSuccessful(), is(true));
        assertThat(response.body().getTitle(), is("Milk"));
    }

}
