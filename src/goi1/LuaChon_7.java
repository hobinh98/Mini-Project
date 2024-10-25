package goi1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class LuaChon_7 {
	private String MaHS;
	private String MaBN;
	private String TenBN;
	private String GioiTinh;
	private String PPDieuTri;
	private Time GioKham;
	private Date NgayKham;
	private Date NgayHenTaiKham;
	private String MaBS;

	public LuaChon_7() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LuaChon_7(String maHS, String maBN, String tenBN, String gioiTinh, String pPDieuTri, Time gioKham,
			Date ngayKham, Date ngayHenTaiKham, String maBS) {
		super();
		MaHS = maHS;
		MaBN = maBN;
		TenBN = tenBN;
		GioiTinh = gioiTinh;
		PPDieuTri = pPDieuTri;
		GioKham = gioKham;
		NgayKham = ngayKham;
		NgayHenTaiKham = ngayHenTaiKham;
		MaBS = maBS;
	}

	public String getMaHS() {
		return MaHS;
	}

	public void setMaHS(String maHS) {
		MaHS = maHS;
	}

	public String getMaBN() {
		return MaBN;
	}

	public void setMaBN(String maBN) {
		MaBN = maBN;
	}

	public String getTenBN() {
		return TenBN;
	}

	public void setTenBN(String tenBN) {
		TenBN = tenBN;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getPPDieuTri() {
		return PPDieuTri;
	}

	public void setPPDieuTri(String pPDieuTri) {
		PPDieuTri = pPDieuTri;
	}

	public Time getGioKham() {
		return GioKham;
	}

	public void setGioKham(Time gioKham) {
		GioKham = gioKham;
	}

	public Date getNgayKham() {
		return NgayKham;
	}

	public void setNgayKham(Date ngayKham) {
		NgayKham = ngayKham;
	}

	public Date getNgayHenTaiKham() {
		return NgayHenTaiKham;
	}

	public void setNgayHenTaiKham(Date ngayHenTaiKham) {
		NgayHenTaiKham = ngayHenTaiKham;
	}

	public String getMaBS() {
		return MaBS;
	}

	public void setMaBS(String maBS) {
		MaBS = maBS;
	}

	public static String getSql7() {
		return sql7;
	}

	@Override
	public String toString() {
		return "LuaChon_7 [MaHS=" + MaHS + ", MaBN=" + MaBN + ", TenBN=" + TenBN + ", GioiTinh=" + GioiTinh
				+ ", PPDieuTri=" + PPDieuTri + ", GioKham=" + GioKham + ", NgayKham=" + NgayKham + ", NgayHenTaiKham="
				+ NgayHenTaiKham + ", MaBS=" + MaBS + "]";
	}

	public static final String sql7 = "SELECT HSBN.MaHS, HSBN.MaBN, BN.TenBN, BN.GioiTinh, HSBN.PPDieuTri, HSBN.GioKham, HSBN.NgayKham, HSBN.NgayHenTaiKham, HSBN.MaBS\r\n"
			+ "	FROM BENH_NHAN as BN, HO_SO_BENH_AN as HSBN\r\n" + "	WHERE BN.TenBN LIKE ? AND BN.MaBN = HSBN.MaBN";

	public void TimKiem_TenBN_BatKy(Connection connection, Scanner scanner) {
		ArrayList<LuaChon_7> arrayList = new ArrayList<LuaChon_7>();
		PreparedStatement preparedStatement = null;
		try {
			System.out.println("Nhap vao ten muon tim kiem");
//			scanner.nextLine();
			String nhapTen = scanner.nextLine();
			String timTen = "%" + nhapTen + "%";
			preparedStatement = connection.prepareStatement(sql7);
			preparedStatement.setString(1, timTen);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String MaHSRS = resultSet.getString("MaHS");
				String MaBNRS = resultSet.getString("MaBN");
				String TenBNRS = resultSet.getString("TenBN");
				String GioiTinhRS = resultSet.getString("GioiTinh");
				String PPDieuTriRS = resultSet.getString("PPDieuTri");
				Time GioKhamRS = resultSet.getTime("GioKham");
				Date NgayKhamRS = resultSet.getDate("NgayKham");
				Date NgayHenTaiKhamRS = resultSet.getDate("NgayHenTaiKham");
				String MaBSRS = resultSet.getString("MaBS");

				LuaChon_7 chon_7 = new LuaChon_7(MaHSRS, MaBNRS, TenBNRS, GioiTinhRS, PPDieuTriRS, GioKhamRS, NgayKhamRS, NgayHenTaiKhamRS, MaBSRS);
				arrayList.add(chon_7);
			}

			if (arrayList.size() == 0) {
				System.out.println("Hien khong co ten benh nhan theo yeu cau ban nhap");
			}

			for (LuaChon_7 luaChon_7 : arrayList) {
				System.out.println(luaChon_7);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
