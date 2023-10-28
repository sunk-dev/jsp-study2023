package com.jsp.chap01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

// 역할: HTTP요청 응답 처리에서 필요한 공통적인 부분을 쉽게 해결해주는 자바 API
@WebServlet("/hello") // 우리 웹서버에 /hello라는 URL로 요청이 오면 이 서블릿을 실행시켜라
public class HelloServlet extends HttpServlet {

    // 기본 생성자
    public HelloServlet() {
        System.out.println("\n\n\n헬로 서블릿 작동 시작!\n\n\n");
    }

    // 파싱된 요청정보 얻는 방법

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 클라이언트 요청방식
        String method = req.getMethod();

        // 요청 URL
        String requestURI = req.getRequestURI();

        // 요청 헤더 읽기
        String header = req.getHeader("Cache-Control");

        System.out.println("method = " + method);
        System.out.println("requestURI = " + requestURI);
        System.out.println("header = " + header);

        // 쿼리 파라미터 읽기
        String keyword = req.getParameter("keyword");
        System.out.println("keyword = " + keyword);
        String age = req.getParameter("age");
        System.out.println("age = " + age);

        // 응답 메시지에 HTML문서 생성해서 응답하기
        // keyword님은 xxxx년생입니다.

        // 비지니스 로직 작성
        // 출생년도 구하기
        int year = LocalDateTime.now().getYear();
        int birthYear = year - Integer.parseInt(age) + 1;

        // HTML 생성
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        // HTML을 작성할 펜같은거 생성
        PrintWriter w = resp.getWriter();
        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("</head>\n");

        w.write("<body>\n");
        w.write("<h1>\n");
        w.write(String.format("%s님은 %d년생입니다.\n", keyword, birthYear));
        w.write("</h1>\n");
        w.write("</body>\n");

        w.write("</html>\n");

        w.flush();
        w.close();
    }
}
