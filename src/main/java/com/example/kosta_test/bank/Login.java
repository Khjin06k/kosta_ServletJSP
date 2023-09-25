package com.example.kosta_test.bank;

import com.example.kosta_test.dto.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 요청한 아이디와 비밀번호 값 가져오기
        String id = req.getParameter("id");
        String pw = req.getParameter("password");

        HttpSession session = req.getSession();
        Member member = (Member)session.getAttribute(id);


        RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
        if(member != null){
            if(member.getId().equals(id)==false){
                // 존재하는 회원이라면
                if(member.getPassword().equals(pw)){
                    if(member.getPassword().equals(pw)){
                        // 다른 페이지에서도 로그인 처리를 알 수 있게 아이디나 비밀전호를 알 수 있또록 세션에 저장 진행
                        session.setAttribute("id", id);
                        req.setAttribute("page", "makeAccount");
                    }else{
                        req.setAttribute("err", "비밀번호가 틀렸습니다.");
                        req.setAttribute("page", "error");              }
                    }

            }else{
                req.setAttribute("err", "아이디가 틀립니다");
                req.setAttribute("page", "error");
            }

        }else{
            // 존재하지 않는 회원이라면
            req.setAttribute("err", "회원가입 후 이용하세요");
            req.setAttribute("page", "error");
        }
        dispatcher.forward(req, res);
    }
}