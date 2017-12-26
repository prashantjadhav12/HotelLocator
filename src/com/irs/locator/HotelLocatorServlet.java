package com.irs.locator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HotelLocatorServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
        String lat = req.getParameter("lat");
        String lng = req.getParameter("lng");
        String radius = req.getParameter("radius");
        Integer rad = Integer.parseInt(radius);
        
        String result = new DatabaseService().getMarkersXml(lat, lng, rad);
        
        out.println("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>");
        out.println(result);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);;        
    }

}
