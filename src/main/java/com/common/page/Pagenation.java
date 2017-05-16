package com.common.page;

import java.util.List;

public class Pagenation extends SimplePage implements java.io.Serializable,
        Pagenable {

    protected List list;

    public Pagenation() {
    }

    public Pagenation(int pageNo, int pageSize, int totalCount) {
        super(pageNo, pageSize, totalCount);
    }

    public Pagenation(int pageNo, int pageSize, int totalCount, List list) {
        super(pageNo, pageSize, totalCount);
        this.list = list;
    }

    public int getFirstResult() {
        return (pageNo - 1) * pageSize;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
