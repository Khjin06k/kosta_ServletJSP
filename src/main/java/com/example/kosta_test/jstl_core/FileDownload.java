package com.example.kosta_test.jstl_core;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/fileDown")
public class FileDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String fileName = req.getParameter("file");
        ServletContext context = req.getSession().getServletContext();
        String filePath = req.getRealPath("upload")+"\\"+fileName;

        FileInputStream in = new FileInputStream(filePath);

        String sMimeType = req.getSession().getServletContext().getMimeType(filePath); // 파일 형식을 얻어옴
        if(sMimeType==null){
            sMimeType ="application/octet-stream"; //octet-stream : 8비트로 된 일련의 데이터로 저장되지 않은 파일 형식을 의미
        }
        res.setContentType(sMimeType);
        String sEncoding = new String(fileName.getBytes("utf-8"), "8859_1"); //8859_1은 완성형을 의미
        res.setHeader("Content.Disposition", "attachment; filename= "+ sEncoding);

        OutputStream out = res.getOutputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        while((len = in.read(buff))>0){
            out.write(buff, 0, len);
        }
        out.close();
        in.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}