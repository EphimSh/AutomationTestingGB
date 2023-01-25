package lesson6;

import HomeWorkFive.dto.GetCategoryResponse;
import db.model.Categories;
import db.model.CategoriesExample;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class GetCategoryTest extends AbstractTest {


    @SneakyThrows
    @Test
    void getCategoryByIdPositiveTest() {
        Response<GetCategoryResponse> response = categoryService.getCategory(2).execute();
        assertThat(response.isSuccessful(), is(true));
        assertThat(response.body().getId(), equalTo(2));
        assertThat(response.body().getTitle(), equalTo("Electronic"));

        db.model.CategoriesExample categories = new CategoriesExample();
        List<Categories> electronic =  categoriesMapper.selectByExample(categories);
        System.out.println(electronic);

        assertThat(electronic.get(1).getTitle(), containsString("Electronic"));
        assertThat(electronic.get(0).getTitle(), containsString("Food"));
        assertThat(electronic.get(2).getTitle(), containsString("test"));

    }
}
