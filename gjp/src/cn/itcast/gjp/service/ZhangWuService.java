package cn.itcast.gjp.service;

import cn.itcast.gjp.dao.ZhangWuDao;

/*
  业务层:处理一些业务,整理数据
  用来接收控制层的数据
  传递给dao层
 */
public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();
}
