package com.querymore.etl.pathrouter;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: LuKun
 * Date: 13-1-3
 * Time: 下午5:42
 * To change this template use File | Settings | File Templates.
 */
public class RegexPathRouterNode<ReturnObject> implements PathRouterNode<ReturnObject> {

    private String _pathNode;
    private Pattern _pathNode_Pattern;
    private int _priority;
    private Map<String, PathRouterNode<ReturnObject>> _childNodes_Map;
    private List<PathRouterNode<ReturnObject>> _childNodes_List;
    private List<ReturnObject> _returnObjects;

    public RegexPathRouterNode(String pathNode) {
        _pathNode = pathNode;
        _pathNode_Pattern = Pattern.compile(pathNode);
        _priority = -1;

        _childNodes_Map = new HashMap<String, PathRouterNode<ReturnObject>>();
        _childNodes_List = new ArrayList<PathRouterNode<ReturnObject>>();
        _returnObjects = new ArrayList<ReturnObject>();
    }

    @Override
    public PathRouterNode<ReturnObject> setChild(PathRouterNode<ReturnObject> childNode) {
        RegexPathRouterNode<ReturnObject> _childNode = (RegexPathRouterNode<ReturnObject>)childNode;

        if (_childNodes_Map.containsKey(_childNode._pathNode)) {
            return _childNodes_Map.get(_childNode._pathNode);
        } else {
            _childNodes_Map.put(_childNode._pathNode, _childNode);
            _childNodes_List.add(_childNode);
            return _childNode;
        }
    }

    @Override
    public List<PathRouterNode<ReturnObject>> getChilds() {
        return _childNodes_List;
    }

    @Override
    public List<PathRouterNode<ReturnObject>> getChilds(String pathNode) {
        ArrayList<PathRouterNode<ReturnObject>> _returnNode = new ArrayList<PathRouterNode<ReturnObject>>();

        for (PathRouterNode<ReturnObject> childNode : _childNodes_List) {
            RegexPathRouterNode<ReturnObject> _childNode = (RegexPathRouterNode<ReturnObject>)childNode;
            Pattern _childNode_Pattern = _childNode._pathNode_Pattern;
            if (_childNode_Pattern.matcher(pathNode).find()) {
                _returnNode.add(_childNode);
            }
        }

        return _returnNode;
    }

    @Override
    public boolean hasObject() {
        return _returnObjects.size() > 0;
    }

    @Override
    public void addObject(ReturnObject returnObject) {
        _returnObjects.add(returnObject);
    }

    @Override
    public List<ReturnObject> getObjects() {
        return _returnObjects;
    }

    public void setPriority(int priority) {
        _priority = priority;
    }

    public int getPriority() {
        return _priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegexPathRouterNode that = (RegexPathRouterNode) o;

        return _pathNode.equals(that._pathNode);

    }

    @Override
    public int hashCode() {
        return _pathNode.hashCode();
    }
}
