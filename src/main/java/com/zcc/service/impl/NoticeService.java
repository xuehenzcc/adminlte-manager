/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年8月28日
 */
package com.zcc.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zcc.entity.Notice;
import com.zcc.mapper.NoticeMapper;
import com.zcc.service.INoticeService;

/**
 * @author c0z00k8
 *
 */
@Service
public class NoticeService extends ServiceImpl<NoticeMapper, Notice> implements INoticeService{

	
}
