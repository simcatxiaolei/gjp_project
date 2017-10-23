package cn.itcast.gjp.dao;
/*
  	用来操作数据库的增删改查等操作
 */

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.gjp.tools.JDBCUtils;

public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
}
