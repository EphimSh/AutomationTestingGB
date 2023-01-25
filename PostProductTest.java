package lesson6;
import HomeWorkFive.api.ProductService;
import HomeWorkFive.dto.Product;

import db.model.ProductsExample;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
public class PostProductTest extends AbstractTest {


    @SneakyThrows
    @Test
    void createNewProduct(){
        Response<Product> createdProduct = productService
                .createProduct(new Product(null, "Kali Kush", 6969, "Food")).execute();
        assertThat(createdProduct.isSuccessful(), is(true));
        db.model.ProductsExample product = new ProductsExample();
        product.createCriteria().andTitleLike("Kali Kush");
        List<db.model.Products> list = productsMapper.selectByExample(product);
        assertThat(list.get(0).getTitle(), containsString("Kali Kush"));

        Response<ResponseBody> deleteTempProduct = productService.deleteProduct(createdProduct.body().getId()).execute();
        assertThat(deleteTempProduct.isSuccessful(), is(true));
    }
}
