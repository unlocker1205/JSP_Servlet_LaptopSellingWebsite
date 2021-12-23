package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AllProductController", value = "/AllProduct")
public class AllProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idHang = request.getParameter("idHang");
        if (idHang != null) {
            request.setAttribute("allProduct", ProductService.getInstance().getProductManufacturer(idHang));
            request.setAttribute("allProducer", ProductService.getInstance().getProducerWithID(idHang));
//            request.setAttribute("allProduct", ProductService.getInstance().getAllProduct());
//            request.setAttribute("allProducer", ProductService.getInstance().getAllProducer());
        } else {
//            request.setAttribute("allProductOfDell", ProductService.getInstance().getAllProduct());
//            request.setAttribute("productDell", ProductService.getInstance().getAllProducer());
            request.setAttribute("allProduct", ProductService.getInstance().getAllProduct());
            request.setAttribute("allProducer", ProductService.getInstance().getAllProducer());
        }
        request.getRequestDispatcher("jsp/all-product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
