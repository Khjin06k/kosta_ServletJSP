package com.example.kosta_test.bank2;

import com.example.kosta_test.dto.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/makeAccount2")
public class MakeAccount2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 로그인이 되어있지 않으면 로그인 하라는 에러 페이지로 이동
        HttpSession session = req.getSession();
        if(session.getAttribute("id")==null){
            req.setAttribute("err", "로그인 하세요.");
            req.getRequestDispatcher("error.jsp").forward(req, res);
            return;
        }
        // header2.jsp에서의 요청
        RequestDispatcher dispatcher = req.getRequestDispatcher("makeAccount2.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // 입력(Req) 받은 값을 가져옴
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        Integer money = Integer.parseInt(req.getParameter("money"));
        String type = req.getParameter("type");
        String grade = req.getParameter("grade");
        if(grade == null) grade = ""; //비어있을 경우 null이 아니라 빈칸 입력

        // 받아온 값들로 Account 객체 생성
        Account acc = new Account(id, name, money, type, grade);

        // Session을 받아오기
        HttpSession session = req.getSession();

        // 생성된 Account 객체를 req, session에 저장
        // 나중에 세션에서 id를 이용해 객체를 불러오기 때문에 세션에 저장할 때에는 id 값으로 객체를 저장
        session.setAttribute("id", acc);
        req.setAttribute("acc", acc);

        // accountInfo2.jsp 로 포워딩
        // 모든 jsp에서 헤더를 포함하고 있기 때문에 main.jsp가 아닌 accountInfo2.jsp를 포워딩하면 됨
        RequestDispatcher dispatcher = req.getRequestDispatcher("accountInfo2.jsp");
        dispatcher.forward(req, res);
    }
}