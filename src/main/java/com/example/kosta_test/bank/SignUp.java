package com.example.kosta_test.bank;

import com.example.kosta_test.dto.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signup")
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 회원가입하기 위한 정보들 가져오기
        String id = req.getParameter("id");
        String pw = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        // 가져온 정보들을 저장해 세션에 저장
        Member member = new Member(id, pw, name, email, address);
        HttpSession session = req.getSession();
        session.setAttribute("member", member);

        req.setAttribute("page", "login");
        RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
        dispatcher.forward(req, res);
    }
}