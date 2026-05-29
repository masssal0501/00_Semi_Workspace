package com.kh.burgerstack.example.pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.burgerstack.common.pagination.PageInfo;
import com.kh.burgerstack.common.pagination.PagingRequest;

@Service
public class ExamplePaginationService {
    @Autowired
    private ExamplePaginationDao paginationDao;

    public PageInfo getPageInfo(PagingRequest pagingRequest) {
        return pagingRequest.toPageInfo(paginationDao.getTotalCount());
    }
}
