package yw.dao.test;

import dao.YWInquiryFormDao;
import dto.YWInquiryFormDto;

public class TestInquiryFormDao {
    public static void main(String[] args) throws Exception {
        YWInquiryFormDao dao = new YWInquiryFormDao();

        // Test getInquiryForm
        YWInquiryFormDto inquiryForm = dao.getInquiryForm(1);
        if (inquiryForm != null) {
            System.out.println("getInquiryForm success: " + inquiryForm);
        } else {
            System.out.println("getInquiryForm failed");
        }

        // Test updateInquiryForm
        YWInquiryFormDto updateDto = new YWInquiryFormDto(1, "제목", "제목링크", 1, 0);
        dao.updateInquiryForm(updateDto);
        System.out.println("updateInquiryForm success");

        // Test updateTemplateSunseoColor
        dao.updateTemplateSunseoColor(1, 2);
        System.out.println("updateTemplateSunseoColor success");

        // Test insertInquiryForm
        YWInquiryFormDto insertDto = new YWInquiryFormDto(0, "제목", "제목링크", 1, 0);
        dao.insertInquiryForm(insertDto);
        System.out.println("insertInquiryForm success");

        // Test insertTemplateSunseo
        dao.insertTemplateSunseo(1, 1, 2);
        System.out.println("insertTemplateSunseo success");

        // Test insertInquiry
        dao.insertInquiry(1, "이름", "이메일", "전화번호", "댓글");
        System.out.println("insertInquiry success");
    }
}