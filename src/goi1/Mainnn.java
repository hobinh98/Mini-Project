package goi1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import validate.validate_NhapThongTin;

public class Mainnn {
	public static Scanner scanner = new Scanner(System.in);
	public static final Date ngayHienTai = Date.valueOf("2023-10-17");
	public static ArrayList<HO_SO_BENH_AN> ans = new ArrayList<HO_SO_BENH_AN>();

	public static void main(String[] args) {

		ConnecTion.Connectionn();

		int key = 0;
		try {
			do {
				System.out.println();
				System.out.println("============================================================");
				System.out.println("Chao mung ban den voi chuong trinh quan ly sanpham cua thuoc");
				System.out.println("------------------------------------------------------------");
				System.out.println(
						"1. Them moi Ho So Benh An\n" + "2. Update Ho So Benh An\n" + "3. Xoa thong tin Ho So Benh An\n"
								+ "4. Thong ke so luong BN tuong ung tung loai BENH den kham theo tung thang Y\n"
								+ "5. Thong ke khung gio kham co so BN kham nhieu nhat theo tung thang Y\n"
								+ "6. Thong ke Tong so BENH AN va Tong chi phi theo tung Thang trong Nam X\n"
								+ "7. Tim kiem Ho So Benh An theo ten BN Bat Ky\n" + "8. Thoat khoi chuong trinh\n");
				System.out.println("------------------------------------------------------------");
				System.out.println("Xin moi chon chuc nang:");

				key = validate_NhapThongTin.NhapKey(scanner);

				boolean coTop1 = false;
				coTop1 = validate_NhapThongTin.CoTop1(ConnecTion.connection);

				switch (key) {
				case 1: {
					HO_SO_BENH_AN an = new HO_SO_BENH_AN();
					an.NhapThuocTinh(scanner);
					an.insertSQL(ConnecTion.connection);
					System.out.println();
					System.out.println("Thng tin HO SO BENH AN ban vua them");
					System.out.println(an);
					break;
				}
				case 2: {
					if (!coTop1) {
						System.out.println("Hien chua co thong tin nhap, vui long truy cap lai sau");
						break;
					}

					HO_SO_BENH_AN an = new HO_SO_BENH_AN();
					an.UpdateTT(ConnecTion.connection, scanner);

					break;
				}
				case 3: {
					if (!coTop1) {
						System.out.println("Hien chua co thong tin nhap, vui long truy cap lai sau");
						break;
					}

					HO_SO_BENH_AN an = new HO_SO_BENH_AN();
					an.XoaThongTinBenhAn(ConnecTion.connection, scanner);

					break;
				}
				case 4: {
					if (!coTop1) {
						System.out.println("Hien chua co thong tin nhap, vui long truy cap lai sau");
						break;
					}

					LuaChon_4 chon4 = new LuaChon_4();
					chon4.ThongKeTongSoBN_TheoTenBenh(ConnecTion.connection, scanner);

					break;
				}
				case 5: {
					if (!coTop1) {
						System.out.println("Hien chua co thong tin nhap, vui long truy cap lai sau");
						break;
					}

					HO_SO_BENH_AN an = new HO_SO_BENH_AN();
					an.ThongKeTheoGio(ConnecTion.connection, scanner);

					break;
				}
				case 6: {
					if (!coTop1) {
						System.out.println("Hien chua co thong tin nhap, vui long truy cap lai sau");
						break;
					}

					String regex = "^([0-9][0-9][0-9][0-9])$";
					String namThongKe = "";
					System.out.println("Nhap nam muon thong ke: ");
//					scanner.nextLine();
					do {
						namThongKe = scanner.nextLine();
					} while (!namThongKe.matches(regex));

					LuaChon_6 chon_6 = new LuaChon_6();
					chon_6.ThongKe(ConnecTion.connection, scanner, namThongKe);
					chon_6.ChiTiet_TongChiPhi(ConnecTion.connection, scanner, namThongKe);

					break;
				}
				case 7: {
					if (!coTop1) {
						System.out.println("Hien chua co thong tin nhap, vui long truy cap lai sau");
						break;
					}

					LuaChon_7 chon_7 = new LuaChon_7();
					chon_7.TimKiem_TenBN_BatKy(ConnecTion.connection, scanner);

					break;
				}
				case 8:

					break;
				}

			} while (key != 8);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		ConnecTion.Close();
	}
}
