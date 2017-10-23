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
		
		// 加载配置文件
		try {
			loadConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 以下四项是必须要配置的
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		//配置连接池
		// 设置连接池的容量
		dataSource.setInitialSize(Integer.parseInt(initialSize));
		// 设置最大访问量
		dataSource.setMaxActive(Integer.parseInt(maxActive));
		// 设置最大空闲数
		dataSource.setMaxIdle(Integer.parseInt(maxIdle));
		// 设置最小空闲数
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
