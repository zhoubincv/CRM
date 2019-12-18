package com.myssm.dao;

import com.myssm.pojo.BaseDict;

import java.util.List;

public interface BaseDictMapper {
    public List<BaseDict> findByTypeCode(String typeCode);
}
