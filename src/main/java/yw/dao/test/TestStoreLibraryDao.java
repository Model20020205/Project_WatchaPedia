package yw.dao.test;

import dao.YWStoreLibraryDao;
import dto.YWStoreLibraryDto;

import java.util.List;

public class TestStoreLibraryDao {
    public static void main(String[] args) throws Exception {
        YWStoreLibraryDao dao = new YWStoreLibraryDao();

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
        YWStoreLibraryDto insertDto = new YWStoreLibraryDto(0, "이미지url", 1);
        dao.insertStoreLibrary(insertDto);
        System.out.println("insertStoreLibrary success");
    }
}