/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年8月27日
 */
package com.zcc.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zcc.entity.Business;

/**
 * @author c0z00k8
 *
 */
@Repository
public interface BusinessMapper extends BaseMapper<Business>{

//	List<Map<Object, Object>> selectMemberList(Page<Map<Object, Object>> page, @Param("search") String search);
}
