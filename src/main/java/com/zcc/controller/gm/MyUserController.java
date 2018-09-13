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
import com.zcc.entity.User;
import com.zcc.service.IUserService;
/**
 * 后台参数控制器
 * @author Gaojun.Zhou
 * @date 2016年12月13日 上午10:22:41
 */
@Controller
@RequestMapping("/gm/user")
public class MyUserController extends SuperController{  

	@Autowired private IUserService noticeService;
//	@Autowired private IMemberService memberService;
	
	/**
	 * 分页查询后台参数
	 */
	@RequiresPermissions("listMyUser")
    @RequestMapping("/list/{pageNumber}")  
    public  String list(@PathVariable Integer pageNumber,@RequestParam(defaultValue="15") Integer pageSize,String search,Model model){
//		// 查询分页
		EntityWrapper<User> ew = new EntityWrapper<User>();
		if(StringUtils.isNotBlank(search)){
			ew.like("account",search);
			model.addAttribute("search",search);
		}
    	Page<User> page = getPage(pageNumber,pageSize);
    	model.addAttribute("pageSize", pageSize);
    	page.setOrderByField("id");
//    	page.setAsc(false);
    	Page<User> pageData = noticeService.selectPage(page, ew);
    	model.addAttribute("pageData", pageData);
    	return "gm/user/list";
    } 
    /**
     * 新增后台参数
     */
	@RequiresPermissions("addMyUser")
    @RequestMapping("/add")  
    public  String add(Model model){
		return "gm/user/add";
    } 
    
    /**
     * 执行新增
     */
    @Log("创建后台参数")
    @RequiresPermissions("addMyUser")
    @RequestMapping("/doAdd")  
    @ResponseBody
    public  Rest doAdd(User message){
    	message.setCreate_date(new Date());//创建时间
    	message.setLastup_date(new Date());//最后修改时间
//    	SysUser user=ShiroUtil.getSessionUser();
    	noticeService.insert(message);
    	return Rest.ok();
    }  
    /**
     * 删除后台参数
     */
    @Log("删除后台参数")
    @RequiresPermissions("deleteMyUser")
    @RequestMapping("/delete")  
    @ResponseBody
    public  Rest delete(String id){
    	noticeService.deleteById(id);
    	return Rest.ok();
    }  
    /**
     * 批量删除后台参数
     */
	@RequiresPermissions("deleteMyUser")
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
    @RequiresPermissions("editMyUser")
    public  String edit(@PathVariable String id,Model model){
    	User sysUser = noticeService.selectById(id);
    	
//    	List<SysRole> sysRoles = sysRoleService.selectList(null);
//    	EntityWrapper<SysUserRole> ew = new EntityWrapper<SysUserRole>();
//    	ew.eq("userId ", id);
//    	List<SysUserRole> mySysUserRoles = sysUserRoleService.selectList(ew);
//    	List<String> myRolds = Lists.transform(mySysUserRoles, input -> input.getRoleId());
    	
    	model.addAttribute("sysUser",sysUser);
//    	model.addAttribute("sysRoles",sysRoles);
//    	model.addAttribute("myRolds",myRolds);
//    	model.addAttribute("deptList", sysDeptService.selectList(null));
    	return "gm/user/edit";
    } 
    /**
     * 执行编辑
     */
    @Log("编辑后台参数")
    @RequiresPermissions("editMyUser")
    @RequestMapping("/doEdit")  
    @ResponseBody
    public  Rest doEdit(User sysUser,Model model){
    	noticeService.updateById(sysUser);
    	return Rest.ok();
    } 
    
    
}
