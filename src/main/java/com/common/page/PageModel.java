package com.common.page;

import java.util.List;

public class PageModel<T> {

    private int totalRecord;

    private List<T> list;

    private int pageNo;

    private int pageSize;

    public PageModel() {
    }

    public PageModel(int pageNo, int pageSize, List<T> list, int totalRecord) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.list = list;
        this.totalRecord = totalRecord;
    }

    public int getTotalpages() {
        return (totalRecord + pageSize - 1) / pageSize;
    }

    public int getTopPages() {
        return 1;
    }

    public int getBottomPages() {
        return getTotalpages() == 0 ? 1 : getTotalpages();
    }

    public int getPreviousPageNo() {
        if (pageNo <= 1) {
            return 1;
        }
        return pageNo - 1;
    }

    public int getNextPageNo() {
        if (pageNo >= getTotalpages()) {
            return getTotalpages() == 0 ? 1 : getTotalpages();
        }
        return pageNo + 1;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
