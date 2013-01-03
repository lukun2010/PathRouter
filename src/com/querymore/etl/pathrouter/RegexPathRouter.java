package com.querymore.etl.pathrouter;

import com.querymore.common.LRUCache;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LuKun
 * Date: 13-1-3
 * Time: 下午5:41
 * To change this template use File | Settings | File Templates.
 */
public class RegexPathRouter<ReturnObject> implements PathRouter<ReturnObject> {

    private int _cacheSize;
    private LRUCache _pathtree_map;

    public RegexPathRouter(int cacheSize) {
        _cacheSize = cacheSize;
    }

    @Override
    public boolean put(Path path) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ReturnObject getLast(Path path) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<ReturnObject> getAll(Path path) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
