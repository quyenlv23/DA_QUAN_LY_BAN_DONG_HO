/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;



/**
 *
 * @author mr.quyen
 */
public class SanPhamViewModel {

    private Integer maSanPham;
    private String size;
    private String chatLieu;
    private String mauSac;
    private String loaiSanPham;
    private String tenSanPham;
    private String maMay;
    private Double giaNhap;
    private Double GiaBan;
    private boolean tinhTrang;
    private Integer soLuong;
    private String moTa;

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(Integer maSanPham, String size, String chatLieu, String mauSac, String loaiSanPham, String tenSanPham, String maMay, Double giaNhap, Double GiaBan, boolean tinhTrang, Integer soLuong, String moTa) {
        this.maSanPham = maSanPham;
        this.size = size;
        this.chatLieu = chatLieu;
        this.mauSac = mauSac;
        this.loaiSanPham = loaiSanPham;
        this.tenSanPham = tenSanPham;
        this.maMay = maMay;
        this.giaNhap = giaNhap;
        this.GiaBan = GiaBan;
        this.tinhTrang = tinhTrang;
        this.soLuong = soLuong;
        this.moTa = moTa;
    }

    public Integer getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(Integer maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(Double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "SanPhamViewModel{" + "maSanPham=" + maSanPham + ", size=" + size + ", chatLieu=" + chatLieu + ", mauSac=" + mauSac + ", loaiSanPham=" + loaiSanPham + ", tenSanPham=" + tenSanPham + ", maMay=" + maMay + ", giaNhap=" + giaNhap + ", GiaBan=" + GiaBan + ", tinhTrang=" + tinhTrang + ", soLuong=" + soLuong + ", moTa=" + moTa + '}';
    }
     public Object[] toDataRow() {
        return new Object[]{maSanPham ,tenSanPham, giaNhap, GiaBan,soLuong};
    }

    
    
}
