package com.example.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

@WebServlet(name = "SortNum", value = "/SortNum")
public class SortServlet extends HttpServlet {

    /* @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.println("<h1>moy servlet eto</h1>");

        String param = req.getParameter("param");
        writer.println("<h1>" + param + "</h1>");
    }
*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var numbers=req.getParameter("nums");
        var vid= Integer.parseInt(req.getParameter("vid"));
        resp.setContentType("text/html");
        resp.setLocale(new Locale("rus"));
        resp.setHeader("Content-Language", "ru");
        resp.setCharacterEncoding("UTF-8");
        var writer = resp.getWriter();
        writer.println("<h1>Результат</h1>");
        writer.println("<h2>" + doSort(numbers,vid) + "</h2><br/>");
        writer.println("<a href=\"File.html\">Вернуться назад</a>");

    }

    private String doSort(String n, int f) {
        String[] s = n.replace(" ", "").split(",");
        int[] mas = new int[s.length];
        for (int i = 0; i < mas.length; i++){
            mas[i]=Integer.parseInt(s[i]);
        }
        Arrays.sort(mas);
        var result="";
        if(f==1){
            result+=mas[0];
        for (int i = 1; i < mas.length; i++){
            result+=", "+mas[i];
        }}
        else {
            result+=mas[mas.length-1];
            for (int i = mas.length-2; i >= 0; i--){
            result+=", "+mas[i];
        }}
        return result;
    }
}
