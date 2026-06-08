package com.kh.burgerstack.store;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {
    public Integer findStoreIdByOwnerUserNo(Integer ownerUserNo);
}
