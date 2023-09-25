package com.example.kosta_test.jstl_core;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fileUpload")
public class FileUpload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/web/jstl/fileUploadForm.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uploadPath = req.getRealPath("upload");
        int size = 10*1024*1024;
        // 자동으로 업로드
        MultipartRequest multi = new MultipartRequest(req, uploadPath, size,
                "utf-8", new DefaultFileRenamePolicy()); // 동일한 이름이 있을 때 1씩 증가?

        String name = multi.getParameter("name");
        String title = multi.getParameter("title");
        String orgFileName = multi.getOriginalFileName("file");


        System.out.println(name);
        System.out.println(title);
        System.out.println(orgFileName);

        req.setAttribute("name", name);
        req.setAttribute("title", title);
        req.setAttribute("file", orgFileName);

        req.getRequestDispatcher("/web/jstl/fileUploadResult.jsp").forward(req, res);

    }
}