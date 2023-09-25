package com.example.kosta_test.bank2;

import com.example.kosta_test.dto.Account;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deposit2")
public class Deposit2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 로그인이 되어있지 않으면 로그인 하라는 에러 페이지로 이동
        HttpSession session = req.getSession();
        if(session.getAttribute("id")==null){
            req.setAttribute("err", "로그인 하세요.");
            req.getRequestDispatcher("error.jsp").forward(req, res);
            return;
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("deposit2.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //입력(Req) 받은 값을 가져옴
        String id = req.getParameter("id");
        Integer money = Integer.parseInt("money");

        // 세션을 가져옴
        HttpSession session = req.getSession();

        // id를 이용해 계좌정보를 가져온 다음 입금에 대한 기능을 구현함
        Account acc = (Account) session.getAttribute(id);

        RequestDispatcher dispatcher = null;
        // 만약 계좌가 존재하지 않는다면
        if(acc == null){
            req.setAttribute("err", "계좌번호가 틀립니다.");
            dispatcher = req.getRequestDispatcher("error.jsp");
        }else{
            // 계좌가 존재한다면
            acc.deposit(money);

            // req에 입력받은 값을 처리한 것을 저장함
            // 레퍼런스를 통해 값을 가져오기 때문에 원래의 값(원본)이 변경되기 때문에 세션에 다시 저장하지 않아도 됨
            req.setAttribute("acc", acc);

            // deposit2.jsp를 포워딩함
            dispatcher = req.getRequestDispatcher("deposit2.jsp");
        }



        dispatcher.forward(req, res);
    }
}