package com.aibibang.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/** 
* @author: Truman.P.Du 
* @since: 2016年6月30日 上午8:42:03 
* @version: v1.0
* @description:
*/
public class DbInit {
	static Connection c = null;
	static Statement stmt = null;

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:E:\\github\\ArchetypeProject\\DeployResource\\db\\deploy.db");
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			
			
			//删除表
			//DbInit.deleteTable();
			//创建表
			//DbInit.SoftSqlInit();
			//DbInit.UserSqlInit();
			//DbInit.deleteTable("soft_file");
			//DbInit.SoftFileSqlInit();
			//DbInit.LogsSqlInit();
			//DbInit.DeviceInfoSqlInit();
			DbInit.DeviceInfoSqlAdd();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			try {
				stmt.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		System.out.println("Table created successfully");
	}
    
	
	public static void deleteTable(String tableName) throws SQLException {
		String sql = "drop TABLE "+tableName;
		stmt.executeUpdate(sql);
	}
	
	public static void SoftSqlInit() throws SQLException {
		String sql = "CREATE TABLE soft " +
				"(id INTEGER PRIMARY KEY AUTOINCREMENT   NOT NULL," +
				" name           CHAR(200)    NOT NULL," +
				" hostUserName   CHAR(50)      NOT NULL, " +
				" hostPassword   CHAR(50), " +
				"path   CHAR(100), " +
				" startScript   text, " +
				" stopScript   text, " +
				"filePath   CHAR(100), " +
				"hostIPs         text)";
		stmt.executeUpdate(sql);
	}
	
	public static void DeviceInfoSqlInit() throws SQLException {
		String sql = "CREATE TABLE device_info " +
				"(id INTEGER PRIMARY KEY AUTOINCREMENT   NOT NULL," +
				" name           CHAR(200)    NOT NULL," +
				" param   text)";
		stmt.executeUpdate(sql);
	}
	
	public static void DeviceInfoSqlAdd() throws SQLException {
		String delsql = "delete from device_info";
		stmt.executeUpdate(delsql);
		for(int i=0;i<9;i++){
			String sql = "insert into device_info(name, param) values('设备111"+i+"', '参数1:值1,参数2:值2,参数3:值3,参数4:值4,参数5:值5,参数6:值6,参数7:值7,参数8:值8')";
			stmt.executeUpdate(sql);
		}
		
	}
	
	public static void UserSqlInit() throws SQLException {
		String sql = "CREATE TABLE user " +
				"(id INTEGER PRIMARY KEY AUTOINCREMENT   NOT NULL," +
				" userName  CHAR(50)    NOT NULL," +
				" passwd   CHAR(50)     NOT NULL)";
		stmt.executeUpdate(sql);
		String sql2 = "insert into  user (userName,passwd)values('truman','123456');";
				
		stmt.executeUpdate(sql2);
	}
	
	public static void SoftFileSqlInit() throws SQLException {
		String sql = "CREATE TABLE soft_file " +
				"(id INTEGER PRIMARY KEY AUTOINCREMENT   NOT NULL," +
				" version  INTEGER    NOT NULL," +
				" pId  INTEGER    NOT NULL," +
				" fileName  CHAR(100)    NOT NULL," +
				" path  CHAR(100)    NOT NULL," +
				" filePath   CHAR(100)     NOT NULL)";
		stmt.executeUpdate(sql);
	}
	public static void LogsSqlInit() throws SQLException {
		String sql = "CREATE TABLE deploy_log " +
				"(id INTEGER PRIMARY KEY AUTOINCREMENT   NOT NULL," +
				" version  INTEGER    NOT NULL," +
				" createName  CHAR(100)    NOT NULL," +
				" softName  CHAR(100)    NOT NULL," +
				" createDate  CHAR(100)     NOT NULL)";
		stmt.executeUpdate(sql);
	}
}
