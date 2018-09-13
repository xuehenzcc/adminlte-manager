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
import com.zcc.entity.Pool;
import com.zcc.service.IPoolService;
/**
 * 公告控制器
 * @author Gaojun.Zhou
 * @date 2016年12月13日 上午10:22:41
 */
@Controller
@RequestMapping("/gm/pool")
public class PoolController extends SuperController{  

	@Autowired private IPoolService noticeService;
//	@Autowired private IMemberService memberService;
	
	/**
	 * 分页查询公告
	 */
	@RequiresPermissions("listPool")
    @RequestMapping("/list/{pageNumber}")  
    public  String list(@PathVariable Integer pageNumber,@RequestParam(defaultValue="15") Integer pageSize,String search,Model model){
//		// 查询分页
		EntityWrapper<Pool> ew = new EntityWrapper<Pool>();
		if(StringUtils.isNotBlank(search)){
			ew.like("content",search);
			model.addAttribute("search",search);
		}
    	Page<Pool> page = getPage(pageNumber,pageSize);
    	model.addAttribute("pageSize", pageSize);
    	page.setOrderByField("id");
    	page.setAsc(false);
    	Page<Pool> pageData = noticeService.selectPage(page, ew);
    	model.addAttribute("pageData", pageData);
    	return "gm/pool/list";
    } 
    /**
     * 新增公告
     */
	@RequiresPermissions("addPool")
    @RequestMapping("/add")  
    public  String add(Model model){
		return "gm/pool/add";
    } 
    
    /**
     * 执行新增
     */
    @Log("创建公告")
    @RequiresPermissions("addPool")
    @RequestMapping("/doAdd")  
    @ResponseBody
    public  Rest doAdd(Pool message){
    	message.setCreate_date(new Date());//创建时间
    	noticeService.insert(message);
    	return Rest.ok();
    }  
    /**
     * 删除公告
     */
    @Log("删除公告")
    @RequiresPermissions("deletePool")
    @RequestMapping("/delete")  
    @ResponseBody
    public  Rest delete(String id){
    	noticeService.deleteById(id);
    	return Rest.ok();
    }  
    /**
     * 批量删除公告
     */
	@RequiresPermissions("deletePool")
    @Log("批量删除公告")
    @RequestMapping("/deleteBatch")  
    @ResponseBody
    public Rest deleteBatch(@RequestParam("id[]") List<String> ids){
    	noticeService.deleteBatchIds(ids);
    	return Rest.ok();
    }  
	/**
	 * 编辑公告
	 */
    @RequestMapping("/edit/{id}")  
    @RequiresPermissions("editPool")
    public  String edit(@PathVariable String id,Model model){
    	Pool sysUser = noticeService.selectById(id);
    	
//    	List<SysRole> sysRoles = sysRoleService.selectList(null);
//    	EntityWrapper<SysUserRole> ew = new EntityWrapper<SysUserRole>();
//    	ew.eq("userId ", id);
//    	List<SysUserRole> mySysUserRoles = sysUserRoleService.selectList(ew);
//    	List<String> myRolds = Lists.transform(mySysUserRoles, input -> input.getRoleId());
    	
    	model.addAttribute("sysUser",sysUser);
//    	model.addAttribute("sysRoles",sysRoles);
//    	model.addAttribute("myRolds",myRolds);
//    	model.addAttribute("deptList", sysDeptService.selectList(null));
    	return "gm/pool/edit";
    } 
    /**
     * 执行编辑
     */
    @Log("编辑公告")
    @RequiresPermissions("editPool")
    @RequestMapping("/doEdit")  
    @ResponseBody
    public  Rest doEdit(Pool sysUser,Model model){
    	noticeService.updateById(sysUser);
    	return Rest.ok();
    } 
    
    
}
