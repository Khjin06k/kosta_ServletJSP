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

@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        Integer money = Integer.parseInt(req.getParameter("money"));
        HttpSession session = req.getSession();
        Account acc = (Account) session.getAttribute(id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
        if(acc != null){
            // 계좌가 존재한다면
            acc.withdraw(money);
            req.setAttribute("acc", acc);
            req.setAttribute("page", "accountInfo");
        }else{
            // 계좌가 존재하지 않는다면
            req.setAttribute("err", "계좌번호가 틀렸습니다");
            req.setAttribute("page", "error");
        }
        dispatcher.forward(req, res);

    }
}