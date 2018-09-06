package com.itheima.crm.mapper;

import com.itheima.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictMapper {
    List<BaseDict> getBaseDictByCode(String code);
}
