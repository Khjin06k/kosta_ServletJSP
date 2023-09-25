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

@WebServlet("/accountInfo2")
public class AccountInfo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 로그인이 되어있지 않으면 로그인 하라는 에러 페이지로 이동
        HttpSession session = req.getSession();
        if(session.getAttribute("id")==null){
            req.setAttribute("err", "로그인 하세요.");
            req.getRequestDispatcher("error2.jsp").forward(req, res);
            return;
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/bank2/accountInfoForm2.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // 입력(Req) 받은 값 가져오기
        String id = req.getParameter("id");

        // 세션을 가져와 계좌를 가져옴
        HttpSession session = req.getSession();
        Account acc = (Account)session.getAttribute(id);

        RequestDispatcher dispatcher = null;

        // 계좌가 존재하지 않는다면
        if(acc == null){
            req.setAttribute("err", "계좌가 존재하지 않습니다.");
            dispatcher = req.getRequestDispatcher("error2.jsp");
        }else{
            // 계좌가 존재한다면 req에 담아서 accountInfo2로 포워딩
            req.setAttribute("acc", acc);
            dispatcher = req.getRequestDispatcher("/bank2/accountInfo2.jsp");
        }
        dispatcher.forward(req, res);

    }
}