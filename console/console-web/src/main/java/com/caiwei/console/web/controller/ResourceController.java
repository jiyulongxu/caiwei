package com.caiwei.console.web.controller;

import com.caiwei.console.common.domain.ResourceTreeNode;
import com.caiwei.console.web.domain.ResourceVO;
import com.caiwei.console.web.service.IMenuService;
import com.github.framework.server.shared.domain.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private IMenuService menuService;

    @RequestMapping("/index")
    public String index() {
        return "/sysset/resource";
    }

    @ResponseBody
    @RequestMapping("/queryTreePathForName")
    public ResponseVO<ResourceTreeNode> queryTreePathForName(@RequestBody String resourceName) {
        return null;
    }

    @ResponseBody
    @RequestMapping("/queryResourceByParentRes")
    public List<ResourceTreeNode> queryResourceByParentRes(String node) {
        List<ResourceTreeNode> menuNodes = menuService.queryResourceByParentRes(node);
        return menuNodes;
    }

    @ResponseBody
    @RequestMapping("/listResource")
    public ResponseVO<ResourceVO> listResource(@ModelAttribute ResourceVO resourceVO) {
        return null;
    }
}