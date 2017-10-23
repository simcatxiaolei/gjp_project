package cn.itcast.gjp.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	private static BasicDataSource dataSource = new BasicDataSource();
	private static String driverClassName;
	private static String url;
	private static String username;
	private static String password;
	private static String initialSize;
	private static String maxActive;
	private static String maxIdle;
	private static String minIdle;
	
	private JDBCUtils() {}
	
	static{
		
		// ���������ļ�
		try {
			loadConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ���������Ǳ���Ҫ���õ�
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		//�������ӳ�
		// �������ӳص�����
		dataSource.setInitialSize(Integer.parseInt(initialSize));
		// ������������
		dataSource.setMaxActive(Integer.parseInt(maxActive));
		// ������������
		dataSource.setMaxIdle(Integer.parseInt(maxIdle));
		// ������С������
		dataSource.setMinIdle(Integer.parseInt(minIdle));
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	public static void loadConfig() throws IOException{
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties");
		
		Properties p = new Properties();
		p.load(is);
		
		driverClassName = p.getProperty("driverClassName");
		url = p.getProperty("url");
		username = p.getProperty("username");
		password = p.getProperty("password");
		initialSize = p.getProperty("initialSize");
		maxActive = p.getProperty("maxActive");
		maxIdle = p.getProperty("maxIdle");
		minIdle = p.getProperty("minIdle");
	}
}
