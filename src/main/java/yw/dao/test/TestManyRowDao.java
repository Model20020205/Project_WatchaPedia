package yw.dao.test;

import java.util.List;

import dao.YWManyRowDao;
import dto.YWManyRowDto;
import dto.YWEachRowDto;

public class TestManyRowDao {
    public static void main(String[] args) throws Exception {
        YWManyRowDao dao = new YWManyRowDao();
        
        // Test getManyRow
        YWManyRowDto manyRow = dao.getManyRow(1);
        if (manyRow != null) {
            System.out.println("getManyRow success: " + manyRow);
        } else {
            System.out.println("getManyRow failed");
        }

        // Test updateManyRow
//        ManyRowDto updateDto = new ManyRowDto(0, 1, 2, 0, 1, 0, 2, 1);
//        updateDto.setMrIdx(1);
//        dao.updateManyRow(updateDto);
//        System.out.println("updateManyRow success");

        // Test updateTemplateSunseoColor
//        dao.updateTemplateSunseoColor(1, 1);
//        System.out.println("updateTemplateSunseoColor success");

        // Test insertManyRow
//        ManyRowDto insertDto = new ManyRowDto(0, 1, 2, 0, 1, 0, 2, 1);
//        dao.insertManyRow(insertDto);
//        System.out.println("insertManyRow success");

        // Test insertTemplateSunseo
//        dao.insertTemplateSunseo(1, 1, 1);
//        System.out.println("insertTemplateSunseo success");

        // Test getEachRows
        List<YWEachRowDto> eachRows = dao.getEachRows(1, 1);
        if (eachRows != null && !eachRows.isEmpty()) {
            System.out.println("getEachRows success: " + eachRows);
        } else {
            System.out.println("getEachRows failed");
        }
        

        // Test insertEachRow
//        EachRowDto eachRowDto = new EachRowDto(1, 1, 1, "제목", "제목링크", "텍스트", "버튼제목", "버튼링크");
//        dao.insertEachRow(eachRowDto);
//        System.out.println("insertEachRow success");

        // Test updateEachRow
//        EachRowDto updateEachRowDto = new EachRowDto(1, 1, 1, "제목", "제목링크", "텍스트", "버튼제목", "버튼링크");
//        dao.updateEachRow(updateEachRowDto);
//        System.out.println("updateEachRow success");
    }
}