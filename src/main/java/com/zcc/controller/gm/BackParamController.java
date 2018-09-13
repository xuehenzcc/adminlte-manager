package com.zcc.controller.gm;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zcc.common.anno.Log;
import com.zcc.common.bean.Rest;
import com.zcc.common.controller.SuperController;
import com.zcc.common.util.ShiroUtil;
import com.zcc.entity.BackParam;
import com.zcc.entity.Notice;
import com.zcc.entity.SysUser;
import com.zcc.service.IBackParamService;
import com.zcc.service.INoticeService;
/**
 * 后台参数控制器
 * @author Gaojun.Zhou
 * @date 2016年12月13日 上午10:22:41
 */
@Controller
@RequestMapping("/gm/backparam")
public class BackParamController extends SuperController{  

	@Autowired private IBackParamService noticeService;
//	@Autowired private IMemberService memberService;
	
	/**
	 * 分页查询后台参数
	 */
	@RequiresPermissions("listBackParam")
    @RequestMapping("/list/{pageNumber}")  
    public  String list(@PathVariable Integer pageNumber,@RequestParam(defaultValue="15") Integer pageSize,String search,Model model){
//		// 查询分页
		EntityWrapper<BackParam> ew = new EntityWrapper<BackParam>();
		if(StringUtils.isNotBlank(search)){
			ew.like("content",search);
			model.addAttribute("search",search);
		}
    	Page<BackParam> page = getPage(pageNumber,pageSize);
    	model.addAttribute("pageSize", pageSize);
    	page.setOrderByField("number");
//    	page.setAsc(false);
    	Page<BackParam> pageData = noticeService.selectPage(page, ew);
    	model.addAttribute("pageData", pageData);
    	return "gm/backparam/list";
    } 
    /**
     * 新增后台参数
     */
	@RequiresPermissions("addBackParam")
    @RequestMapping("/add")  
    public  String add(Model model){
		return "gm/backparam/add";
    } 
    
    /**
     * 执行新增
     */
    @Log("创建后台参数")
    @RequiresPermissions("addBackParam")
    @RequestMapping("/doAdd")  
    @ResponseBody
    public  Rest doAdd(BackParam message){
    	message.setCreatedate(new Date());//创建时间
    	message.setLastupdate(new Date());//最后修改时间
//    	SysUser user=ShiroUtil.getSessionUser();
    	noticeService.insert(message);
    	return Rest.ok();
    }  
    /**
     * 删除后台参数
     */
    @Log("删除后台参数")
    @RequiresPermissions("deleteBackParam")
    @RequestMapping("/delete")  
    @ResponseBody
    public  Rest delete(String id){
    	noticeService.deleteById(id);
    	return Rest.ok();
    }  
    /**
     * 批量删除后台参数
     */
	@RequiresPermissions("deleteBackParam")
    @Log("批量删除后台参数")
    @RequestMapping("/deleteBatch")  
    @ResponseBody
    public Rest deleteBatch(@RequestParam("id[]") List<String> ids){
    	noticeService.deleteBatchIds(ids);
    	return Rest.ok();
    }  
	/**
	 * 编辑后台参数
	 */
    @RequestMapping("/edit/{id}")  
    @RequiresPermissions("editBackParam")
    public  String edit(@PathVariable String id,Model model){
    	BackParam sysUser = noticeService.selectById(id);
    	
//    	List<SysRole> sysRoles = sysRoleService.selectList(null);
//    	EntityWrapper<SysUserRole> ew = new EntityWrapper<SysUserRole>();
//    	ew.eq("userId ", id);
//    	List<SysUserRole> mySysUserRoles = sysUserRoleService.selectList(ew);
//    	List<String> myRolds = Lists.transform(mySysUserRoles, input -> input.getRoleId());
    	
    	model.addAttribute("sysUser",sysUser);
//    	model.addAttribute("sysRoles",sysRoles);
//    	model.addAttribute("myRolds",myRolds);
//    	model.addAttribute("deptList", sysDeptService.selectList(null));
    	return "gm/backparam/edit";
    } 
    /**
     * 执行编辑
     */
    @Log("编辑后台参数")
    @RequiresPermissions("editBackParam")
    @RequestMapping("/doEdit")  
    @ResponseBody
    public  Rest doEdit(BackParam sysUser,Model model){
    	noticeService.updateById(sysUser);
    	return Rest.ok();
    } 
    
    
}
