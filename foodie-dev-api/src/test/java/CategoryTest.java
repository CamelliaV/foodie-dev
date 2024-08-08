import com.learn.Application;
import com.learn.resp.CategoryResp;
import com.learn.service.CategoryService;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class CategoryTest {
    @Autowired
    private CategoryService categoryService;

    private void printCategory(Category category, int level) {
        String indentation = IntStream.range(0, level)
                                      .mapToObj(i -> " ")
                                      .collect(Collectors.joining());
        System.out.println(indentation + category.getName());
        category.getChildren()
                .forEach(subCategory -> printCategory(subCategory, level + 1));
    }

    private void printCategory(CategoryResp category, int level) {
        String indentation = IntStream.range(0, level)
                                      .mapToObj(i -> " ")
                                      .collect(Collectors.joining());
        System.out.println(indentation + category.getName());
        category.getChildren()
                .forEach(subCategory -> printCategory(subCategory, level + 1));
    }

    @Test
    public void categoryAssemblyTest() {
        List<Category> categories = getCategories();

        // only top level
        categories
                .stream()
                .filter(category -> category
                        .getFatherId()
                        .equals(0))
                .peek(category -> category.setChildren(lsChildren(category, categories)))
                .collect(Collectors.toList())
                .forEach(category -> printCategory(category, 0));
    }

    private List<Category> lsChildren(Category c, List<Category> all) {
        return all.stream()
                  .filter(category -> category
                          .getFatherId()
                          .equals(c.getId()))
                  .peek(category -> category.setChildren(lsChildren(category, all)))
                  .collect(Collectors.toList());
    }

    private List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();

        categories.add(new Category(1, "Electronics", 0, 1));
        categories.add(new Category(2, "Computers", 1, 2));
        categories.add(new Category(3, "Laptops", 2, 3));
        categories.add(new Category(4, "Desktops", 2, 3));
        categories.add(new Category(5, "Mobile Phones", 1, 2));
        categories.add(new Category(6, "Smartphones", 5, 3));
        categories.add(new Category(7, "Feature Phones", 5, 3));
        categories.add(new Category(8, "Appliances", 0, 1));
        categories.add(new Category(9, "Kitchen", 8, 2));
        categories.add(new Category(10, "Refrigerators", 9, 3));
        categories.add(new Category(11, "Microwaves", 9, 3));

        return categories;
    }

    @Test
    public void categoryConvertTest() {

        List<com.learn.entity.Category> categories = categoryService.querySubCategories(1);
        List<CategoryResp> categoryRespList = categories.stream()
                                                        .map(this::convert)
                                                        .collect(Collectors.toList());

        categoryRespList.forEach(categoryResp -> printCategory(categoryResp, 0));
    }

    private CategoryResp convert(com.learn.entity.Category category) {
        List<CategoryResp> children = category.getChildren()
                                              .stream()
                                              .map(this::convert)
                                              .collect(Collectors.toList());
        CategoryResp categoryResp = convertCategoryToCategoryResp(category);
        categoryResp.setChildren(children);
        return categoryResp;
    }

    private CategoryResp convertCategoryToCategoryResp(com.learn.entity.Category category) {
        CategoryResp categoryResp = new CategoryResp();
        BeanUtils.copyProperties(category, categoryResp);
        return categoryResp;
    }

    @Data
    public static class Category {
        Integer id;
        String name;
        Integer fatherId;
        Integer type;
        List<Category> children;

        public Category(Integer id, String name, Integer fatherId, Integer type) {
            this.id = id;
            this.name = name;
            this.fatherId = fatherId;
            this.type = type;
        }
    }
}
