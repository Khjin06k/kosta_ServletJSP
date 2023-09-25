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

@WebServlet("/deposit")
public class Deposit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8"); // 한글을 가져오기 위해 설정 필요
        // 입력받은 값을 가져오기 위해 request에서 getParam을 이용하여 값을 받아옴
        String id = req.getParameter("id");
        Integer money = Integer.parseInt(req.getParameter("money"));

        HttpSession session = req.getSession(); // 세션 가져오기
        Account acc = (Account) session.getAttribute(id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/bank/main.jsp");
        if(acc != null){
            // 계좌가 존재한다면
            // acc.setBalance(acc.getBalance()+money); // acc에서 balance에 money를 더해 acc를 set 해줌
            acc.deposit(money); // Account dto에 메서드를 만들어 두었기 때문에 그것을 활용
            req.setAttribute("acc", acc); // 수정된 acc를 req에 set
            req.setAttribute("page", "accountInfo"); // 입금하고 나서 조회 페이지로 넘어가기 위해 페이지를 설정해줌
        }else{
            // 계좌가 존재하지 않는다면
            req.setAttribute("err", "계좌번호가 틀립니다.");
            req.setAttribute("page", "error"); // error 페이지를 만들어 에러 로그를 출력하고 하는 것
        }
        dispatcher.forward(req, res);

    }
}