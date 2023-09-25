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
import java.sql.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/allAccountInfo2")
public class AllAccountInfo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 로그인이 되어있지 않으면 로그인 하라는 에러 페이지로 이동
        HttpSession session = req.getSession();
        if(session.getAttribute("id")==null){
            req.setAttribute("err", "로그인 하세요.");
            req.getRequestDispatcher("error.jsp").forward(req, res);
            return;
        }

        // session에 있는 모든 키 목록을 가져옴
        Enumeration<String> e = session.getAttributeNames();

        // 목록을 보내주기 위한 목록 생성
        List<Account> accs = new ArrayList<>();

        // 반복하여 e에서 요소가 존재하면 가져와서 목록에 추가함
        while(e.hasMoreElements()){
            String name = e.nextElement();
            // 계좌가 아닌 멤버이거나 계좌번호 라면 걸러내야 함 (세션에 함께 저장하기 때문에 섞여 있음)
            if(name.equals("member") || name.equals("id")) continue;
            // 계좌를 받아와 저장한 후 목록에 추가
            Account acc = (Account) session.getAttribute(name);
            accs.add(acc);
        }

        RequestDispatcher dispatcher = null;
        // 만약 계좌가 하나도 없을 경우
        if(accs.isEmpty()){
            req.setAttribute("err", "개설된 계좌가 없습니다.");
            dispatcher = req.getRequestDispatcher("error.jsp");
        }else{
            // 개설된 계좌가 있는 경우
            req.setAttribute("accs", accs);
            dispatcher = req.getRequestDispatcher("allAccountInfo2.jsp");
        }
        dispatcher.forward(req, res);

    }
}