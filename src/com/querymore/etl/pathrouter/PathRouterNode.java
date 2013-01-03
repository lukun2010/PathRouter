package com.querymore.etl.pathrouter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LuKun
 * Date: 13-1-3
 * Time: 下午5:47
 * To change this template use File | Settings | File Templates.
 */
public interface PathRouterNode<ReturnObject> {

    public PathRouterNode<ReturnObject> setChild(PathRouterNode<ReturnObject> childnode);
    public List<PathRouterNode<ReturnObject>> getChilds();
    public List<PathRouterNode<ReturnObject>> getChilds(String pathnode);

    public boolean hasObject();
    public void addObject(ReturnObject returnobject);
    public List<ReturnObject> getObjects();

}
