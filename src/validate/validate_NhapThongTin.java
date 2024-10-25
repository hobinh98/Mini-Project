package validate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import goi1.ConnecTion;

public class validate_NhapThongTin {

	// NHẬP HỒ SƠ
	public static String NhapMaHoSo(Scanner scanner) {
		String regex = "HS\\d{3}";
		String maHSS = "";
		boolean kiemTra = true;
		do {
			System.out.println("HS*** <-- Nhap dung dinh dang voi * la chu so bat ky");
			maHSS = scanner.nextLine();
			kiemTra = KiemTraMaHoSo(ConnecTion.connection, maHSS);
		} while (!maHSS.matches(regex) || kiemTra == true); // KIỂM TRA
		return maHSS;
	}

	public static boolean KiemTraMaHoSo(Connection connection, String layMa) {
		boolean kienTra = true;
		PreparedStatement preparedStatement = null;
		String sql1 = "select * from [HO_SO_BENH_AN] where MaHS = '" + layMa + "'";
		try {
			preparedStatement = connection.prepareStatement(sql1);
			ResultSet resultSet = preparedStatement.executeQuery();
			kienTra = resultSet.next();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return kienTra;
	}

	public static String ChonPPDieuTri(Scanner scanner) {
		System.out.println("Nhap 1 neu la DIEU TRI NOI TRU");
		System.out.println("Nhap 2 neu la DIEU TRI NGOAI TRU");
		System.out.println("Nhap 3 neu KHONG CO DIEU TRI");
		String loaiDT = "";

		int nhap = 0;
		while (true) {
			try {
//				nhapCP = Integer.parseInt(scanner.nextLine());
				nhap = scanner.nextInt();
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("ban phai nhap so");
				continue;
			}
			break;
		}

		if (nhap == 1) {
			loaiDT = "DIEU TRI NOI TRU";
		} else if (nhap == 2) {
			loaiDT = "DIEU TRI NGOAI TRU";
		} else if (nhap == 3) {
			loaiDT = "KHONG CO DIEU TRI";
		}
		System.out.println("--> Ban da chon " + loaiDT);

		return loaiDT;
	}

	// NHẬP GIỜ
	public static String NhapGio(Scanner scanner) {
		String regex1 = "^(0[7-9]|[7-9]|10):([0-9]|[1-5][0-9])$"; // 7:00 - 10:59
		String regex2 = "^11:([0-9]|[1-2][0-9]|30)$";
		String regex3 = "^(1[3-6]):([0-9]|[1-5][0-9])$"; // 7:00 - 10:59
		String regex4 = "^17:([0-9]|[1-2][0-9]|30)$";
		String nhapGio = "";
		do {
			System.out.println("Nhap theo gio hanh trinh 7h00-11h30 hoac 13h00-17h30");
			nhapGio = scanner.nextLine();
		} while (!nhapGio.matches(regex1) && !nhapGio.matches(regex2) && !nhapGio.matches(regex3)
				&& !nhapGio.matches(regex4)); // KIỂM TRA
		return nhapGio;
	}

	// NHẬP NGÀY THÁNG NĂM
	public static String NhapNgayThangNam(Scanner scanner) {
		String regex1 = "^([0-9][0-9][0-9][0-9])-(1|01)-([1-9]|0[1-9]|[1-2][0-9]|3[0-1])$";
		String regex2 = "^([0-9][0-9][0-9][0-9])-(2|02)-([1-9]|0[1-9]|[1-2][0-8])$";
		String regex3 = "^([0-9][0-9][0-9][0-9])-(3|03)-([1-9]|0[1-9]|[1-2][0-9]|3[0-1])$";
		String regex4 = "^([0-9][0-9][0-9][0-9])-(4|04)-([1-9]|0[1-9]|[1-2][0-9]|30)$";
		String regex5 = "^([0-9][0-9][0-9][0-9])-(5|05)-([1-9]|0[1-9]|[1-2][0-9]|3[0-1])$";
		String regex6 = "^([0-9][0-9][0-9][0-9])-(6|06)-([1-9]|0[1-9]|[1-2][0-9]|30)$";
		String regex7 = "^([0-9][0-9][0-9][0-9])-(7|07)-([1-9]|0[1-9]|[1-2][0-9]|3[0-1])$";
		String regex8 = "^([0-9][0-9][0-9][0-9])-(8|08)-([1-9]|0[1-9]|[1-2][0-9]|3[0-1])$";
		String regex9 = "^([0-9][0-9][0-9][0-9])-(9|09)-([1-9]|0[1-9]|[1-2][0-9]|30)$";
		String regex10 = "^([0-9][0-9][0-9][0-9])-10-([1-9]|0[1-9]|[1-2][0-9]|3[0-1])$";
		String regex11 = "^([0-9][0-9][0-9][0-9])-11-([1-9]|0[1-9]|[1-2][0-9]|30)$";
		String regex12 = "^([0-9][0-9][0-9][0-9])-12-([1-9]|0[1-9]|[1-2][0-9]|3[0-1])$";

		String nhapNgay = "";
		do {
			System.out.println("Nhap theo dinh dang: yyyy-mm-dd");
			nhapNgay = scanner.nextLine();
		} while (!nhapNgay.matches(regex1) && !nhapNgay.matches(regex2) && !nhapNgay.matches(regex3)
				&& !nhapNgay.matches(regex4) && !nhapNgay.matches(regex5) && !nhapNgay.matches(regex6)
				&& !nhapNgay.matches(regex7) && !nhapNgay.matches(regex8) && !nhapNgay.matches(regex9)
				&& !nhapNgay.matches(regex10) && !nhapNgay.matches(regex11) && !nhapNgay.matches(regex12)); // KIỂM TRA
		return nhapNgay;

	}

	// NHẬP SỐ --> EXCEPTION KHI NHẬP CHỮ
	public static float NhapChiPhiKham(Scanner scanner) {
		float nhapCP = 0f;
		while (true) {
			try {
//				nhapCP = Integer.parseInt(scanner.nextLine());
				nhapCP = scanner.nextFloat();
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("ban phai nhap so");
				continue;
			}
			break;
		}
		return nhapCP;
	}
	
	public static int NhapKey(Scanner scanner) {
		String regex_key = "^[1-8]$";
		String nhapKey = "";
//		scanner.nextLine();
		do {
			System.out.println("Nhap 1 --> 8");
			nhapKey = scanner.nextLine();
		}while(!nhapKey.matches(regex_key));
		
		int key = Integer.parseInt(nhapKey);
		
		return key;
	}
	
	public static final String sqsT1 = "SELECT TOP 1 * FROM HO_SO_BENH_AN";

	public static boolean CoTop1(Connection connection) {
		boolean traBoolean = false;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sqsT1);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			traBoolean = resultSet.next();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return traBoolean;
	}
}
