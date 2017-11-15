package com.fz.abaoworld.dal.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.fz.abaoworld.dal.entity.UsrInfoEntity;

public interface UsrInfoDao {
public  void insert(UsrInfoEntity info);
public List<UsrInfoEntity> getUsrInfoByUsrName(UsrInfoEntity info); 
public List<UsrInfoEntity> getUsrInfoByUsrPhone(UsrInfoEntity info); 
public List<UsrInfoEntity> getUsrInfoByUsrEmail(UsrInfoEntity info); 
public  Map<String,String>  update(UsrInfoEntity info);
public List<UsrInfoEntity> getUsrInfoByUsrNameOrByPhone(@Param("name")String name,@Param("pwd")String pwd);
public void updateMember(UsrInfoEntity dto);
}
