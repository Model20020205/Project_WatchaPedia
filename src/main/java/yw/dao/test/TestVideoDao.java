package yw.dao.test;

import dao.YWVideoDao;
import dto.YWVideoDto;

public class TestVideoDao {
    public static void main(String[] args) throws Exception {
        YWVideoDao dao = new YWVideoDao();

        // Test getVideo
        YWVideoDto video = dao.getVideo(1);
        if (video != null) {
            System.out.println("getVideo success: " + video);
        } else {
            System.out.println("getVideo failed");
        }

        // Test updateVideo
        YWVideoDto updateDto = new YWVideoDto(1, "동영상제목", "제목링크", 1, 0, 1, "동영상URL", 0);
        dao.updateVideo(updateDto);
        System.out.println("updateVideo success");

        // Test updateTemplateSunseoColor
        dao.updateTemplateSunseoColor(1, 2);
        System.out.println("updateTemplateSunseoColor success");

        // Test insertVideo
        YWVideoDto insertDto = new YWVideoDto(0, "동영상제목", "제목링크", 1, 0, 1, "동영상URL", 0);
        dao.insertVideo(insertDto);
        System.out.println("insertVideo success");

        // Test insertTemplateSunseo
        dao.insertTemplateSunseo(1, 1, 2);
        System.out.println("insertTemplateSunseo success");
    }
}