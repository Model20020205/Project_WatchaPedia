package dao.test;

import dao.StoreLibraryDao;
import dto.StoreLibraryDto;

import java.util.List;

public class TestStoreLibraryDao {
    public static void main(String[] args) throws Exception {
        StoreLibraryDao dao = new StoreLibraryDao();

        // Test getStoreLibrary
        List<Integer> storeLibrary = dao.getStoreLibrary(1);
        if (!storeLibrary.isEmpty()) {
            System.out.println("getStoreLibrary success: " + storeLibrary);
        } else {
            System.out.println("getStoreLibrary failed");
        }

        // Test updateHeadTextLogo
        dao.updateHeadTextLogo(1, 2);
        System.out.println("updateHeadTextLogo success");

        // Test insertStoreLibrary
        StoreLibraryDto insertDto = new StoreLibraryDto(0, "이미지url", 1);
        dao.insertStoreLibrary(insertDto);
        System.out.println("insertStoreLibrary success");
    }
}