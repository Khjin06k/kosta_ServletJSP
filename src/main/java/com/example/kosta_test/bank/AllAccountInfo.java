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
import java.sql.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/allaccountinfo")
public class AllAccountInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Account> accs = new ArrayList<>();
        HttpSession session = req.getSession();

        // 이름 목록을 가져옴
        Enumeration<String> e = session.getAttributeNames();
        while(e.hasMoreElements()){ // 계좌가 존재하면 계속 accs에 저장
            String name = e.nextElement();
            if(name.equals("member") || name.equals("name")) continue;
            Account acc = (Account)session.getAttribute(name); // 계좌번호를 알 수 없어 가져온 이름을 가지고 계좌를 조회
            accs.add(acc);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
        if(accs.size()>0){
            req.setAttribute("accs", accs);
            req.setAttribute("page", "allaccountinfo");
        }else{
            req.setAttribute("err", "개설된 계좌가 없습니다");
            req.setAttribute("page", "error");
        }
        dispatcher.forward(req, res);
    }
}