package com.example.kosta_test.bank;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logOut")
public class LogOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session =req.getSession();
        session.removeAttribute("id"); // 로그인을 유지하기 위해 세션에 저장한 아이디의 값을 삭제

        RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
        // 로그아웃 후 다시 로그인 페이지로 이동
        req.setAttribute("page", "login");
        dispatcher.forward(req, res);
    }
}