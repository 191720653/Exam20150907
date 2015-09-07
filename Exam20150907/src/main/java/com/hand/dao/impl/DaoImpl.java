package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.connectionfactory.ConnectionFactory;
import com.hand.dao.Dao;
import com.hand.entity.Customer;

public class DaoImpl implements Dao {

	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultSet = null;
		List<Customer> list = null;
		try {
			connection = ConnectionFactory.getInstance().makeConnection();
			String sql = "SELECT customer_id,first_name,last_name,email,address,customer.last_update FROM customer,address WHERE customer.address_id=address.address_id AND active=1";
			PreparedStatement preparedStatement = connection.prepareCall(sql);
			resultSet = preparedStatement.executeQuery();
			list = new ArrayList<Customer>();
			System.out.println("here start");
			while (resultSet.next()) {
				Customer customer = new Customer(resultSet.getShort("customer_id"), resultSet.getString("address"),
						resultSet.getString("first_name"), resultSet.getString("last_name"),
						resultSet.getString("email"), resultSet.getDate("last_update"));
				list.add(customer);
			}
			System.out.println(list.size());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error for getallcustomer");
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				System.out.println("close all");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}

	public String checkCustomer(String firstName, String lastName) {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultSet = null;
		String name = null;
		try {
			connection = ConnectionFactory.getInstance().makeConnection();
			String sql = "SELECT first_name FROM customer WHERE first_name=? and last_name=?";
			PreparedStatement preparedStatement = connection.prepareCall(sql);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			resultSet = preparedStatement.executeQuery();
			System.out.println("here start check");
			while (resultSet.next()) {
				name = resultSet.getString("first_name");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error for getallcustomer");
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				System.out.println("close all");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return name;
	}
	
	public List<String> getAddress() {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultSet = null;
		List<String> name = null;
		try {
			name = new ArrayList<String>();
			connection = ConnectionFactory.getInstance().makeConnection();
			String sql = "SELECT address FROM address";
			PreparedStatement preparedStatement = connection.prepareCall(sql);
			resultSet = preparedStatement.executeQuery();
			System.out.println("here start getAddress");
			while (resultSet.next()) {
				name.add(resultSet.getString("address"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error for getAddress");
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				System.out.println("close all");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return name;
	}
	
	public boolean save(String fname, String lname, String emial, int address) {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = "INSERT INTO customer(first_name,last_name,address_id,email,store_id,create_date) VALUES(?,?,?,?,'1','2015-08-23')";
		PreparedStatement preparedStatement;
		try {
			connection = ConnectionFactory.getInstance().makeConnection();
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setString(1, fname);
			preparedStatement.setString(2, lname);
			preparedStatement.setInt(3, address);
			preparedStatement.setString(4, emial);
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("插入出错！");
			return false;
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				System.out.println("close all");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public boolean delete(int customerId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = "update customer set active=0 where customer_id=?";
		PreparedStatement preparedStatement;
		try {
			connection = ConnectionFactory.getInstance().makeConnection();
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setInt(1, customerId);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("删除出错！");
			return false;
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				System.out.println("delete "+customerId+"， close all");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public int getAddressId(String address) {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultSet = null;
		int id = 0;
		try {
			connection = ConnectionFactory.getInstance().makeConnection();
			String sql = "SELECT address_id FROM address where address=?";
			PreparedStatement preparedStatement = connection.prepareCall(sql);
			preparedStatement.setString(1, address);
			resultSet = preparedStatement.executeQuery();
			System.out.println("here start getAddressId");
			while (resultSet.next()) {
				id = resultSet.getInt("address_id");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error for getAddressId");
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				System.out.println("close all");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return id;
	}
	
	public boolean update(String fname, String lname, String emial, int address, int customerId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sql = "update customer set first_name=?,last_name=?,address_id=?,email=? where customer_id=?";
		PreparedStatement preparedStatement;
		try {
			connection = ConnectionFactory.getInstance().makeConnection();
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setString(1, fname);
			preparedStatement.setString(2, lname);
			preparedStatement.setInt(3, address);
			preparedStatement.setString(4, emial);
			preparedStatement.setInt(5, customerId);
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("update出错！");
			return false;
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				System.out.println("update close all");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
