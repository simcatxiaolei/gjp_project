package cn.itcast.gjp.dao;
/*
  	�����������ݿ����ɾ�Ĳ�Ȳ���
 */

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.gjp.tools.JDBCUtils;

public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
}
