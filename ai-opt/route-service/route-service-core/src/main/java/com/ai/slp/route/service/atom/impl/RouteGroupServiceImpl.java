package com.ai.slp.route.service.atom.impl;

import com.ai.slp.route.dao.IRouteDao;
import com.ai.slp.route.dao.IRouteGroupDao;
import com.ai.slp.route.dao.IRouteRuleDao;
import com.ai.slp.route.service.atom.interfaces.IRouteGroupService;
import com.ai.slp.route.vo.PriorityRoutesMapping;
import com.ai.slp.route.vo.Route;
import com.ai.slp.route.vo.RouteGroup;
import com.ai.slp.route.vo.RouteRule;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xin on 16-4-28.
 */
public class RouteGroupServiceImpl implements IRouteGroupService {

    private IRouteGroupDao routeGroupDao;

    private IRouteRuleDao routeRuleDao;

    private IRouteDao routeDao;

    @Override
    public List<RouteGroup> queryAllRouteGroup(String tenantId) throws SQLException {
        //先查询正常的RouteGroup
        List<RouteGroup> routeGroups = routeGroupDao.queryAllNormalRouteGroups(tenantId);
        // 查询优先级
        for (RouteGroup routeGroup : routeGroups) {
            //查询该路由组下优先级
            List<PriorityRoutesMapping> routesMappings = routeGroupDao.queryPriorityRoutes(routeGroup.getRouteGroupId());
            filledPriorityRoutesMappingObject(routesMappings);
            routeGroup.addPriorityMapping(routesMappings);
        }

        return routeGroups;
    }

    @Override
    public RouteGroup queryRouteGroupById(String routeGroupId) throws SQLException {
        //查询路由组
        RouteGroup routeGroup = routeGroupDao.queryNormalRouteGroup(routeGroupId);
        //查询路由组下路由和路由规则
        List<PriorityRoutesMapping> routesMappings = routeGroupDao.queryPriorityRoutes(routeGroup.getRouteGroupId());
        filledPriorityRoutesMappingObject(routesMappings);
        routeGroup.addPriorityMapping(routesMappings);
        return routeGroup;
    }

    /**
     * 填充路由规则
     * @param routesMappings
     * @throws SQLException
     */
    private void filledPriorityRoutesMappingObject(List<PriorityRoutesMapping> routesMappings) throws SQLException {
        for (PriorityRoutesMapping mapping : routesMappings) {
            for (Route route : mapping.getRouteList()) {
                if (!routeDao.checkStatusIsValidate(route.getRouteId())){
                    continue;
                }
                //查询此路由下的路由规则
                List<RouteRule> routeRules = routeRuleDao.queryRouteRuleByRouteId(route.getRouteId());
                route.setRouteRules(routeRules);
            }
        }
    }

    public void setRouteGroupDao(IRouteGroupDao routeGroupDao) {
        this.routeGroupDao = routeGroupDao;
    }

    public void setRouteRuleDao(IRouteRuleDao routeRuleDao) {
        this.routeRuleDao = routeRuleDao;
    }

    public void setRouteDao(IRouteDao routeDao) {
        this.routeDao = routeDao;
    }
}
