/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年8月27日
 */
package com.zcc.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zcc.entity.Task;
import com.zcc.mapper.TaskMapper;
import com.zcc.service.ITaskService;

/**
 * @author c0z00k8
 *
 */
@Service
public class TaskService extends ServiceImpl<TaskMapper, Task> implements ITaskService{

	
}
