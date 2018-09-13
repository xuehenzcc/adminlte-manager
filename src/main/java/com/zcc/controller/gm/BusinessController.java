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
import com.zcc.entity.Business;
import com.zcc.service.IBusinessService;
/**
 * 任务控制器
 * @author Gaojun.Zhou
 * @date 2016年12月13日 上午10:22:41
 */
@Controller
@RequestMapping("/gm/business")
public class BusinessController extends SuperController{  

	@Autowired private IBusinessService noticeService;
//	@Autowired private IMemberService memberService;
	
	/**
	 * 分页查询任务
	 */
	@RequiresPermissions("listBusiness")
    @RequestMapping("/list/{pageNumber}")  
    public  String list(@PathVariable Integer pageNumber,@RequestParam(defaultValue="15") Integer pageSize,String search,Model model){
//		// 查询分页
		EntityWrapper<Business> ew = new EntityWrapper<Business>();
		if(StringUtils.isNotBlank(search)){
			ew.like("content",search);
			model.addAttribute("search",search);
		}
    	Page<Business> page = getPage(pageNumber,pageSize);
    	model.addAttribute("pageSize", pageSize);
    	page.setOrderByField("id");
    	page.setAsc(false);
    	Page<Business> pageData = noticeService.selectPage(page, ew);
    	model.addAttribute("pageData", pageData);
    	return "gm/business/list";
    } 
    /**
     * 新增任务
     */
	@RequiresPermissions("addBusiness")
    @RequestMapping("/add")  
    public  String add(Model model){
		return "gm/business/add";
    } 
    
    /**
     * 执行新增
     */
    @Log("创建任务")
    @RequiresPermissions("addBusiness")
    @RequestMapping("/doAdd")  
    @ResponseBody
    public  Rest doAdd(Business message){
    	message.setCreate_date(new Date());//创建时间
    	noticeService.insert(message);
    	return Rest.ok();
    }  
    /**
     * 删除任务
     */
    @Log("删除任务")
    @RequiresPermissions("deleteBusiness")
    @RequestMapping("/delete")  
    @ResponseBody
    public  Rest delete(String id){
    	noticeService.deleteById(id);
    	return Rest.ok();
    }  
    /**
     * 批量删除任务
     */
	@RequiresPermissions("deleteBusiness")
    @Log("批量删除任务")
    @RequestMapping("/deleteBatch")  
    @ResponseBody
    public Rest deleteBatch(@RequestParam("id[]") List<String> ids){
    	noticeService.deleteBatchIds(ids);
    	return Rest.ok();
    }  
	/**
	 * 编辑任务
	 */
    @RequestMapping("/edit/{id}")  
    @RequiresPermissions("editBusiness")
    public  String edit(@PathVariable String id,Model model){
    	Business sysUser = noticeService.selectById(id);
    	
//    	List<SysRole> sysRoles = sysRoleService.selectList(null);
//    	EntityWrapper<SysUserRole> ew = new EntityWrapper<SysUserRole>();
//    	ew.eq("userId ", id);
//    	List<SysUserRole> mySysUserRoles = sysUserRoleService.selectList(ew);
//    	List<String> myRolds = Lists.transform(mySysUserRoles, input -> input.getRoleId());
    	
    	model.addAttribute("sysUser",sysUser);
//    	model.addAttribute("sysRoles",sysRoles);
//    	model.addAttribute("myRolds",myRolds);
//    	model.addAttribute("deptList", sysDeptService.selectList(null));
    	return "gm/business/edit";
    } 
    /**
     * 执行编辑
     */
    @Log("编辑任务")
    @RequiresPermissions("editBusiness")
    @RequestMapping("/doEdit")  
    @ResponseBody
    public  Rest doEdit(Business sysUser,Model model){
    	noticeService.updateById(sysUser);
    	return Rest.ok();
    } 
    
    
}
