package goi1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

import validate.validate_NhapThongTin;
import validate.validate_khoaNgoai;

public class HO_SO_BENH_AN {
	private String maHS;
	private String tinhTrang;
	private String ppDieuTri;
	private Time gioKham;
	private Date ngayKham;
	private Date ngayHenTaiKham;
	private float chiPhiKhamBenh;
	private String maBN;
	private String maBS;
	private String maNT;
	private String maDT;

	public HO_SO_BENH_AN() {
	}

	public HO_SO_BENH_AN(String maHS, String tinhTrang, String ppDieuTri, Time gioKham, Date ngayKham,
			Date ngayHenTaiKham, float chiPhiKhamBenh, String maBN, String maBS, String maNT, String maDT) {
		super();
		this.maHS = maHS;
		this.tinhTrang = tinhTrang;
		this.ppDieuTri = ppDieuTri;
		this.gioKham = gioKham;
		this.ngayKham = ngayKham;
		this.ngayHenTaiKham = ngayHenTaiKham;
		this.chiPhiKhamBenh = chiPhiKhamBenh;
		this.maBN = maBN;
		this.maBS = maBS;
		this.maNT = maNT;
		this.maDT = maDT;
	}

	public String getMaHS() {
		return maHS;
	}

	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getPpDieuTri() {
		return ppDieuTri;
	}

	public void setPpDieuTri(String ppDieuTri) {
		this.ppDieuTri = ppDieuTri;
	}

	public Time getGioKham() {
		return gioKham;
	}

	public void setGioKham(Time gioKham) {
		this.gioKham = gioKham;
	}

	public Date getNgayKham() {
		return ngayKham;
	}

	public void setNgayKham(Date ngayKham) {
		this.ngayKham = ngayKham;
	}

	public Date getNgayHenTaiKham() {
		return ngayHenTaiKham;
	}

	public void setNgayHenTaiKham(Date ngayHenTaiKham) {
		this.ngayHenTaiKham = ngayHenTaiKham;
	}

	public float getChiPhiKhamBenh() {
		return chiPhiKhamBenh;
	}

	public void setChiPhiKhamBenh(float chiPhiKhamBenh) {
		this.chiPhiKhamBenh = chiPhiKhamBenh;
	}

	public String getMaBN() {
		return maBN;
	}

	public void setMaBN(String maBN) {
		this.maBN = maBN;
	}

	public String getMaBS() {
		return maBS;
	}

	public void setMaBS(String maBS) {
		this.maBS = maBS;
	}

	public String getMaNT() {
		return maNT;
	}

	public void setMaNT(String maNT) {
		this.maNT = maNT;
	}

	public String getMaDT() {
		return maDT;
	}

	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}

	@Override
	public String toString() {
		return "HO_SO_BENH_AN [maHS=" + maHS + ", tinhTrang=" + tinhTrang + ", ppDieuTri=" + ppDieuTri + ", gioKham="
				+ gioKham + ", ngayKham=" + ngayKham + ", ngayHenTaiKham=" + ngayHenTaiKham + ", chiPhiKhamBenh="
				+ chiPhiKhamBenh + ", maBN=" + maBN + ", maBS=" + maBS + ", maNT=" + maNT + ", maDT=" + maDT + "]";
	}

	public void NhapThuocTinh(Scanner scanner) {
		System.out.println("1. Nhap ma ho so");
//		scanner.nextLine();
		String maHSS = validate_NhapThongTin.NhapMaHoSo(scanner);

		System.out.println("2. Tinh trang benh nhan");
		String tinhTrangS = "";
		do {
			tinhTrangS = scanner.nextLine();
		} while (tinhTrangS.length() > 250);

		System.out.println("3. Phuong phap dieu tri");
		String ppDieuTriS = validate_NhapThongTin.ChonPPDieuTri(scanner);

		System.out.println("4. Gio kham theo hh:mm:ss");
		String gioKhamS = validate_NhapThongTin.NhapGio(scanner);
		String gioKhamSS = gioKhamS + ":00";
		Time gioKhamT = Time.valueOf(gioKhamSS);

		System.out.println("5. Nhap ngay kham");
		String ngayKhamS = validate_NhapThongTin.NhapNgayThangNam(scanner);
		Date ngayKhamD = Date.valueOf(ngayKhamS);

		System.out.println("6. Nhap ngay hen tai kham");
		Date ngayHienTaiKhamD;
		do {
			System.out.println("Luu Y: Ngay Hen Tai Kham Phai SAU Ngay Kham");
			String ngayHienTaiKhamS = validate_NhapThongTin.NhapNgayThangNam(scanner);
			ngayHienTaiKhamD = Date.valueOf(ngayHienTaiKhamS);
		} while (ngayKhamD.after(ngayHienTaiKhamD));

		System.out.println("7. Chi phi kham benh");
		float chiPhiKhamBenhS = validate_NhapThongTin.NhapChiPhiKham(scanner);

		System.out.println("8. Them MA BENH NHAN vua kham");
		scanner.nextLine();
		String maBNs = validate_khoaNgoai.NhapMaKhoaNgoai(scanner, validate_khoaNgoai.regex_BN,
				validate_khoaNgoai.sql_BN);

		System.out.println("9. Them MA BAC SI vua kham cho MA BENH NHAN nhap tren");
		String maBSs = validate_khoaNgoai.NhapMaKhoaNgoai(scanner, validate_khoaNgoai.regex_BS,
				validate_khoaNgoai.sql_BS);

		String maNTs = "";
		String maDTs = "";

		if (ppDieuTriS.equals("DIEU TRI NOI TRU")) {
			System.out.println("10. Them MA Ma NOI TRU tuong ung voi HO SO vua kham");
			maNTs = validate_khoaNgoai.NhapMaKhoaNgoaiKhongTrung(scanner, validate_khoaNgoai.regex_NT,
					validate_khoaNgoai.sql_NT1, validate_khoaNgoai.sql_NT2);
		} else {
			maNTs = null;
		}

		if (ppDieuTriS.equals("DIEU TRI NOI TRU") || ppDieuTriS.equals("DIEU TRI NGOAI TRU")) {
			System.out.println("11. Them MA DIEU TRI tuong ung voi HO SO vua kham");
			maDTs = validate_khoaNgoai.NhapMaKhoaNgoaiKhongTrung(scanner, validate_khoaNgoai.regex_DT,
					validate_khoaNgoai.sql_DT1, validate_khoaNgoai.sql_DT2);
		} else {
			maDTs = null;
		}

		setMaHS(maHSS);
		setTinhTrang(tinhTrangS);
		setPpDieuTri(ppDieuTriS);
		setGioKham(gioKhamT);
		setNgayKham(ngayKhamD);
		setNgayHenTaiKham(ngayHienTaiKhamD);
		setChiPhiKhamBenh(chiPhiKhamBenhS);
		setMaBN(maBNs);
		setMaBS(maBSs);
		setMaNT(maNTs);
		setMaDT(maDTs);

	}

	public static final String sql1 = "INSERT INTO HO_SO_BENH_AN (MaHS, TinhTrang, PPDieuTri, GioKham, NgayKham, NgayHenTaiKham, ChiPhiKhamBenh, MaBN, MaBS, MaNT, MaDT) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

	public void insertSQL(Connection connection) {
		PreparedStatement preparedStatement2 = null;
		try {
			preparedStatement2 = connection.prepareStatement(sql1);

			preparedStatement2.setString(1, getMaHS());
			preparedStatement2.setString(2, getTinhTrang());
			preparedStatement2.setString(3, getPpDieuTri());
			preparedStatement2.setTime(4, getGioKham());
			preparedStatement2.setDate(5, getNgayKham());
			preparedStatement2.setDate(6, getNgayHenTaiKham());
			preparedStatement2.setFloat(7, getChiPhiKhamBenh());
			preparedStatement2.setString(8, getMaBN());
			preparedStatement2.setString(9, getMaBS());
			preparedStatement2.setString(10, getMaNT());
			preparedStatement2.setString(11, getMaDT());

			int i = preparedStatement2.executeUpdate();
			if (i > 0) {
				System.out.println("Them thong tin thanh cong");
				HO_SO_BENH_AN an = new HO_SO_BENH_AN();
				System.out.println(an);
			} else {
				System.out.println("Them thong tin that bai");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public static final String sql2a = "SELECT *  FROM HO_SO_BENH_AN where MaHS = ?";
	public static final String sql2_1 = "UPDATE HO_SO_BENH_AN SET TinhTrang = ?  WHERE MaHS = ?";
	public static final String sql2_2_1 = "UPDATE HO_SO_BENH_AN SET PPDieuTri = ?  WHERE MaHS = ?";
	public static final String sql2_2_2 = "UPDATE HO_SO_BENH_AN SET MaNT = ?  WHERE MaHS = ?";
	public static final String sql2_2_3 = "UPDATE HO_SO_BENH_AN SET MaDT = ?  WHERE MaHS = ?";
	public static final String sql2_3_1 = "UPDATE HO_SO_BENH_AN SET NgayKham = ?  WHERE MaHS = ?";
	public static final String sql2_3_2 = "UPDATE HO_SO_BENH_AN SET NgayHenTaiKham = ?  WHERE MaHS = ?";
	public static final String sql2_4 = "UPDATE HO_SO_BENH_AN SET ChiPhiKhamBenh = ?  WHERE MaHS = ?";
	public static final String sql2_5 = "UPDATE HO_SO_BENH_AN SET MaBN = ?  WHERE MaHS = ?";
	public static final String sql2_6 = "UPDATE HO_SO_BENH_AN SET MaBS = ?  WHERE MaHS = ?";

	public void UpdateTT(Connection connection, Scanner scanner) {
		PreparedStatement preparedStatement = null;
		try {
			System.out.println("Nhap ma ho so Update");

			String regex = "HS\\d{3}";
			String maHSUD = "";
//			scanner.nextLine();
			do {
				System.out.println("HS*** <-- Nhap dung dinh dang voi * la chu so bat ky");
				maHSUD = scanner.nextLine();
			} while (!maHSUD.matches(regex)); // KIỂM TRA

			preparedStatement = connection.prepareStatement(sql2a);
			preparedStatement.setString(1, maHSUD);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				int key = 0;
				do {
					System.out.println("Chon thong tin ban muon thay doi");
					System.out.println("1. Thay doi Tinh trang suc khoe\n" + "2. Thay doi Phuong phap dieu tri\n"
							+ "3. Thay doi Ngay hen tai kham\n" + "4. Thay doi Chi phi kham benh\n"
							+ "5. Cap nhap lai Ma BENH NHAN\n" + "6. Cap nhap lai Ma BAC SI\n" + "7. Thoat\n");

					while (true) {
						try {
							key = scanner.nextInt();
						} catch (Exception e) {
							scanner.nextLine();
							System.out.println("ban phai nhap so");
							continue;
						}
						break;
					}

					switch (key) {
					case 1: {
						System.out.println("Nhap vao tinh trang suc khoe muon thay doi");
						String tinhTrangS = "";
						scanner.nextLine();
						do {
							tinhTrangS = scanner.nextLine();
						} while (tinhTrangS.length() > 250);

						PreparedStatement preparedStatement2 = null;
						preparedStatement2 = connection.prepareStatement(sql2_1);
						preparedStatement2.setString(1, tinhTrangS);
						preparedStatement2.setString(2, maHSUD);

						int i = preparedStatement2.executeUpdate();
						if (i > 0) {
							System.out.println("UpDate tinh trang suc khoe voi Ma ho so " + maHSUD + " thang cong");
						} else {
							System.out.println("UpDate tinh trang suc khoe voi Ma ho so " + maHSUD + " that bai");
						}
						break;
					}
					case 2: {
						System.out.println("Chon Phuong phap dieu tri muon thay doi");
						String ppDieuTriS = validate_NhapThongTin.ChonPPDieuTri(scanner);

						String maNTs = "";
						String maDTs = "";
						scanner.nextLine();
						if (ppDieuTriS.equals("DIEU TRI NOI TRU")) {
							System.out.println("Cap nhap Them MA Ma NOI TRU tuong ung voi HO SO BN");
							maNTs = validate_khoaNgoai.NhapMaKhoaNgoaiKhongTrung(scanner, validate_khoaNgoai.regex_NT,
									validate_khoaNgoai.sql_NT1, validate_khoaNgoai.sql_NT2);
						} else {
							maNTs = null;
						}

						if (ppDieuTriS.equals("DIEU TRI NOI TRU") || ppDieuTriS.equals("DIEU TRI NGOAI TRU")) {
							System.out.println("Cap nhap Them MA DIEU TRI tuong ung voi HO SO BN");
							maDTs = validate_khoaNgoai.NhapMaKhoaNgoaiKhongTrung(scanner, validate_khoaNgoai.regex_DT,
									validate_khoaNgoai.sql_DT1, validate_khoaNgoai.sql_DT2);
						} else {
							maDTs = null;
						}

						PreparedStatement preparedStatement2 = null;
						preparedStatement2 = connection.prepareStatement(sql2_2_1);
						preparedStatement2.setString(1, ppDieuTriS);
						preparedStatement2.setString(2, maHSUD);

						int i2 = preparedStatement2.executeUpdate();
						if (i2 > 0) {
							System.out.println("UpDate Phuong phap dieu tri voi Ma ho so " + maHSUD + " thang cong");
						} else {
							System.out.println("UpDate Phuong phap dieu tri voi Ma ho so " + maHSUD + " that bai");
						}

						if (ppDieuTriS.equals("DIEU TRI NOI TRU")) {
							PreparedStatement preparedStatement3 = null;
							preparedStatement3 = connection.prepareStatement(sql2_2_2);
							preparedStatement3.setString(1, maNTs);
							preparedStatement3.setString(2, maHSUD);

							int i3 = preparedStatement3.executeUpdate();
							if (i3 > 0) {
								System.out.println("UpDate Ma Noi Tru voi Ma ho so " + maHSUD + " thang cong");
							} else {
								System.out.println("UpDate Ma Noi Tru voi Ma ho so " + maHSUD + " that bai");
							}
						} else {
							PreparedStatement preparedStatement3_1 = null;
							preparedStatement3_1 = connection.prepareStatement(sql2_2_2);
							preparedStatement3_1.setString(1, maNTs);
							preparedStatement3_1.setString(2, maHSUD);

							int i3 = preparedStatement3_1.executeUpdate();
							if (i3 > 0) {
								System.out.println("UpDate Ma Noi Tru voi Ma ho so " + maHSUD + " thang cong");
							} else {
								System.out.println("UpDate Ma Noi Tru voi Ma ho so " + maHSUD + " that bai");
							}
						}

						if (ppDieuTriS.equals("DIEU TRI NOI TRU") || ppDieuTriS.equals("DIEU TRI NGOAI TRU")) {
							PreparedStatement preparedStatement4 = null;
							preparedStatement4 = connection.prepareStatement(sql2_2_3);
							preparedStatement4.setString(1, maDTs);
							preparedStatement4.setString(2, maHSUD);

							int i3 = preparedStatement4.executeUpdate();
							if (i3 > 0) {
								System.out.println("UpDate Ma Dieu Tri voi Ma ho so " + maHSUD + " thang cong");
							} else {
								System.out.println("UpDate Ma Dieu Tri voi Ma ho so " + maHSUD + " that bai");
							}
						} else {
							PreparedStatement preparedStatement4_1 = null;
							preparedStatement4_1 = connection.prepareStatement(sql2_2_3);
							preparedStatement4_1.setString(1, maDTs);
							preparedStatement4_1.setString(2, maHSUD);

							int i3 = preparedStatement4_1.executeUpdate();
							if (i3 > 0) {
								System.out.println("UpDate Ma Dieu Tri voi Ma ho so " + maHSUD + " thang cong");
							} else {
								System.out.println("UpDate Ma Dieu Tri voi Ma ho so " + maHSUD + " that bai");
							}
						}

						break;
					}
					case 3: {
						System.out.println("5. Nhap ngay kham");
						String ngayKhamS = validate_NhapThongTin.NhapNgayThangNam(scanner);
						Date ngayKhamD = Date.valueOf(ngayKhamS);

						System.out.println("6. Nhap ngay hen tai kham");
						Date ngayHienTaiKhamD;
						do {
							System.out.println("Luu Y: Ngay Hen Tai Kham Phai SAU Ngay Kham");
							String ngayHienTaiKhamS = validate_NhapThongTin.NhapNgayThangNam(scanner);
							ngayHienTaiKhamD = Date.valueOf(ngayHienTaiKhamS);
						} while (ngayKhamD.after(ngayHienTaiKhamD));

						PreparedStatement preparedStatement2 = null;
						preparedStatement2 = connection.prepareStatement(sql2_3_1);
						preparedStatement2.setDate(1, ngayKhamD);
						preparedStatement2.setString(2, maHSUD);

						int i1 = preparedStatement2.executeUpdate();
						if (i1 > 0) {
							System.out.println("UpDate ngay kham voi Ma ho so " + maHSUD + " thang cong");

							PreparedStatement preparedStatement3 = null;
							preparedStatement3 = connection.prepareStatement(sql2_3_2);
							preparedStatement3.setDate(1, ngayHienTaiKhamD);
							preparedStatement3.setString(2, maHSUD);

							int i2 = preparedStatement3.executeUpdate();
							if (i2 > 0) {
								System.out.println("UpDate ngay hen tai kham voi Ma ho so " + maHSUD + " thang cong");
							} else {
								System.out.println("UpDate ngay hen tai kham voi Ma ho so " + maHSUD + " that bai");
							}
						} else {
							System.out.println("UpDate ngay kham voi Ma ho so " + maHSUD + " that bai");
						}
						break;
					}
					case 4: {
						System.out.println("Nhap vao chi phi Kham benh muon thay doi");
						float chiPhiKhamBenhS = validate_NhapThongTin.NhapChiPhiKham(scanner);

						PreparedStatement preparedStatement2 = null;
						preparedStatement2 = connection.prepareStatement(sql2_4);
						preparedStatement2.setFloat(1, chiPhiKhamBenhS);
						preparedStatement2.setString(2, maHSUD);

						int i = preparedStatement2.executeUpdate();
						if (i > 0) {
							System.out.println("UpDate chi phi Kham benh voi Ma ho so " + maHSUD + " thang cong");
						} else {
							System.out.println("UpDate chi phi Kham benh voi Ma ho so " + maHSUD + " that bai");
						}
						break;
					}
					case 5: {
						System.out.println("Thay doi Ma BENH NHAN");
						String maBNThayDoi = validate_khoaNgoai.NhapMaKhoaNgoai(scanner, validate_khoaNgoai.regex_BN,
								validate_khoaNgoai.sql_BN);

						PreparedStatement preparedStatement2 = null;
						preparedStatement2 = connection.prepareStatement(sql2_5);
						preparedStatement2.setString(1, maBNThayDoi);
						preparedStatement2.setString(2, maHSUD);

						int i = preparedStatement2.executeUpdate();
						if (i > 0) {
							System.out.println(
									"UpDate MA BENH NHAN muon cap nhap voi Ma ho so " + maHSUD + " thang cong");
						} else {
							System.out
									.println("UpDate MA BENH NHAN muon cap nhap voi Ma ho so " + maHSUD + " that bai");
						}
						break;
					}
					case 6: {
						System.out.println("Thay doi Ma BAC SI");
						String maBSThayDoi = validate_khoaNgoai.NhapMaKhoaNgoai(scanner, validate_khoaNgoai.regex_BS,
								validate_khoaNgoai.sql_BS);

						PreparedStatement preparedStatement2 = null;
						preparedStatement2 = connection.prepareStatement(sql2_6);
						preparedStatement2.setString(1, maBSThayDoi);
						preparedStatement2.setString(2, maHSUD);

						int i = preparedStatement2.executeUpdate();
						if (i > 0) {
							System.out.println("UpDate MA BAC SI muon cap nhap voi Ma ho so " + maHSUD + " thang cong");
						} else {
							System.out.println("UpDate MA BAC SI muon cap nhap voi Ma ho so " + maHSUD + " that bai");
						}
						break;
					}
					case 7:
						break;

					}
				} while (key != 6);

			} else {
				System.out.println("Hien khong co ma Ho So theo dieu kien cua ban");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public static String sql_HS = "select * from HO_SO_BENH_AN where MaHS = ?";
	public static String sql_XDB = "select * from XAC_DINH_BENH where MaHS = ?";

	public static String sql_xoa_1 = "DELETE FROM XAC_DINH_BENH WHERE MaHS = ?";
	public static String sql_xoa_2 = "DELETE FROM HO_SO_BENH_AN WHERE MaHS = ?";

	public static String sql_xoa_3 = "DELETE FROM BAC_SI_NOI_TRU WHERE MaNT = ?";
	public static String sql_xoa_4 = "DELETE FROM Y_TA_NOI_TRU WHERE MaNT = ?";
	public static String sql_xoa_5 = "DELETE FROM THONG_TIN_NOI_TRU WHERE MaNT = ?";
	public static String sql_xoa_6 = "DELETE FROM DIEU_TRI_THUOC WHERE MaDT = ?";
	public static String sql_xoa_7 = "DELETE FROM DIEU_TRI WHERE MaDT = ?";

	public void XoaThongTinBenhAn(Connection connection, Scanner scanner) {
		try {
			System.out.println("Nhap vao Ma Ho So ban muon xoa");
			String regex = "HS\\d{3}";
			String nhapMaXoa = "";

//			scanner.nextLine();
			do {
				System.out.println("HS*** <-- Nhap dung dinh dang voi * la chu so bat ky");
				nhapMaXoa = scanner.nextLine();
			} while (!nhapMaXoa.matches(regex)); // KIỂM TRA

			PreparedStatement preparedStatement1 = null;
			preparedStatement1 = connection.prepareStatement(sql_HS);
			preparedStatement1.setString(1, nhapMaXoa);
			ResultSet resultSet1 = preparedStatement1.executeQuery();

			String ppDieuTri_RS = "";
			String maNT_RS = "";
			String maDT_RS = "";

			Loop: if (resultSet1.next()) {
				ppDieuTri_RS = resultSet1.getString("PPDieuTri");
				maNT_RS = resultSet1.getString("MaNT");
				maDT_RS = resultSet1.getString("MaDT");
//				if (ppDieuTri_RS.equals("DIEU TRI NOI TRU")) {
//				if (ppDieuTri_RS.equals("DIEU TRI NGOAI TRU")) {

				PreparedStatement preparedStatement2 = null;
				preparedStatement2 = connection.prepareStatement(sql_XDB);
				preparedStatement2.setString(1, nhapMaXoa);
				ResultSet resultSet2 = preparedStatement2.executeQuery();

				if (resultSet2.next()) {
					System.out.println(
							"Neu xoa Ma Ho So Ban Vua Nhap thi se xoa luon Thong Tin cua Ma do trong BANG XAC_DINH_BENH");
					System.out.println("Ban co DONG Y xoa");
					System.out.println("Nhap 1 --> neu Dong Y");
					System.out.println("Nhap Khac -->neu KHONG Dong Y va THOAT chuong trinh XOA HS BENH AN");

					String nhap = scanner.nextLine();

					if (nhap.equals("1")) {
						PreparedStatement preparedStatement3 = null;
						preparedStatement3 = connection.prepareStatement(sql_xoa_1);
						preparedStatement3.setString(1, nhapMaXoa);
						int sql3 = preparedStatement3.executeUpdate();

						if (sql3 > 0) {
							PreparedStatement preparedStatement4 = null;
							preparedStatement4 = connection.prepareStatement(sql_xoa_2);
							preparedStatement4.setString(1, nhapMaXoa);
							int sql4 = preparedStatement4.executeUpdate();

							if (sql4 > 0) {
								System.out.println("Xoa thong tin HSBN thanh cong");
							} else {
								System.out.println("Xoa thong tin HSBN that bai");
							}
						}
					} else {
						break Loop;
					}
				} else {
					PreparedStatement preparedStatement5 = null;
					preparedStatement5 = connection.prepareStatement(sql_xoa_2);
					preparedStatement5.setString(1, nhapMaXoa);
					int sql5 = preparedStatement5.executeUpdate();
					if (sql5 > 0) {
						System.out.println("Xoa thong tin HSBN thanh cong");
					} else {
						System.out.println("Xoa thong tin HSBN that bai");
					}
				}

				if (ppDieuTri_RS.equals("DIEU TRI NOI TRU")) {
					{
						PreparedStatement preparedStatement6 = null;
						preparedStatement6 = connection.prepareStatement(sql_xoa_3);
						preparedStatement6.setString(1, maNT_RS);
						int sql5 = preparedStatement6.executeUpdate();
						if (sql5 > 0) {
							System.out.println("Xoa thong tin BAC_SI_NOI_TRU thanh cong");
						} else {
							System.out.println("Xoa thong tin BAC_SI_NOI_TRU that bai");
						}
					}
					{
						PreparedStatement preparedStatement6 = null;
						preparedStatement6 = connection.prepareStatement(sql_xoa_4);
						preparedStatement6.setString(1, maNT_RS);
						int sql5 = preparedStatement6.executeUpdate();
						if (sql5 > 0) {
							System.out.println("Xoa thong tin Y_TA_NOI_TRU thanh cong");
						} else {
							System.out.println("Xoa thong tin Y_TA_NOI_TRU that bai");
						}
					}
					{
						PreparedStatement preparedStatement6 = null;
						preparedStatement6 = connection.prepareStatement(sql_xoa_5);
						preparedStatement6.setString(1, maNT_RS);
						int sql5 = preparedStatement6.executeUpdate();
						if (sql5 > 0) {
							System.out.println("Xoa thong tin THONG_TIN_NOI_TRU thanh cong");
						} else {
							System.out.println("Xoa thong tin THONG_TIN_NOI_TRU that bai");
						}
					}
					{
						PreparedStatement preparedStatement6 = null;
						preparedStatement6 = connection.prepareStatement(sql_xoa_6);
						preparedStatement6.setString(1, maDT_RS);
						int sql5 = preparedStatement6.executeUpdate();
						if (sql5 > 0) {
							System.out.println("Xoa thong tin DIEU_TRI_THUOC thanh cong");
						} else {
							System.out.println("Xoa thong tin DIEU_TRI_THUOC that bai");
						}
					}
					{
						PreparedStatement preparedStatement6 = null;
						preparedStatement6 = connection.prepareStatement(sql_xoa_7);
						preparedStatement6.setString(1, maDT_RS);
						int sql5 = preparedStatement6.executeUpdate();
						if (sql5 > 0) {
							System.out.println("Xoa thong tin DIEU_TRI thanh cong");
						} else {
							System.out.println("Xoa thong tin DIEU_TRI that bai");
						}
					}
				} else if (ppDieuTri_RS.equals("DIEU TRI NGOAI TRU")) {
					{
						PreparedStatement preparedStatement6 = null;
						preparedStatement6 = connection.prepareStatement(sql_xoa_6);
						preparedStatement6.setString(1, maDT_RS);
						int sql5 = preparedStatement6.executeUpdate();
						if (sql5 > 0) {
							System.out.println("Xoa thong tin DIEU_TRI_THUOC thanh cong");
						} else {
							System.out.println("Xoa thong tin DIEU_TRI_THUOc that bai");
						}
					}
					{
						PreparedStatement preparedStatement6 = null;
						preparedStatement6 = connection.prepareStatement(sql_xoa_7);
						preparedStatement6.setString(1, maDT_RS);
						int sql5 = preparedStatement6.executeUpdate();
						if (sql5 > 0) {
							System.out.println("Xoa thong tin DIEU_TRI thanh cong");
						} else {
							System.out.println("Xoa thong tin DIEU_TRI that bai");
						}
					}
				}
			} else {
				System.out.println("Hien khong co thong tin ve Ma Ho So Benh An Ban Vua Nhap");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public static final String sql5_1 = "SELECT COUNT(GioKham) AS A7h_8h FROM HO_SO_BENH_AN WHERE GioKham >= '7:00:00' AND GioKham < '8:00:00' AND MONTH(NgayKham) = ?";
	public static final String sql5_2 = "SELECT COUNT(GioKham) AS A8h_9h FROM HO_SO_BENH_AN WHERE GioKham >= '8:00:00' AND GioKham < '9:00:00' AND MONTH(NgayKham) = ?";
	public static final String sql5_3 = "SELECT COUNT(GioKham) AS A9h_10h FROM HO_SO_BENH_AN WHERE GioKham >= '9:00:00' AND GioKham < '10:00:00' AND MONTH(NgayKham) = ?";
	public static final String sql5_4 = "SELECT COUNT(GioKham) AS A10h_11h30 FROM HO_SO_BENH_AN WHERE GioKham >= '10:00:00' AND GioKham <= '11:30:00' AND MONTH(NgayKham) = ?";
	public static final String sql5_5 = "SELECT COUNT(GioKham) AS A13h_14h FROM HO_SO_BENH_AN WHERE GioKham >= '13:00:00' AND GioKham < '14:00:00' AND MONTH(NgayKham) = ?";
	public static final String sql5_6 = "SELECT COUNT(GioKham) AS A14h_15h FROM HO_SO_BENH_AN WHERE GioKham >= '14:00:00' AND GioKham < '15:00:00' AND MONTH(NgayKham) = ?";
	public static final String sql5_7 = "SELECT COUNT(GioKham) AS A15h_16h FROM HO_SO_BENH_AN WHERE GioKham >= '15:00:00' AND GioKham < '16:00:00' AND MONTH(NgayKham) = ?";
	public static final String sql5_8 = "SELECT COUNT(GioKham) AS A16h_17h30 FROM HO_SO_BENH_AN WHERE GioKham >= '16:00:00' AND GioKham <= '17:30:00' AND MONTH(NgayKham) = ?";

	public static int LaySoKhach(Connection connection, String tenLenh, String tenCot, String thangNhap) {
		int soKhachRS = 0;

		try {
			PreparedStatement preparedStatement2 = null;
			preparedStatement2 = connection.prepareStatement(tenLenh);
			preparedStatement2.setString(1, thangNhap);
			ResultSet resultSet = preparedStatement2.executeQuery();
			if (resultSet.next()) {
				soKhachRS = resultSet.getInt(tenCot);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return soKhachRS;
	}

	public void ThongKeTheoGio(Connection connection, Scanner scanner) {
		ArrayList<Integer> soKhach = new ArrayList<Integer>();
		ArrayList<String> khoangGio = new ArrayList<String>();
		ArrayList<Integer> viTri = new ArrayList<Integer>();
		ArrayList<LuaChon_7> hienThi = new ArrayList<LuaChon_7>();

		String regex = "^([0-9]|1[0-2])$";
		String nhapThang = "";
		System.out.println("Nhap vao thang muon thong ke");
//		scanner.nextLine();
		do {
			System.out.println("Nhap thang: 1 --> 12");
			nhapThang = scanner.nextLine();
		} while (!nhapThang.matches(regex));

		// ADD CÁC KHOẢNG GIỜ CỐ ĐỊNH VÀO MÃNG
		khoangGio.add("GioKham >= '7:00:00' AND GioKham < '8:00:00'");
		khoangGio.add("GioKham >= '8:00:00' AND GioKham < '9:00:00'");
		khoangGio.add("GioKham >= '9:00:00' AND GioKham < '10:00:00'");
		khoangGio.add("GioKham >= '10:00:00' AND GioKham < '11:30:00'");
		khoangGio.add("GioKham >= '13:00:00' AND GioKham < '14:00:00'");
		khoangGio.add("GioKham >= '14:00:00' AND GioKham < '15:00:00'");
		khoangGio.add("GioKham >= '15:00:00' AND GioKham < '16:00:00'");
		khoangGio.add("GioKham >= '16:00:00' AND GioKham < '17:30:00'");

		PreparedStatement preparedStatement = null;
		try {

			// ADD CÁC TỔNG SỐ KHÁCH ĐỂ KHÁM THEO CÁC KHOẢNG GIỜ
			soKhach.add(LaySoKhach(ConnecTion.connection, sql5_1, "A7h_8h", nhapThang));
			soKhach.add(LaySoKhach(ConnecTion.connection, sql5_2, "A8h_9h", nhapThang));
			soKhach.add(LaySoKhach(ConnecTion.connection, sql5_3, "A9h_10h", nhapThang));
			soKhach.add(LaySoKhach(ConnecTion.connection, sql5_4, "A10h_11h30", nhapThang));
			soKhach.add(LaySoKhach(ConnecTion.connection, sql5_5, "A13h_14h", nhapThang));
			soKhach.add(LaySoKhach(ConnecTion.connection, sql5_6, "A14h_15h", nhapThang));
			soKhach.add(LaySoKhach(ConnecTion.connection, sql5_7, "A15h_16h", nhapThang));
			soKhach.add(LaySoKhach(ConnecTion.connection, sql5_8, "A16h_17h30", nhapThang));

			// TÌM GIÁ TRỊ CÓ SỐ KHÁCH TỐI ĐA LƯU TRONG MÃNG
			int max = 0;
			for (int i = 0; i < soKhach.size(); i++) {
				if (max < soKhach.get(i)) {
					max = soKhach.get(i);
				}
			}

			// NẾU max > 0 THÌ CÓ KHÁCH HÀNG ĐẾN KHÁM TRONG THÁNG NHẬP ĐÓ
			if (max == 0) {
				System.out.println("Khong co benh nhan nao den kham trong thang ban vua nhap");

			} else {

				// TÌM CÁC VỊ TRÍ CHỨA CÁC GIÁ TRỊ max VÀ IN CÁC KHOẢNG GIỜ CHỨA CÁC GIÁ TRỊ max
				// ĐÓ
				for (int i = 0; i < soKhach.size(); i++) {
					if (max == soKhach.get(i)) {
						viTri.add(i);
					}
				}

				// KHUNG GIỜ CÓ SỐ KHÁCH ĐẾN KHÁM LỚN NHẤT
				for (int i = 0; i < viTri.size(); i++) {
					System.out.println("Khung gio " + khoangGio.get(viTri.get(i)));
					System.out.println("So khach toi da " + soKhach.get(viTri.get(i)));
				}

				for (int i = 0; i < viTri.size(); i++) {

					// CÁCH LÀM GÉP CHUỖI VỚI CÂU LỆNH TRUY VẤN
					String sql5_9 = "SELECT HSBN.MaHS, HSBN.MaBN, BN.TenBN, BN.GioiTinh, HSBN.PPDieuTri, HSBN.GioKham, HSBN.NgayKham, HSBN.NgayHenTaiKham, HSBN.MaBS\r\n"
							+ "	FROM BENH_NHAN as BN, HO_SO_BENH_AN as HSBN\r\n" + "	WHERE "
							+ khoangGio.get(viTri.get(i)) + " AND BN.MaBN = HSBN.MaBN AND MONTH(NgayKham) = ?";

					preparedStatement = connection.prepareStatement(sql5_9);
					preparedStatement.setString(1, nhapThang);
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

						LuaChon_7 chon_7 = new LuaChon_7(MaHSRS, MaBNRS, TenBNRS, GioiTinhRS, PPDieuTriRS, GioKhamRS,
								NgayKhamRS, NgayHenTaiKhamRS, MaBSRS);
						hienThi.add(chon_7);
					}
				}
				for (LuaChon_7 chon_7 : hienThi) {
					System.out.println(chon_7);
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
