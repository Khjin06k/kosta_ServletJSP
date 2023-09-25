package com.example.kosta_test.bank;

import com.example.kosta_test.dto.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/accountInfo")
public class AccountInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); // 한글이 깨지지 않도록 설정 >> 매번 설정해 주어야 함
        String id = req.getParameter("id");
        HttpSession session = req.getSession(); // session 받아오기
        Account acc = (Account) session.getAttribute(id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
        if(acc != null){
            req.setAttribute("acc", acc);
            req.setAttribute("page", "accountInfo");
        }else{
            req.setAttribute("err", "계좌번호가 틀립니다.");
            req.setAttribute("page", "error"); // error 페이지를 만들어 에러 로그를 출력하고 하는 것
        }
        dispatcher.forward(req, res);
    }
}