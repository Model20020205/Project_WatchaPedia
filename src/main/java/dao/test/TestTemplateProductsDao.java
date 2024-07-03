package dao.test;

import dao.TemplateProductsDao;
import dto.ProductDetailsDto;
import dto.ReducerowDto;
import dto.TemplateProductsDto;

import java.util.List;

public class TestTemplateProductsDao {

    private TemplateProductsDao dao = new TemplateProductsDao();

    public void testGetLatestProductName() throws Exception {
        String pdName = dao.getLatestProductName(1); // Assuming storeIdx is 1
        if (pdName != null) {
            System.out.println("Latest product name: " + pdName);
        } else {
            System.out.println("No product name found.");
        }
    }

    public void testGetTemplateProducts() throws Exception {
        TemplateProductsDto dto = dao.getTemplateProducts(1, 1); // Assuming tpIdx is 1 and storeIdx is 1
        if (dto != null) {
            System.out.println("Template products: " + dto);
        } else {
            System.out.println("No template products found.");
        }
    }

    public void testGetProductNames() throws Exception {
        List<String> productNames = dao.getProductNames(1); // Assuming storeIdx is 1
        if (productNames != null && !productNames.isEmpty()) {
            System.out.println("Product names: " + productNames);
        } else {
            System.out.println("No product names found.");
        }
    }

    public void testUpdateTemplateProducts() throws Exception {
        TemplateProductsDto dto = new TemplateProductsDto();
        dto.setTpIdx(1);
        dto.setColorIdx(2);
        dto.setPdIdx(3);
        dto.setWidth(1);
        dto.setLayout(1);
        dto.setLocation(1);
        dto.setZoom(1);
        dto.setTionop(1);
        dto.setButton(1);

        dao.updateTemplateProducts(dto);
        System.out.println("Template products updated.");
    }

    public void testInsertReducerow() throws Exception {
        dao.insertReducerow(1, "New Title", "New Title Link", "New Row Content", "New Row Content Link");
        System.out.println("Reducerow inserted.");
    }

    public void testUpdateReducerow() throws Exception {
        dao.updateReducerow(1, "Updated Title", "Updated Title Link", "Updated Row Content", "Updated Row Content Link");
        System.out.println("Reducerow updated.");
    }

    public void testGetProductDetails() throws Exception {
        ProductDetailsDto dto = dao.getProductDetails(1, 1); // Assuming tpIdx is 1 and storeIdx is 1
        if (dto != null) {
            System.out.println("Product details: " + dto);
        } else {
            System.out.println("No product details found.");
        }
    }

    public void testGetReducerow() throws Exception {
        ReducerowDto dto = dao.getReducerow(1); // Assuming tpIdx is 1
        if (dto != null) {
            System.out.println("Reducerow: " + dto);
        } else {
            System.out.println("No reducerow found.");
        }
    }

    public void testGetTionop() throws Exception {
        int tionop = dao.getTionop(1, 1); // Assuming tpIdx is 1 and storeIdx is 1
        if (tionop >= 0) {
            System.out.println("Tionop: " + tionop);
        } else {
            System.out.println("No tionop found.");
        }
    }

    public void testGetButton() throws Exception {
        int button = dao.getButton(1, 1); // Assuming tpIdx is 1 and storeIdx is 1
        if (button >= 0) {
            System.out.println("Button: " + button);
        } else {
            System.out.println("No button found.");
        }
    }

    public void testUpdateTionop() throws Exception {
        dao.updateTionop(1, 1); // Assuming tpIdx is 1 and setting tionop to 1
        System.out.println("Tionop updated.");
    }

    public void testUpdateButton() throws Exception {
        dao.updateButton(1, 1); // Assuming tpIdx is 1 and setting button to 1
        System.out.println("Button updated.");
    }

    public static void main(String[] args) {
    	TestTemplateProductsDao test = new TestTemplateProductsDao();
        try {
            test.testGetLatestProductName();
            test.testGetTemplateProducts();
            test.testGetProductNames();
            test.testUpdateTemplateProducts();
            test.testInsertReducerow();
            test.testUpdateReducerow();
            test.testGetProductDetails();
            test.testGetReducerow();
            test.testGetTionop();
            test.testGetButton();
            test.testUpdateTionop();
            test.testUpdateButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
