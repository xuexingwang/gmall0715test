package com.atguigu.gmall.usermanage.service.impl;

import com.atguigu.gmall.usermanage.bean.UserInfo;
import com.atguigu.gmall.usermanage.mapper.UserInfoMapper;
import com.atguigu.gmall.usermanage.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	@Override
	public List<UserInfo> findAll() {

		return userInfoMapper.selectAll();
	}

	@Override
	public UserInfo getUserInfoByName(String name) {
		return null;
	}

	@Override
	public List<UserInfo> getUserInfoListByName(UserInfo userInfo) {
		Example example = new Example(UserInfo.class);
		example.createCriteria().andEqualTo("name",userInfo.getName());

		return userInfoMapper.selectByExample(example);
	}

	@Override
	public List<UserInfo> findByUser(UserInfo userInfo) {
		Example example = new Example(UserInfo.class);
		example.createCriteria().andLike("loginName","%"+userInfo.getLoginName()+"%");
		return userInfoMapper.selectByExample(example);

	}

	@Override
	public UserInfo login(UserInfo userInfo) {
		return userInfoMapper.selectOne(userInfo);
	}

	@Override
	public void addUser(UserInfo userInfo) {
		userInfoMapper.insertSelective(userInfo);
	}

	@Override
	public void updateUser(UserInfo userInfo) {
		//update UserInfo set name=? where id=?
//		userInfoMapper.updateByPrimaryKey(userInfo);
		//update userInfo set loginName=? where name=?
		Example example = new Example(UserInfo.class);
		example.createCriteria().andEqualTo("name",userInfo.getName());
		userInfoMapper.updateByExampleSelective(userInfo,example);

	}

	@Override
	public void deleteUserById(UserInfo userInfo) {
//		userInfoMapper.deleteByPrimaryKey(userInfo);

		userInfoMapper.delete(userInfo);
	}



}
