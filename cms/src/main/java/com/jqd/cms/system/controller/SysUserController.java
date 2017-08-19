package com.jqd.cms.system.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jqd.cms.base.BaseController;
import com.jqd.cms.base.BaseResult;
import com.jqd.cms.system.model.SysUser;
import com.jqd.cms.system.service.SysUserService;

/**
 * sysusercontroller
 * Created by dujianqiao on 2017/7/29.
 */
@Controller
@RequestMapping("/manage/sysuser")
public class SysUserController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SysUserController.class);


    @Autowired
    private SysUserService service ;
    
    /**
     * 去列表 管理页面
     * 
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
      logger.info(" list index");
      ModelAndView mv = new ModelAndView("/sysuser/index") ;
      List<SysUser> list  = service.selectByExample(null) ;
      mv.addObject("list", list) ;
      return mv ;
    }
    
    /**
     * 去新增页面
     * 
     * @return
     */
    @RequestMapping("/toAdd")
    public ModelAndView toAdd() {
      logger.info(" to add ");
      ModelAndView mv = new ModelAndView("/sysuser/toAdd");
      return mv;
    }
    
    
    
    /**
     * 保存新增
     * 
     * @param model
     * @return
     */
    @RequestMapping("/save")
    public ModelAndView save(SysUser model) {
      ModelAndView mv = new ModelAndView("redirect:/index");
      service.insert(model) ;
      return mv ;
    }
    
    
    
    /**
     * 去编辑页面
     * 
     * @param id
     * @return
     */
    @RequestMapping("/toEdit")
    public ModelAndView toEdit(Long id) {
      ModelAndView mv = new ModelAndView("/sysuser/toEdit");
      SysUser model =  service.selectByPrimaryKey(id) ;
      mv.addObject("model", model) ;
      return mv ;
    }
    
    
    /**
     * 编辑信息
     * @param model
     * @return
     */
    @RequestMapping("/edit")
    public ModelAndView edit(SysUser model) {
      ModelAndView mv = new ModelAndView("redirect:/index");
      service.updateByPrimaryKey(model) ;
      return mv ;
    }
    
    /**
    * 删除信息
    * 
    * @param id
    * @return
    */
    public Map<String, Object> delete(Long id) {
      BaseResult result  = new BaseResult() ;
      service.deleteByPrimaryKey(id) ;
      return result.modelMap() ;
    }
    
}