package com.fz.abaoworld.service;

import com.fz.abaoworld.common.BaseRsp;
import com.fz.abaoworld.service.dto.req.UsrDTO;

@SuppressWarnings("all")
public interface MemberService {
	
	
/**
 * 会员登记
 * @param dto
 * @return
 */
public BaseRsp registerMember(UsrDTO dto);

/**
 * 会员信息查询
 * @param dto
 * @return
 */
public BaseRsp findMember(UsrDTO dto);

/**
 * 更新数据
 */
public BaseRsp updateMember(UsrDTO dto);
}
