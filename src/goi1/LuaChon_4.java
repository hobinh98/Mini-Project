package goi1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class LuaChon_4 {
	private String maBenh;
	private String tenBenh;
	private int soLuongBenhNhan;

	public LuaChon_4() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LuaChon_4(String maBenh, String tenBenh, int soLuongBenhNan) {
		super();
		this.maBenh = maBenh;
		this.tenBenh = tenBenh;
		this.soLuongBenhNhan = soLuongBenhNan;
	}

	public String getMaBenh() {
		return maBenh;
	}

	public void setMaBenh(String maBenh) {
		this.maBenh = maBenh;
	}

	public String getTenBenh() {
		return tenBenh;
	}

	public void setTenBenh(String tenBenh) {
		this.tenBenh = tenBenh;
	}

	public int getSoLuongBenhNhan() {
		return soLuongBenhNhan;
	}

	public void setSoLuongBenhNhan(int soLuongBenhNhan) {
		this.soLuongBenhNhan = soLuongBenhNhan;
	}

	@Override
	public String toString() {
		return "LuaChon4 [maBenh=" + maBenh + ", tenBenh=" + tenBenh + ", soLuongBenhNan=" + soLuongBenhNhan + "]";
	}

	public static final String sql4_1 = "SELECT B.MaBenh, B.TenBenh,COUNT(BN.MaBN) SOLUONG_BENHNHAN\r\n"
			+ "	FROM BENH_NHAN BN, HO_SO_BENH_AN HSBN, XAC_DINH_BENH XD, BENH B\r\n"
			+ "	WHERE BN.MaBN = HSBN.MaBN AND HSBN.MaHS = XD.MaHS AND XD.MaBenh = B.MaBenh AND MONTH(HSBN.NgayKham) = ?\r\n"
			+ "	GROUP BY B.MaBenh, B.TenBenh";

	public void ThongKeTongSoBN_TheoTenBenh(Connection connection, Scanner scanner) {
		String regex = "^([0-9]|1[0-2])$";
		String nhapThang = "";
		System.out.println("Nhap vao thang bat ky muon thong ke");
//		scanner.nextLine();
		do {
			System.out.println("Nhap thang: 1 --> 12");
			nhapThang = scanner.nextLine();
		} while (!nhapThang.matches(regex));

		ArrayList<LuaChon_4> thongKe = new ArrayList<LuaChon_4>();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql4_1);
			preparedStatement.setString(1, nhapThang);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String maBenhRS = resultSet.getString("MaBenh");
				String tenBenhRS = resultSet.getString("TenBenh");
				int soLuongBenhNanRS = resultSet.getInt("SOLUONG_BENHNHAN");
				LuaChon_4 chon4 = new LuaChon_4(maBenhRS, tenBenhRS, soLuongBenhNanRS);
				thongKe.add(chon4);
			}

			if (thongKe.size() == 0) {
				System.out.println("Thang ban vua nhap hien khong co so lieu nao");
			} else {
				System.out.println("Bang thong ke:");
			}
			
			System.out.println("--------------------------------------------");
			for (LuaChon_4 luaChon4 : thongKe) {
				System.out.println("Ma Benh: " + luaChon4.getMaBenh() + " --- Ten Benh: " + luaChon4.getTenBenh()
						+ " --- Tong so Benh Nhap MAC Phai: " + luaChon4.getSoLuongBenhNhan());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
