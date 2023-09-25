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

@WebServlet("/makeAccount")
public class makeAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id=req.getParameter("id");
        String name = req.getParameter("name");
        Integer money = Integer.parseInt(req.getParameter("money"));
        String type = req.getParameter("type");
        String grade = req.getParameter("grade");
        if(grade == null) grade="";

        Account acc = new Account(id, name, money, type, grade);
        HttpSession session = req.getSession();
        session.setAttribute(id, acc);

        req.setAttribute("acc", acc);
        req.setAttribute("page", "accountInfo");
        RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
        dispatcher.forward(req, res);
    }
}