package lesson6;

import HomeWorkFive.api.CategoryService;
import HomeWorkFive.api.ProductService;
import HomeWorkFive.utils.RetrofitUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.io.InputStream;

public class AbstractTest {
    static ProductService productService;
    static SqlSession session = null;
    static CategoryService categoryService;

    static db.dao.CategoriesMapper categoriesMapper;
    static db.model.CategoriesExample example;

    static db.dao.ProductsMapper productsMapper;
    static db.model.ProductsExample productsExample;

    @BeforeAll
    static void beforeAll() throws IOException {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
        categoryService = RetrofitUtils.getRetrofit().create(CategoryService.class);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        session = sqlSessionFactory.openSession();

        categoriesMapper = session.getMapper(db.dao.CategoriesMapper.class);
        productsMapper = session.getMapper(db.dao.ProductsMapper.class);
        example = new db.model.CategoriesExample();
    }
}
