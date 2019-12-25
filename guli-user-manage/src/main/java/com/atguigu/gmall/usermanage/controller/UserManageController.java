package com.atguigu.gmall.usermanage.controller;

import com.atguigu.gmall.usermanage.bean.UserInfo;
import com.atguigu.gmall.usermanage.service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserManageController {

	@Autowired
	private UserInfoService userInfoService;

	/**
	 * 查询所有用户信息
	 */
	@RequestMapping("findAll")
	public List<UserInfo>findAll(){

		return userInfoService.findAll();
	}
	/**
	 * 根据名字查询用户信息
	 */
    @RequestMapping("getUserInfoByName")
	private List<UserInfo> getUserInfoByName(UserInfo userInfo, HttpServletRequest request){

		String name = request.getParameter("name");
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setName(name);
		return userInfoService.getUserInfoListByName(userInfo);
	}

	/**
	 * 模糊查询 /登陆
	 */
	@RequestMapping("findUserInfoLoginName")
	private List<UserInfo> findUserInfoLoginName(UserInfo userInfo){

		return userInfoService.findByUser(userInfo);

	}
	/**
	 * 注册
	 */
	@RequestMapping("addUser")
	private void addUser(UserInfo userInfo){
		System.out.println("==="+userInfo.getId());
		UserInfo userInfo1 = new UserInfo();
		userInfo.setName("高嚣微");
		userInfo.setEmail("gxw@163.com");
		userInfo.setLoginName("小小鸟");
		userInfo.setPasswd("1234567");
		userInfoService.addUser(userInfo);
		System.out.println("主键"+userInfo.getId());
	}
	/**
	 * 修改
	 */
	@RequestMapping("updateUser")
	public void updateUser(UserInfo userInfo){

		userInfoService.updateUser(userInfo);
	}
	/**
	 * 删除
	 */
	@RequestMapping("deleteUser")
	public void deleteUser(UserInfo userInfo){
		//根据id删除
//		delete from userInfo where id=?
		userInfoService.deleteUserById(userInfo);
	}

}
