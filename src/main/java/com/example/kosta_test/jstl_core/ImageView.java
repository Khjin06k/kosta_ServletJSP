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

@WebServlet("/imageView")
public class ImageView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String fileName=req.getParameter("file");

        ServletContext context = req.getSession().getServletContext();
        String filePath = context.getRealPath("upload")+"\\"+fileName;

        FileInputStream fis = new FileInputStream(filePath);
        OutputStream out = res.getOutputStream();

        byte[] buff = new byte[1024];
        int len = 0;
        while((len=fis.read(buff))>0){
            out.write(buff, 0, len);
        }
        fis.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}