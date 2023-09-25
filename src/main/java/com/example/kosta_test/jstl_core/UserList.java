package com.example.kosta_test.jstl_core;

import com.example.kosta_test.e2.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/userList")
public class UserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<User> userList=new ArrayList<>();
        userList.add(new User("hong", "홍길동", "서울시 금천구", "hong@kosta.com"));
        userList.add(new User("gong", "고길동", "서울시 영등포구", "gong@kosta.com"));
        userList.add(new User("kong", "콩길동", "서울시 강남구", "kong@kosta.com"));
        userList.add(new User("song", "송길동", "서울시 마포구", "song@kosta.com"));
        userList.add(new User("tong", "통길동", "서울시 서초구", "tong@kosta.com"));

        req.setAttribute("userList", userList);
        req.getRequestDispatcher("/web/jstl/userList.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}