package com.example.kosta_test.e2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/userInfo")
public class UserInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 한줄로 작성해도 됨
        RequestDispatcher dispatcher = req.getRequestDispatcher("/web/el2/userInfoForm.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String id = req.getParameter("id");
        // DB에서 id로 사용자를 조회
        // 현재는 DB가 없기 때문에 User를 생성함
        //User user = new User(id, "홍길동", "서울시 금천구", "email@kosta.com");
        // Map도 사용이 가능함
        Map<String, String> user = new HashMap<>();
        user.put("id", id);
        user.put("name", "홍길동");
        user.put("address", "서울시 금천구");
        user.put("email", "hong@kosta.com");

        // 위 정보를 request에는 응답 페이지에서만 사용할 정보를 담고, 세션에는 모든 페이지에서 사용할 정보를 저장
        HttpSession session=req.getSession();
        session.setAttribute("id", id);
        req.setAttribute("user", user); // request에 담은 정보는 다음에 포워딩하는 페이지로 가져오기 때문에 userInfo.jsp 로 넘겨줌

        // userInfo.jsp 로 포워딩 진행
        //
        req.getRequestDispatcher("/web/el2/userInfo.jsp").forward(req, res);

    }
}