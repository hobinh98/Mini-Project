package goi1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class ConnecTion {
	public static Connection connection = null;
	public static PreparedStatement preparedStatement = null;
	public static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String url = "jdbc:sqlserver://DESKTOP-B0D0J2Q:1433;databaseName=QUAN_LY_BENH_VIEN;trustServerCertificate=true;user=sa;password=12345678";

	public static void Connectionn() {
		try {
			Class.forName(driver);
			System.out.println("driver Oke");
			connection = DriverManager.getConnection(url);
			System.out.println("url Oke");
			if (connection != null) {
				JOptionPane.showMessageDialog(null, "Nhanh len nao!!! GOOD LUCK!!");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void Close() {
		try {
			connection.close();
			System.out.println("-----CLOSE-OKE-----");
			System.out.println("---SEE-YOU-AGAIN---");
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}
