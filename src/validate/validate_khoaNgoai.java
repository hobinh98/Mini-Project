package validate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import goi1.ConnecTion;

public class validate_khoaNgoai {

	public static String sql_BN = "select * from [BENH_NHAN] where MaBN = ?";
	public static String sql_BS = "select * from [BAC_SI] where MaBS = ?";
	
	public static String sql_NT1 = "select * from [THONG_TIN_NOI_TRU] where MaNT = ?";
	public static String sql_NT2 = "select * from [HO_SO_BENH_AN] where MaNT = ?";
	
	public static String sql_DT1 = "select * from [DIEU_TRI] where MaDT = ?";
	public static String sql_DT2 = "select * from [HO_SO_BENH_AN] where MaDT = ?";
	

	public static String regex_BN = "BN\\d{3}";
	public static String regex_BS = "BS\\d{3}";
	public static String regex_NT = "NT\\d{3}";
	public static String regex_DT = "DT\\d{3}";

	// MÃ BÁC SĨ - BỆNH NHÂN
	public static String NhapMaKhoaNgoai(Scanner scanner, String regex, String lenhSQL) {
		String maKhoaNgoai = "";
		boolean kiemTra = false;
		do {
			System.out.println("Day la du lieu co khoa ngoai, hay nhap dung du lieu tham chieu");
			maKhoaNgoai = scanner.nextLine();
			kiemTra = KiemTraMaKhoaNgoai(ConnecTion.connection, maKhoaNgoai, lenhSQL);
		} while (!maKhoaNgoai.matches(regex) || kiemTra == false); // KIỂM TRA

		return maKhoaNgoai;
	}

	public static boolean KiemTraMaKhoaNgoai(Connection connection, String maKhoaNgoai, String lenhSQL) {
		boolean kienTra = false;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(lenhSQL);
			preparedStatement.setString(1, maKhoaNgoai);

			ResultSet resultSet = preparedStatement.executeQuery();
			kienTra = resultSet.next();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return kienTra;
	}
	
	// MÃ NỘI TRÚ - ĐIỀU TRỊ
	public static String NhapMaKhoaNgoaiKhongTrung(Scanner scanner, String regex, String lenhSQL1, String lenhSQL2) {
		String maKhoaNgoai = "";
		boolean kiemTra1 = false;
		boolean kiemTra2 = true;
		do {
			System.out.println("Day la du lieu co khoa ngoai, hay nhap dung du lieu tham chieu");
			System.out.println("Khong duoc nhap CAC MA ma cac HO SO BENH AN khac da Su Dung");
			maKhoaNgoai = scanner.nextLine();
			kiemTra1 = KiemTraMaKhoaNgoaiDaCo(ConnecTion.connection, maKhoaNgoai, lenhSQL1);
			kiemTra2 = KiemTraMaKhoaNgoaiKhongTrung(ConnecTion.connection, maKhoaNgoai, lenhSQL2);
		} while (!maKhoaNgoai.matches(regex) || kiemTra1 == false || kiemTra2 == true); // KIỂM TRA

		return maKhoaNgoai;
	}

	public static boolean KiemTraMaKhoaNgoaiDaCo(Connection connection, String maKhoaNgoai, String lenhSQL1) {
		boolean kienTra = false;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(lenhSQL1);
			preparedStatement.setString(1, maKhoaNgoai);

			ResultSet resultSet = preparedStatement.executeQuery();
			kienTra = resultSet.next();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return kienTra;
	}
	
	public static boolean KiemTraMaKhoaNgoaiKhongTrung(Connection connection, String maKhoaNgoai, String lenhSQL2) {
		boolean kienTra = true;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(lenhSQL2);
			preparedStatement.setString(1, maKhoaNgoai);

			ResultSet resultSet = preparedStatement.executeQuery();
			kienTra = resultSet.next();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return kienTra;
	}
}
