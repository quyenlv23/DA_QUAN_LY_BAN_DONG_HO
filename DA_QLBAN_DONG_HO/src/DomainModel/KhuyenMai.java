/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;

/**
 *
 * @author mr.quyen
 */
public class KhuyenMai {

    
    private Integer maKhuyenMai;
    private String tenKhuyenMai;
    private Double tienGiam;
    private int trangThai;
    private Date thoiGianBatDau;
    private Date thoiGianKetThuc;
    private String moTa;

    public KhuyenMai() {
    }

    public KhuyenMai(Integer maKhuyenMai, String tenKhuyenMai, Double tienGiam, int trangThai, Date thoiGianBatDau, Date thoiGianKetThuc, String moTa) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.tienGiam = tienGiam;
        this.trangThai = trangThai;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.moTa = moTa;
    }

    public Integer getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(Integer maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public Double getTienGiam() {
        return tienGiam;
    }

    public void setTienGiam(Double tienGiam) {
        this.tienGiam = tienGiam;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return tenKhuyenMai;
    }

 

   

}
