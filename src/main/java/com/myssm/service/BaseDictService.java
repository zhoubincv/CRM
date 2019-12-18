package com.myssm.service;

import com.myssm.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    public List<BaseDict> findByTypeCode(String typeCode);

}
