package com.netcracker.client;

public class TablePageControl {
    private int page;
    private int pageSize;

    public TablePageControl(int startPage,int pageSize)
    {
        this.page = startPage;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int setPage(int newPage) {
        this.page = newPage;
        return page;
    }

    public int nextPage()
    {
        page++;
        return page;
    }

    public int prevPage()
    {
        page--;
        return page;
    }

    public int firstPage()
    {
        page = 0;
        return page;
    }
}
