/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年8月27日
 */
package com.zcc.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zcc.entity.User;
import com.zcc.mapper.UserMapper;
import com.zcc.service.IUserService;

/**
 * @author c0z00k8
 *
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService{

	
}
