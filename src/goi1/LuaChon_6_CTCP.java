package goi1;

import java.sql.Date;

public class LuaChon_6_CTCP {
	private String MaHS;
	private Date NgayKham;
	private float ChiPhiKhamBenh;
	private String MaThuoc;
	private float DON_GIA_THUOC;
	private float TIEN_THUOC;
	private String MaDT;
	private float ChiPhiDT;
	private String MaNT;
	private float TongChiPhi_Phong_O;
	private float TongChiPhiBenhAn;

	public LuaChon_6_CTCP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LuaChon_6_CTCP(String maHS, Date ngayKham, float chiPhiKhamBenh, String maThuoc, float dON_GIA_THUOC,
			float tIEN_THUOC, String maDT, float chiPhiDT, String maNT, float tongChiPhi_Phong_O,
			float tongChiPhiBenhAn) {
		super();
		MaHS = maHS;
		NgayKham = ngayKham;
		ChiPhiKhamBenh = chiPhiKhamBenh;
		MaThuoc = maThuoc;
		DON_GIA_THUOC = dON_GIA_THUOC;
		TIEN_THUOC = tIEN_THUOC;
		MaDT = maDT;
		ChiPhiDT = chiPhiDT;
		MaNT = maNT;
		TongChiPhi_Phong_O = tongChiPhi_Phong_O;
		TongChiPhiBenhAn = tongChiPhiBenhAn;
	}

	public String getMaHS() {
		return MaHS;
	}

	public void setMaHS(String maHS) {
		MaHS = maHS;
	}

	public Date getNgayKham() {
		return NgayKham;
	}

	public void setNgayKham(Date ngayKham) {
		NgayKham = ngayKham;
	}

	public float getChiPhiKhamBenh() {
		return ChiPhiKhamBenh;
	}

	public void setChiPhiKhamBenh(float chiPhiKhamBenh) {
		ChiPhiKhamBenh = chiPhiKhamBenh;
	}

	public String getMaThuoc() {
		return MaThuoc;
	}

	public void setMaThuoc(String maThuoc) {
		MaThuoc = maThuoc;
	}

	public float getDON_GIA_THUOC() {
		return DON_GIA_THUOC;
	}

	public void setDON_GIA_THUOC(float dON_GIA_THUOC) {
		DON_GIA_THUOC = dON_GIA_THUOC;
	}

	public float getTIEN_THUOC() {
		return TIEN_THUOC;
	}

	public void setTIEN_THUOC(float tIEN_THUOC) {
		TIEN_THUOC = tIEN_THUOC;
	}

	public String getMaDT() {
		return MaDT;
	}

	public void setMaDT(String maDT) {
		MaDT = maDT;
	}

	public float getChiPhiDT() {
		return ChiPhiDT;
	}

	public void setChiPhiDT(float chiPhiDT) {
		ChiPhiDT = chiPhiDT;
	}

	public String getMaNT() {
		return MaNT;
	}

	public void setMaNT(String maNT) {
		MaNT = maNT;
	}

	public float getTongChiPhi_Phong_O() {
		return TongChiPhi_Phong_O;
	}

	public void setTongChiPhi_Phong_O(float tongChiPhi_Phong_O) {
		TongChiPhi_Phong_O = tongChiPhi_Phong_O;
	}

	public float getTongChiPhiBenhAn() {
		return TongChiPhiBenhAn;
	}

	public void setTongChiPhiBenhAn(float tongChiPhiBenhAn) {
		TongChiPhiBenhAn = tongChiPhiBenhAn;
	}

	@Override
	public String toString() {
		return "LuaChon_6_CTCP [MaHS=" + MaHS + ", NgayKham=" + NgayKham + ", ChiPhiKhamBenh=" + ChiPhiKhamBenh
				+ ", MaThuoc=" + MaThuoc + ", DON_GIA_THUOC=" + DON_GIA_THUOC + ", TIEN_THUOC=" + TIEN_THUOC + ", MaDT="
				+ MaDT + ", ChiPhiDT=" + ChiPhiDT + ", MaNT=" + MaNT + ", TongChiPhi_Phong_O=" + TongChiPhi_Phong_O
				+ ", TongChiPhiBenhAn=" + TongChiPhiBenhAn + "]";
	}

}
