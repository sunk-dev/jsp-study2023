package com.jsp.chap04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hahahohoh")
public class TestViewServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //내부적으로 보안 폴더(WEB-INF)에 있는 jsp를 열어줌.-포워딩
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/test.jsp");
        rd.forward(req,resp);

    }
}
