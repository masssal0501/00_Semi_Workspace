package com.kh.burgerstack.example.dto;

import java.util.List;

import com.kh.burgerstack.common.pagination.PageInfo;

public class ExamplePatternListView {
    private final ExamplePatternSearchCondition condition;
    private final List<String> materialTypes;
    private final List<ExamplePatternListItem> list;
    private final PageInfo pageInfo;

    public ExamplePatternListView(ExamplePatternSearchCondition condition, List<String> materialTypes,
            List<ExamplePatternListItem> list, PageInfo pageInfo) {
        this.condition = condition;
        this.materialTypes = materialTypes;
        this.list = list;
        this.pageInfo = pageInfo;
    }

    public ExamplePatternSearchCondition getCondition() {
        return condition;
    }

    public List<String> getMaterialTypes() {
        return materialTypes;
    }

    public List<ExamplePatternListItem> getList() {
        return list;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }
}
