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

@WebServlet("/withdraw2")
public class Withdraw2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 로그인이 되어있지 않으면 로그인 하라는 에러 페이지로 이동
        HttpSession session = req.getSession();
        if(session.getAttribute("id")==null){
            req.setAttribute("err", "로그인 하세요.");
            req.getRequestDispatcher("error.jsp").forward(req, res);
            return;
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("withdraw2.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // 입력(Req)받은 값을 가져옴
        String id = req.getParameter("id");
        Integer money = Integer.parseInt(req.getParameter("money"));

        // 세션을 받아옴
        HttpSession session = req.getSession();

        // 세션을 통해 계좌를 가져옴
        Account acc = (Account) session.getAttribute(id);

        RequestDispatcher dispatcher = null;

        // 만약 계좌번호가 존재하지 않는다면
        if(dispatcher == null){
            req.setAttribute("err", "계좌번호가 존재하지 않습니다.");
            dispatcher = req.getRequestDispatcher("error.jsp");
        }else{
            //계좌번호가 존재한다면
            acc.withdraw(money); // 출금

            // req에 계좌를 넣음
            // 레퍼런스를 통해 값을 가져오기 때문에 원래의 값(원본)이 변경되기 때문에 세션에 다시 저장하지 않아도 됨
            req.setAttribute("acc", acc);

            // withdraw2.jsp로 포워딩 진행
            dispatcher = req.getRequestDispatcher("withdraw2.jsp");
        }

        // withdraw를 포워딩 진행
        dispatcher.forward(req, res);
    }
}