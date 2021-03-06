package com.mvp.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.mvp.DAO.DataProvider;

public class ProductTypeServices {

private static ProductTypeServices instance;
	
	public ProductTypeServices() {
		
	}

	public static ProductTypeServices getInstance() {
		if(instance == null)
			instance = new ProductTypeServices();
		return instance;
	}

	public static void setInstance(ProductTypeServices instance) {
		ProductTypeServices.instance = instance;
	}
	
	public boolean DeleteProductType(int iD){		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spDeleteProductType(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			cstmt.setInt(1, iD);			
			return cstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;		
	}
	
	public boolean EditProductType(int iD, String newName){		
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spEditProductType(?,?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);			
			cstmt.setInt(1, iD);
			cstmt.setString(2, newName);
			return cstmt.executeUpdate()>0;			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;		
	}
	
	public boolean AddProductType(String name) 
	{
		CallableStatement cstmt = null;
		Connection conn= DataProvider.getInstance().getConn();
		String SQL = "{call spAddProductType(?)}" ;
		try {
			cstmt = conn.prepareCall(SQL);
			
			cstmt.setString(1, name);

			return cstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
}
