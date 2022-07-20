package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.google.common.collect.Multimap;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.AdminServices;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.ProductService;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

//@WebServlet(name = "ProductController", value = "/Admin")
@WebServlet(urlPatterns = {"/Edit", "/Delete", "/Add", "/Admin"})
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String URL = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"), request.getRequestURI().length());
        switch (URL) {
            case "/Admin":
                HttpSession session = request.getSession();
                Multimap<String, String> map = (Multimap<String, String>) session.getAttribute("map");
                if (map != null) {
                    map.clear();
                }
                // Đổ dữ liệu và phân trang cho bảng Thông tin laptop
                int page = 1;
                if (request.getParameter("pageTTLT") == null && request.getParameter("pageTTLT") == "") {
                    page = 1;
                }
                if (request.getParameter("pageTTLT") != null && request.getParameter("pageTTLT") != "") {
                    page = Integer.parseInt(request.getParameter("pageTTLT"));
                }
                request.setAttribute("pageTTLT", page);
                int limit = 15;
                request.setAttribute("allProduct", ProductService.getInstance().getAllProduct(limit, page));
                int totalPage = ProductService.getInstance().getTotalPage();
                int total = (int) Math.ceil((double) totalPage / (double) limit);
                request.setAttribute("totalPageTTLT", total);

                // Đổ dữ liệu và phân trang cho bảng hãng sản xuất
                int pageHSX = 1;
                if (request.getParameter("pageHSX") == null && request.getParameter("pageHSX") == "") {
                    pageHSX = 1;
                }
                if (request.getParameter("pageHSX") != null && request.getParameter("pageHSX") != "") {
                    pageHSX = Integer.parseInt(request.getParameter("pageHSX"));
                }
                request.setAttribute("pageHSX", pageHSX);
                int limitHSX = 3;
                request.setAttribute("allProductHSX", AdminServices.getInstance().getAllManufacturer(limitHSX, pageHSX));
                int totalPageHSX = AdminServices.getInstance().getTotalManufacturer();
                int totalHSX = (int) Math.ceil((double) totalPageHSX / (double) limitHSX);
                request.setAttribute("totalPageHSX", totalHSX);

                // Đổ dữ liệu và phân trang cho bảng kho hàng
                int pageKho = 1;
                if (request.getParameter("pageKho") == null && request.getParameter("pageKho") == "") {
                    pageKho = 1;
                }
                if (request.getParameter("pageKho") != null && request.getParameter("pageKho") != "") {
                    pageKho = Integer.parseInt(request.getParameter("pageKho"));
                }
                request.setAttribute("pageKho", pageKho);
                int limitKho = 20;
                request.setAttribute("allKho", AdminServices.getInstance().getAllWareHouse(limitKho, pageKho));
                int totalPageKho = AdminServices.getInstance().getTotalPageWareHouse();
                int totalKho = (int) Math.ceil((double) totalPageKho / (double) limitKho);
                request.setAttribute("totalPageKho", totalKho);

                // Đổ dữ liệu và phân trang cho bảng tài khoản
                int pageAccount = 1;
                if (request.getParameter("pageAccount") == null && request.getParameter("pageAccount") == "") {
                    pageAccount = 1;
                }
                if (request.getParameter("pageAccount") != null && request.getParameter("pageAccount") != "") {
                    pageAccount = Integer.parseInt(request.getParameter("pageAccount"));
                }
                request.setAttribute("pageAccount", pageAccount);
                int limitAccount = 2;
                request.setAttribute("allAccount", AdminServices.getInstance().getAllAccount(limitAccount, pageAccount));
                int totalPageAccount = AdminServices.getInstance().getTotalPageAccount();
                int totalAccount = (int) Math.ceil((double) totalPageAccount / (double) limitAccount);
                request.setAttribute("totalAccount", totalAccount);


                request.getRequestDispatcher("jsp/admin.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("send");
        String dataTemp = data;
        String[] exactlyData = dataTemp.split(",");
        String currentTable = request.getParameter("currentTable");
        String URL = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"), request.getRequestURI().length());
        PrintWriter out = response.getWriter();
        switch (URL) {
            case "/Edit":
                String dieuKienUpdate = request.getParameter("dieuKien");
                switch (currentTable) {
                    case "TTLT":
                        String maLaptop = exactlyData[0];
                        String tenLaptop = exactlyData[1];
                        String hang = exactlyData[2];
                        int giaban = 0;
                        try {
                            giaban = Integer.parseInt(exactlyData[3]);
                        } catch (Exception e) {
                            giaban = 0;
                        }
                        String series = exactlyData[4];
                        String mau = exactlyData[5];
                        String cpu = exactlyData[6];
                        String vga = exactlyData[7];
                        String ram = exactlyData[8];
                        String kichThuocManHinh = exactlyData[9];
                        String oCung = exactlyData[10];
                        String banPhim = exactlyData[11];
                        String pin = exactlyData[12];
                        String khoiLuong = exactlyData[13];
                        String linkHinh1 = exactlyData[14];
                        String linkHinh2 = exactlyData[15];
                        String linkHinh3 = exactlyData[16];
                        String linkHinh4 = exactlyData[17];
                        String linkHinh5 = exactlyData[18];
                        out.println(AdminServices.getInstance().updateLaptop(maLaptop, tenLaptop, hang, giaban, series, mau, cpu, vga, ram, kichThuocManHinh, oCung, banPhim, pin, khoiLuong, linkHinh1, linkHinh2, linkHinh3, linkHinh4, linkHinh5, dieuKienUpdate));
                        break;
                    case "HSX":
                        String tenHang = exactlyData[0];
                        String quocGia = exactlyData[1];
                        String poster = exactlyData[2];
                        String logoVuong = exactlyData[3];
                        String logoNgang = exactlyData[4];
                        String slogan = exactlyData[5];
                        out.println(AdminServices.getInstance().updateHangSx(tenHang, quocGia, poster, logoVuong, logoNgang, slogan, dieuKienUpdate));
                        break;
                    case "Kho":
                        String maLaptopKho = exactlyData[0];
                        int slNhap = 0;
                        try {
                            slNhap = Integer.parseInt(exactlyData[1]);
                        } catch (Exception e) {
                            slNhap = 0;
                        }
                        int slXuat = 0;
                        try {
                            slXuat = Integer.parseInt(exactlyData[2]);
                        } catch (Exception e) {
                            slXuat = 0;
                        }
                        int slTon = 0;
                        try {
                            slTon = Integer.parseInt(exactlyData[3]);
                        } catch (Exception e) {
                            slTon = 0;
                        }
                        out.println(AdminServices.getInstance().updateKho(maLaptopKho, slNhap, slXuat, slTon, dieuKienUpdate));
                        break;
                    case "Account":
                        String hoTen = exactlyData[1];
                        String username = exactlyData[2];
                        String pass = exactlyData[3];
                        String diaChi = exactlyData[4];
                        String email = exactlyData[5];
                        int dieuKien = Integer.parseInt(dieuKienUpdate);
                        System.out.println(hoTen);
                        out.println(AdminServices.getInstance().updateAccount(hoTen, username, pass, diaChi, email, dieuKien));
                        break;
                }
                break;
            case "/Delete":
                String dieuKienDelete = request.getParameter("dieuKien");
                switch (currentTable) {
                    case "TTLT":
                        out.println(AdminServices.getInstance().deleteLaptop(dieuKienDelete));
                        break;
                    case "HSX":
                        out.println(AdminServices.getInstance().deleteHangSx(dieuKienDelete));
                        break;
                    case "Kho":
                        out.println(AdminServices.getInstance().deleteKho(dieuKienDelete));
                        break;
                    case "Account":
                        out.println(AdminServices.getInstance().deleteAccount(Integer.parseInt(dieuKienDelete)));
                        break;
                }
                break;
            case "/Add":
                switch (currentTable) {
                    case "TTLT":
                        String maLaptop = exactlyData[0];
                        String tenLaptop = exactlyData[1];
                        String hang = exactlyData[2];
                        int giaban = 0;
                        try {
                            giaban = Integer.parseInt(exactlyData[3]);
                        } catch (Exception e) {
                            giaban = 0;
                        }
                        String series = exactlyData[4];
                        String mau = exactlyData[5];
                        String cpu = exactlyData[6];
                        String vga = exactlyData[7];
                        String ram = exactlyData[8];
                        String kichThuocManHinh = exactlyData[9];
                        String oCung = exactlyData[10];
                        String banPhim = exactlyData[11];
                        String pin = exactlyData[12];
                        String khoiLuong = exactlyData[13];
                        String linkHinh1 = exactlyData[14];
                        String linkHinh2 = exactlyData[15];
                        String linkHinh3 = exactlyData[16];
                        String linkHinh4 = exactlyData[17];
                        String linkHinh5 = exactlyData[18];
                        out.println(AdminServices.getInstance().insertLapTop(maLaptop, tenLaptop, hang, giaban, series, mau, cpu, vga, ram, kichThuocManHinh, oCung, banPhim, pin, khoiLuong, linkHinh1, linkHinh2, linkHinh3, linkHinh4, linkHinh5));
                        break;
                    case "HSX":
                        String tenHang = exactlyData[0];
                        String quocGia = exactlyData[1];
                        String poster = exactlyData[2];
                        String logoVuong = exactlyData[3];
                        String logoNgang = exactlyData[4];
                        String slogan = exactlyData[5];
                        out.println(AdminServices.getInstance().insertHangSx(tenHang, quocGia, poster, logoVuong, logoNgang, slogan));
                        break;
                    case "Kho":
                        String maLaptopKho = exactlyData[0];
                        int slNhap = 0;
                        try {
                            slNhap = Integer.parseInt(exactlyData[1]);
                        } catch (Exception e) {
                            slNhap = 0;
                        }
                        int slXuat = 0;
                        try {
                            slXuat = Integer.parseInt(exactlyData[2]);
                        } catch (Exception e) {
                            slXuat = 0;
                        }
                        int slTon = 0;
                        try {
                            slTon = Integer.parseInt(exactlyData[3]);
                        } catch (Exception e) {
                            slTon = 0;
                        }
                        out.println(AdminServices.getInstance().insertKho(maLaptopKho, slNhap, slXuat, slTon));
                        break;
                    case "Account":
                        String hoTen = exactlyData[1];
                        String username = exactlyData[2];
                        String pass = exactlyData[3];
                        String diaChi = exactlyData[4];
                        String email = exactlyData[5];
                        if (!UserServices.checkUser(username)){
                            out.println(AdminServices.getInstance().insertAccount(hoTen, username, pass, diaChi, email));
                        }
                        break;
                }
                break;
        }
    }
}
