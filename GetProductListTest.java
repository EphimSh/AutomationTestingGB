package lesson6;


import db.model.ProductsExample;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;

import org.hamcrest.comparator.ComparatorMatcherBuilder;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class GetProductListTest extends AbstractTest {


    @SneakyThrows
    @Test
    void getProductList(){
        Response<ResponseBody> response = productService.getProducts().execute();
        assertThat(response.body().string(), containsString("Electronic"));

        db.model.ProductsExample products = new ProductsExample();
        products.createCriteria().andIdGreaterThan(0L);
        List<db.model.Products> list = productsMapper.selectByExample(products);
        assertThat(list.size(), ComparatorMatcherBuilder.<Integer>usingNaturalOrdering().greaterThan(1));


    }
}
