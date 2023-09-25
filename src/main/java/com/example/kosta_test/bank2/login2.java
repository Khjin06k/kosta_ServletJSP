package com.example.kosta_test.bank2;

import com.example.kosta_test.dto.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login2")
public class login2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/bank2/login2.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // 입력(Req)받은 값을 가져옴
        String id = req.getParameter("id");
        String pw = req.getParameter("password");

        // 세션에서 회원을 가져와 조회함
        HttpSession session = req.getSession();
        Member member = (Member) session.getAttribute("memeber");

        RequestDispatcher dispatcher = null;

        // 조회된 회원이 없다면
        if(member==null){
            req.setAttribute("err", "존재하지 않는 회원입니다.");
            dispatcher = req.getRequestDispatcher("/bank2/error.jsp");
            dispatcher.forward(req, res);
            return;
        }
        if(member.getId().equals(id)){
            req.setAttribute("err", "아이디가 틀립니다.");
            dispatcher = req.getRequestDispatcher("/bank2/error.jsp");
            dispatcher.forward(req, res);
            return;
        }
        if(member.getPassword().equals(pw)) {
            req.setAttribute("err", "비밀번호가 틀립니다.");
            dispatcher = req.getRequestDispatcher("/bank2/error.jsp");
            dispatcher.forward(req, res);
            return;
        }

        req.setAttribute("id", id);
        dispatcher = req.getRequestDispatcher("/bank2/makeAccount2.jsp");
        dispatcher.forward(req, res);
    }
}