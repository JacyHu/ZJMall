package com.nchhr.mall.Service;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CookiesService {

    public boolean saveCookies(String MID, HttpServletResponse response, HttpServletRequest request) {
        try{
        Cookie[] cookies = request.getCookies();
        if (cookies == null){

            Cookie WXIDCookie = new Cookie("MID", MID);

            WXIDCookie.setMaxAge(315360000);//设置cookie生存时间：十年
            response.addCookie(WXIDCookie);// 添加cookie：
        }
        else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("MID")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
            Cookie WXIDCookie = new Cookie("MID", MID);
            WXIDCookie.setMaxAge(315360000);//设置cookie生存时间：十年
            response.addCookie(WXIDCookie);// 添加cookie：
        }

        }catch(Exception e){
            return false;

        }
        return true;
    }

    public boolean clear(HttpServletResponse response, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            return true;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("MID")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

        return true;
    }
    public String print(HttpServletResponse response, HttpServletRequest request){
        String ss = "";
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            return "";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("MID")) {
               ss = cookie.getValue();
            }
        }
        return ss;
    }
}
