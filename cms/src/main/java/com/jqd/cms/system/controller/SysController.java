package com.jqd.cms.system.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jqd.cms.base.BaseController;
import com.jqd.cms.base.BaseResult;
import com.jqd.cms.common.util.GlobConstant;
import com.jqd.cms.system.constant.SysConstant;
import com.jqd.cms.system.model.SysMenu;
import com.jqd.cms.system.model.SysUser;
import com.jqd.cms.system.service.SysMenuService;
import com.jqd.cms.system.service.SysUserService;

/**
 * SysIndexController Created by dujianqiao on 2017/7/29.
 */
@Controller
public class SysController extends BaseController {

	public static Logger logger = LoggerFactory.getLogger(SysController.class);

	private String loginView = "/system/login";

	private String indexView = "/system/index";
	
	private String menuView = "/system/menu";
	
	private String mainView = "/system/main";

	@Autowired
	private SysUserService service ;
	
	@Autowired
	private SysMenuService menuService ;

	/**
	 * 去系统登录 管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/system/login")
	public ModelAndView index(SysUser user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(loginView);
		if (null == user || null == user.getUsername() || null == user.getPassword()) {
			mv.setViewName(loginView);
		}
		return mv;
	}

	/**
	 * jquery 登录
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/admin/login")
	@ResponseBody
	public Map<String, Object> login(SysUser user) {
		BaseResult br = new BaseResult();
		if (null == user || null == user.getUsername() || null == user.getPassword()) {
			br.setCode(GlobConstant.CODE_ERROR);
			br.setMessage(SysConstant.NULL_USER_PASS);
		}
		SysUser model = service.login(user);
		if (null == model) {
			br.setCode(GlobConstant.CODE_ERROR);
			br.setMessage(SysConstant.LOGIN_ACCOUNT_ERROR);
		}
		return br.modelMap();
	}

	/**
	 * 首页
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/admin/index")
	public ModelAndView admin(SysUser user) {
		SysUser model = service.login(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName(loginView);
		if (null == model) {
			mv.setViewName(loginView);
		} else {
			mv.setViewName(indexView);
			
			List<SysMenu> menus = menuService.selectByParentKey(0L) ;
			Long sId = menus.size() >0 ? menus.get(0).getsId() : 0L ; 
			mv.addObject("sId", sId) ;
			mv.addObject("menus", menus) ;
			mv.addObject("user", model);
		}
		return mv;
	}

	/**
	 * 查询菜单
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/menu")
	public ModelAndView admin(Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(menuView);
		List<SysMenu> menus = menuService.selectByParentKey(id) ;
		int len = null != menus ? menus.size() : 0 ;
		for(int i=0 ;i<len ;i++ ) {
			SysMenu menu = menus.get(i) ;
			List<SysMenu> menusChrildrens = menuService.selectByParentKey(menu.getsId()) ;
			int clen = null != menusChrildrens ? menusChrildrens.size() : 0 ;
			for(int j=0 ; j<clen ; j++ ) {
				SysMenu menuc = menusChrildrens.get(j) ;
				List<SysMenu> menucChrildrens = menuService.selectByParentKey(menuc.getsId()) ;
				menuc.setChrildren(menucChrildrens);
			}
			menu.setChrildren(menusChrildrens);
		}
		mv.addObject("menus", menus) ;
		return mv;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/admin/main")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(mainView);

		return mv;
	}
}