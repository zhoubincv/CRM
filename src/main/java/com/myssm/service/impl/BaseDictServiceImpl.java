package com.myssm.service.impl;

import com.myssm.dao.BaseDictMapper;
import com.myssm.pojo.BaseDict;
import com.myssm.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    private BaseDictMapper baseDictMapper;

    public List<BaseDict> findByTypeCode(String typeCode) {
        List<BaseDict> byTypeCode = baseDictMapper.findByTypeCode(typeCode);
        return byTypeCode;
    }
}
