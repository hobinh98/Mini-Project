package goi1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.DocFlavor.READER;

public class LuaChon_6 {
	private String maHS;
	private float tongChiPhiKhamBenh;
	private int tongSo;

	public LuaChon_6() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LuaChon_6(String maHS, float tongChiPhiKhamBenh, int tongSo) {
		super();
		this.maHS = maHS;
		this.tongChiPhiKhamBenh = tongChiPhiKhamBenh;
		this.tongSo = tongSo;
	}

	public String getMaHS() {
		return maHS;
	}

	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}

	public float getTongChiPhiKhamBenh() {
		return tongChiPhiKhamBenh;
	}

	public void setTongChiPhiKhamBenh(float tongChiPhiKhamBenh) {
		this.tongChiPhiKhamBenh = tongChiPhiKhamBenh;
	}

	public int getTongSo() {
		return tongSo;
	}

	public void setTongSo(int tongSo) {
		this.tongSo = tongSo;
	}

	@Override
	public String toString() {
		return "LuaChon_6 [maHS=" + maHS + ", tongChiPhiKhamBenh=" + tongChiPhiKhamBenh + ", tongSo=" + tongSo + "]";
	}

	public LuaChon_6 SoBN_ChiPhi_TheoTungThang(Connection connection, Scanner scanner, String ngayKham) {
		ArrayList<LuaChon_6> thongKe6 = new ArrayList<LuaChon_6>();
		ArrayList<LuaChon_6> tong_sum = new ArrayList<LuaChon_6>();
		float sum = 0f;

		String sql6_1 = "SELECT \r\n" + "	HSBA.MaHS, HSBA.ChiPhiKhamBenh, \r\n"
				+ "	DTT.MaThuoc,T.DonGia DON_GIA_THUOC, SUM(DTT.SoLuong*T.DonGia) AS TIEN_THUOC, \r\n"
				+ "	DT.MaDT, DT.ChiPhiChuaBenh ChiPhiDT, \r\n"
				+ "	TTNT.MaNT, TTNT.DonGiaTienPhong*(DATEDIFF(DAY, TTNT.NgayNhapVien, TTNT.NgayXuatVien)) TongChiPhi_Phong_O, \r\n"
				+ "	T.DonGia + SUM(DTT.SoLuong*T.DonGia) + DT.ChiPhiChuaBenh + HSBA.ChiPhiKhamBenh + TTNT.DonGiaTienPhong*(DATEDIFF(DAY, TTNT.NgayNhapVien, TTNT.NgayXuatVien)) TongChiPhiKhamBenh\r\n"
				+ "	FROM DIEU_TRI_THUOC AS DTT, THUOC AS T, DIEU_TRI AS DT, HO_SO_BENH_AN AS HSBA, THONG_TIN_NOI_TRU AS TTNT\r\n"
				+ "	WHERE DTT.MaThuoc = T.MaThuoc AND DT.MaDT = DTT.MaDT AND DT.MaDT = HSBA.MaDT AND HSBA.MaNT = TTNT.MaNT AND "
				+ ngayKham + "\r\n"
				+ "	GROUP BY DT.MaDT, DTT.MaThuoc, DT.ChiPhiChuaBenh, T.DonGia, HSBA.ChiPhiKhamBenh, TTNT.DonGiaTienPhong, TTNT.NgayNhapVien, TTNT.NgayXuatVien, HSBA.MaHS, TTNT.MaNT";

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql6_1);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String maHSRS = resultSet.getString("MaHS");
				float tongChiPhiKhamBenhRS = resultSet.getFloat("TongChiPhiKhamBenh");
				LuaChon_6 chon_61 = new LuaChon_6(maHSRS, tongChiPhiKhamBenhRS, 0);
				thongKe6.add(chon_61);
			}

			for (int i = 0; i < thongKe6.size(); i++) {
				sum = sum + thongKe6.get(i).getTongChiPhiKhamBenh();
			}
//			tong_sum.add(chon_62);
		} catch (Exception e) {
			// TODO: handle exception
		}
		LuaChon_6 chon_62 = new LuaChon_6(null, sum, thongKe6.size());
		return chon_62;
	}

	public void ThongKe(Connection connection, Scanner scanner, String namThongKe) {
		ArrayList<LuaChon_6> arrayList = new ArrayList<LuaChon_6>();
		LuaChon_6 chon_6 = new LuaChon_6();
		String thang_1 = "HSBA.NgayKham >= '" + namThongKe + "-1-1' AND HSBA.NgayKham <= '" + namThongKe + "-1-31'";
		String thang_2 = "HSBA.NgayKham >= '" + namThongKe + "-2-1' AND HSBA.NgayKham <= '" + namThongKe + "-2-30'";
		String thang_3 = "HSBA.NgayKham >= '" + namThongKe + "-3-1' AND HSBA.NgayKham <= '" + namThongKe + "-3-31'";
		String thang_4 = "HSBA.NgayKham >= '" + namThongKe + "-4-1' AND HSBA.NgayKham <= '" + namThongKe + "-4-30'";
		String thang_5 = "HSBA.NgayKham >= '" + namThongKe + "-5-1' AND HSBA.NgayKham <= '" + namThongKe + "-5-31'";
		String thang_6 = "HSBA.NgayKham >= '" + namThongKe + "-6-1' AND HSBA.NgayKham <= '" + namThongKe + "-6-30'";
		String thang_7 = "HSBA.NgayKham >= '" + namThongKe + "-7-1' AND HSBA.NgayKham <= '" + namThongKe + "-7-31'";
		String thang_8 = "HSBA.NgayKham >= '" + namThongKe + "-8-1' AND HSBA.NgayKham <= '" + namThongKe + "-8-31'";
		String thang_9 = "HSBA.NgayKham >= '" + namThongKe + "-9-1' AND HSBA.NgayKham <= '" + namThongKe + "-9-30'";
		String thang_10 = "HSBA.NgayKham >= '" + namThongKe + "-10-1' AND HSBA.NgayKham <= '" + namThongKe + "-10-31'";
		String thang_11 = "HSBA.NgayKham >= '" + namThongKe + "-11-1' AND HSBA.NgayKham <= '" + namThongKe + "-11-30'";
		String thang_12 = "HSBA.NgayKham >= '" + namThongKe + "-12-1' AND HSBA.NgayKham <= '" + namThongKe + "-12-31'";

		arrayList.add(chon_6.SoBN_ChiPhi_TheoTungThang(ConnecTion.connection, scanner, thang_1));
		arrayList.add(chon_6.SoBN_ChiPhi_TheoTungThang(ConnecTion.connection, scanner, thang_2));
		arrayList.add(chon_6.SoBN_ChiPhi_TheoTungThang(ConnecTion.connection, scanner, thang_3));
		arrayList.add(chon_6.SoBN_ChiPhi_TheoTungThang(ConnecTion.connection, scanner, thang_4));
		arrayList.add(chon_6.SoBN_ChiPhi_TheoTungThang(ConnecTion.connection, scanner, thang_5));
		arrayList.add(chon_6.SoBN_ChiPhi_TheoTungThang(ConnecTion.connection, scanner, thang_6));
		arrayList.add(chon_6.SoBN_ChiPhi_TheoTungThang(ConnecTion.connection, scanner, thang_7));
		arrayList.add(chon_6.SoBN_ChiPhi_TheoTungThang(ConnecTion.connection, scanner, thang_8));
		arrayList.add(chon_6.SoBN_ChiPhi_TheoTungThang(ConnecTion.connection, scanner, thang_9));
		arrayList.add(chon_6.SoBN_ChiPhi_TheoTungThang(ConnecTion.connection, scanner, thang_10));
		arrayList.add(chon_6.SoBN_ChiPhi_TheoTungThang(ConnecTion.connection, scanner, thang_11));
		arrayList.add(chon_6.SoBN_ChiPhi_TheoTungThang(ConnecTion.connection, scanner, thang_12));

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println("Tong so BN thang " + (i + 1) + ": " + arrayList.get(i).getTongSo() + "  Tong CP thang "
					+ (i + 1) + ": " + arrayList.get(i).getTongChiPhiKhamBenh());
		}

	}

	public void ChiTiet_TongChiPhi(Connection connection, Scanner scanner, String namThongKe) {
		ArrayList<LuaChon_6_CTCP> arrayList = new ArrayList<LuaChon_6_CTCP>();

		String sql6_1 = "	SELECT \r\n" + "	HSBA.MaHS, HSBA.NgayKham, HSBA.ChiPhiKhamBenh, \r\n"
				+ "	DTT.MaThuoc,T.DonGia DON_GIA_THUOC, SUM(DTT.SoLuong*T.DonGia) AS TIEN_THUOC, \r\n"
				+ "	DT.MaDT, DT.ChiPhiChuaBenh ChiPhiDT, \r\n"
				+ "	TTNT.MaNT, TTNT.DonGiaTienPhong*(DATEDIFF(DAY, TTNT.NgayNhapVien, TTNT.NgayXuatVien)) TongChiPhi_Phong_O, \r\n"
				+ "	T.DonGia + SUM(DTT.SoLuong*T.DonGia) + DT.ChiPhiChuaBenh + HSBA.ChiPhiKhamBenh + TTNT.DonGiaTienPhong*(DATEDIFF(DAY, TTNT.NgayNhapVien, TTNT.NgayXuatVien)) TongChiPhiBenhAn\r\n"
				+ "	FROM DIEU_TRI_THUOC AS DTT, THUOC AS T, DIEU_TRI AS DT, HO_SO_BENH_AN AS HSBA, THONG_TIN_NOI_TRU AS TTNT\r\n"
				+ "	WHERE DTT.MaThuoc = T.MaThuoc AND DT.MaDT = DTT.MaDT AND DT.MaDT = HSBA.MaDT AND HSBA.MaNT = TTNT.MaNT AND HSBA.NgayKham >= '"
				+ namThongKe + "-1-1' AND HSBA.NgayKham <= '" + namThongKe + "-12-31'\r\n"
				+ "	GROUP BY DT.MaDT, DTT.MaThuoc, DT.ChiPhiChuaBenh, T.DonGia, HSBA.ChiPhiKhamBenh, TTNT.DonGiaTienPhong, TTNT.NgayNhapVien, TTNT.NgayXuatVien, HSBA.MaHS, TTNT.MaNT, HSBA.NgayKham\r\n"
				+ "	ORDER BY HSBA.NgayKham";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql6_1);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String MaHSRS = resultSet.getString("MaHS");
				Date NgayKhamRS = resultSet.getDate("NgayKham");
				float ChiPhiKhamBenhRS = resultSet.getFloat("ChiPhiKhamBenh");
				String MaThuocRS = resultSet.getString("MaThuoc");
				float DON_GIA_THUOCRS = resultSet.getFloat("DON_GIA_THUOC");
				float TIEN_THUOCRS = resultSet.getFloat("TIEN_THUOC");
				String MaDTRS = resultSet.getString("MaDT");
				float ChiPhiDTRS = resultSet.getFloat("ChiPhiDT");
				String MaNTRS = resultSet.getString("MaNT");
				float TongChiPhi_Phong_ORS = resultSet.getFloat("TongChiPhi_Phong_O");
				float TongChiPhiBenhAnRS = resultSet.getFloat("TongChiPhiBenhAn");

				LuaChon_6_CTCP chon_6_CTCP = new LuaChon_6_CTCP(MaHSRS, NgayKhamRS, ChiPhiKhamBenhRS, MaThuocRS,
						DON_GIA_THUOCRS, TIEN_THUOCRS, MaDTRS, ChiPhiDTRS, MaNTRS, TongChiPhi_Phong_ORS,
						TongChiPhiBenhAnRS);
				arrayList.add(chon_6_CTCP);
			}

			System.out.println("----------------------------------------------------");
			if (arrayList.size() == 0) {
				System.out.println("Hien chua co BENH NHAN nao ton tai trong quan ly HSBN theo nam ban vua nhap");
			} else {
				System.out.println("Chi tiet tong chi phi cua moi HSBN trong nam " + namThongKe + " la");
			}
			System.out.println("----------------------------------------------------");

			for (LuaChon_6_CTCP luaChon_6 : arrayList) {

				System.out.println(luaChon_6);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
