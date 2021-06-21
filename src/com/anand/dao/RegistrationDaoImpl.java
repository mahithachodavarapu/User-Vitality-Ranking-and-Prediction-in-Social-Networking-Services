package com.anand.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

import com.anand.bo.AccountBo;

public class RegistrationDaoImpl implements RegistrationDao {
	private static final String SQL_CREATE_USER_ACCOUNT = "INSERT INTO USER_ACCOUNT values(?,?,?,?,?,?,?,?,?,?,?)";
	
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public int register(AccountBo accountBo) {

		try {
			final File image = new File(accountBo.getPicture());
			final InputStream imageIs = new FileInputStream(image);
			LobHandler lobHandler = new DefaultLobHandler();

			return jt.update(SQL_CREATE_USER_ACCOUNT, new Object[] {
					accountBo.getSerialNumber(), accountBo.getFullName(),
					accountBo.getEmail(), accountBo.getPassword(),
					accountBo.getPhone(), accountBo.getEducation(),
					accountBo.getAddress(),
					new SqlLobValue(imageIs, (int) image.length(), lobHandler),

					accountBo.getPictureExtensions(), accountBo.getUserType(),
					accountBo.getRegistrationDate() }, new int[] {
					Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
					Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BLOB,
					Types.VARCHAR, Types.VARCHAR, Types.VARCHAR });

		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

}
