package com.caiwei.console.web.service.impl;

import com.caiwei.console.business.service.IUserMenuService;
import com.caiwei.console.common.domain.ResourceDO;
import com.caiwei.console.common.domain.ResourceNode;
import com.caiwei.console.common.domain.ResourceTreeNode;
import com.caiwei.console.web.domain.ResourceVO;
import com.caiwei.console.web.service.IResourceService;
import com.github.framework.server.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
@Service
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private IUserMenuService userMenuService;


    @Override
    public List<ResourceTreeNode> queryResourceByParentRes(String node) {
        List<ResourceTreeNode> nodes = new ArrayList<>();
        List<ResourceNode> childResources = userMenuService.queryResourcesByParentCode(node, false);
        for (ResourceNode res : childResources) {
            // 转换菜单对象为节点对象
            ResourceTreeNode<ResourceNode> treeNode = ResourceTreeNode.changeResToTreeNode(res,true);
            nodes.add(treeNode);
        }
        return nodes;
    }

    @Override
    public ResourceVO queryResourceByExample(ResourceVO resourceVO) {
        if (resourceVO == null) {
            throw new BusinessException("参数不能为空！");
        }
        ResourceDO resourceDO = ResourceDO.flipConvert(resourceVO.getResourceNode());
        List<ResourceDO> list = userMenuService.queryResourcesByParam(resourceDO);
        List<ResourceNode> resourceNodes = new ArrayList<>();
        for (ResourceDO res : list) {
            resourceNodes.add(ResourceDO.convert(res));
        }
        resourceVO.setResourceNodes(resourceNodes);
        return resourceVO;
    }

    @Override
    public void addResource(ResourceVO resourceVO) {
        if (resourceVO == null) {
            throw new BusinessException("提交参数为空!");
        }
        ResourceDO resourceDO = ResourceDO.flipConvert(resourceVO.getResourceNode());
        userMenuService.addResource(resourceDO);
    }

    @Override
    public void updateResource(ResourceVO resourceVO) {
        if (resourceVO == null) {
            throw new BusinessException("提交参数为空!");
        }
        ResourceDO resourceDO = ResourceDO.flipConvert(resourceVO.getResourceNode());
        userMenuService.updateResource(resourceDO);
    }

    @Override
    public void deleteResource(ResourceVO resourceVO) {
        if (resourceVO == null) {
            throw new BusinessException("提交参数为空!");
        }
        List<String> resCodes = new ArrayList<>();
        for (ResourceNode node : resourceVO.getResourceNodes()) {
            resCodes.add(node.getCode());
        }
        userMenuService.deleteResource(resCodes);
    }
}
