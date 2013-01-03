package com.querymore.etl.pathrouter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LuKun
 * Date: 13-1-3
 * Time: 下午5:28
 * To change this template use File | Settings | File Templates.
 */
public interface PathRouter<ReturnObject> {

    public boolean put(Path path);
    public ReturnObject getLast(Path path);
    public List<ReturnObject> getAll(Path path);

}
