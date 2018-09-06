package com.itheima.crm.service;

import com.itheima.crm.mapper.BaseDictMapper;
import com.itheima.crm.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaseDictServiceImpl implements BaseDictService{
   @Autowired
    private BaseDictMapper baseDictMapper;
    @Override
    public List<BaseDict> getBaseDictByCode(String code) {
       return baseDictMapper.getBaseDictByCode(code);
    }
}
