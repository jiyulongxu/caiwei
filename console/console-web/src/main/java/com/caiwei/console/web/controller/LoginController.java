package com.caiwei.console.web.controller;

import com.caiwei.console.common.domain.DepartmentDO;
import com.caiwei.console.web.context.PermisUserContext;
import com.caiwei.console.web.domain.LoginInfoVO;
import com.caiwei.console.web.domain.UserVO;
import com.caiwei.console.web.service.ILoginService;
import com.github.framework.server.cache.exception.security.UserNotLoginException;
import com.github.framework.server.exception.BusinessException;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import com.github.framework.server.web.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
public class LoginController extends AbstractController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private ILoginService loginService;

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/index")
    public String index() {
        try {
            PermisUserContext.getCurrentUser();
        } catch(UserNotLoginException e) {
            return "login";
        }
        return "main";
    }

    @ResponseBody
    @RequestMapping("/login")
    public ResponseVO login(Model model, @RequestBody UserVO userVo) {
        try {
            loginService.userLogin(userVo.getUserCode(), userVo.getPassWord());
            // 这时跳转到main 根据session生成cookie
//                Cookie.saveCookie();
            return this.returnSuccess();
        } catch (BusinessException e) {
            return this.returnError(e);
        } catch (Exception ee) {
            logger.error("",ee);
            return this.returnError();
        }
    }

    /**
     * 查询当前可切换部门
     * @return
     */
    public ResponseVO<DepartmentDO> currentUserChangeDepts() {
        return returnSuccess();
    }

    /**
     * 切换部门
     * @return
     */
    @RequestMapping("/changeCurrentDept")
    public ResponseVO<DepartmentDO> changeCurrentDept() {

        return returnSuccess();
    }

    @RequestMapping("/currentUserInfo")
    public ResponseVO<LoginInfoVO> currentLoginUserInfo() {

        return returnSuccess();
    }

}