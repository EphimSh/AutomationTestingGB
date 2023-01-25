package lesson6;
import HomeWorkFive.api.ProductService;
import HomeWorkFive.dto.Product;
import HomeWorkFive.utils.RetrofitUtils;
import db.model.ProductsExample;
import okhttp3.ResponseBody;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
public class PutProductTest extends AbstractTest {





    @SneakyThrows
    @Test
    void modifyProductTest() {
        //Creating new temporary product for modify product test
        Response<Product> createdTempProduct = productService
                .createProduct(new Product(null, "Purple Kush", 2000, "Food")).execute();
        db.model.ProductsExample product = new db.model.ProductsExample();
        product.createCriteria().andTitleLike("Purple Kush");
        List<db.model.Products> list = productsMapper.selectByExample(product);
        assertThat(list.get(0).getTitle(), containsString("Purple Kush"));

        //Modifying temporary product
        Response<Product> modifiedTempProduct = productService
                .modifyProduct(new Product(createdTempProduct.body().getId(), "Purple Kali Kish-mish", 6969, "Food")).execute();
        assertThat(modifiedTempProduct.body().getTitle(), containsString("Purple Kali Kish-mish"));

        db.model.ProductsExample modifiedProduct = new ProductsExample();
        modifiedProduct.createCriteria().andTitleLike("%Kish-mish%");
        List<db.model.Products> list2 = productsMapper.selectByExample(modifiedProduct);
        assertThat(list2.get(0).getTitle(), containsString("Purple Kali Kish-mish"));



        //Deleting testing object
        Response<ResponseBody> deletedProduct = productService
                .deleteProduct(modifiedTempProduct.body().getId()).execute();
        assertThat(deletedProduct.isSuccessful(), is(true));
    }
}
