package com.querymore.etl.pathrouter;

/**
 * Created with IntelliJ IDEA.
 * User: LuKun
 * Date: 13-1-3
 * Time: 下午5:33
 * To change this template use File | Settings | File Templates.
 */
public class Path {

    private String _pathstr;
    private String[] _pathnodes;

    public Path(String pathstr) {
        _pathstr = pathstr;
        if (_pathstr.length() > 0 && _pathstr.startsWith("/")) {
            _pathnodes = _pathstr.substring(1).split("/");
        } else {
            _pathnodes = _pathstr.split("/");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Path path = (Path) o;

        if (!_pathstr.equals(path._pathstr)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return _pathstr.hashCode();
    }
}
