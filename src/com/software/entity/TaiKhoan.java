package com.software.entity;
public class TaiKhoan {
    private String soDienThoai;
    private String matKhau;

    public TaiKhoan() {

    }

    public TaiKhoan(String soDienThoai, String matKhau) {
        this.soDienThoai = soDienThoai;
        this.matKhau = matKhau;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    
}
