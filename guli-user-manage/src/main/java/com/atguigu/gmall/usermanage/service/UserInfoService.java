package com.atguigu.gmall.usermanage.service;

import com.atguigu.gmall.usermanage.bean.UserInfo;

import java.util.List;

public interface UserInfoService {
	/**
	 * 查询所有用户数据
	 */
	List<UserInfo> findAll();

	/**
	 * 根据用户名字查询用户信息
	 */
	UserInfo getUserInfoByName(String name);

	/**
	 * 根据名字查询用户列表
	 * @param userInfo
	 * @return
	 */
	List<UserInfo> getUserInfoListByName(UserInfo userInfo);
	/**
	 * 模糊查询
	 */
	List<UserInfo> findByUser(UserInfo userInfo);
	/**
	 * 登陆
	 */
	UserInfo login(UserInfo userInfo);

	/**
	 * 注册
	 */
	void addUser(UserInfo userInfo);

	/**
	 * 修改
	 * @param userInfo
	 */
	void updateUser(UserInfo userInfo);

	/**
	 * 删除
	 * @param userInfo
	 */
	void deleteUserById(UserInfo userInfo);
}
