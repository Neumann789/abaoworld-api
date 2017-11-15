package com.fz.abaoworld.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fz.abaoworld.common.BaseRsp;
import com.fz.abaoworld.common.RspCodeEnum;
import com.fz.abaoworld.dal.dao.UsrInfoDao;
import com.fz.abaoworld.dal.entity.UsrInfoEntity;
import com.fz.abaoworld.service.dto.req.UsrDTO;
import com.fz.abaoworld.utils.CoderByMd5Util;
import com.fz.abaoworld.utils.EmailFormatCheckUtil;
import com.fz.abaoworld.utils.PhoneFormatCheckUtils;
import com.fz.boot.BootServiceStart;

@Service("memberService")
@SuppressWarnings("all")
public class MemberServiceImpl implements com.fz.abaoworld.service.MemberService {
	private final static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	@Autowired
	public UsrInfoDao usrInfoDao;

	@Override
	public BaseRsp registerMember(UsrDTO dto) {
		BaseRsp res = new BaseRsp(RspCodeEnum.SUCCESS);
		UsrInfoEntity info = new UsrInfoEntity();
		// 对dto进行验证，用户名存在，用户邮箱，用户手机号
		res = validData(dto, res);
		if ("0000".equals(res.getRspCode())) {
			try {
				dto.setUsrPwd(CoderByMd5Util.EncoderByMd5(dto.getUsrPwd()));
			} catch (Exception e1) {
				logger.info("加密失败", e1);
				res.setRspCode("9999");
				res.setRspMsg("加密失败，请重试");
				return res;
			}
			logger.info("满足条件：" + res.getRspCode());
			BeanUtils.copyProperties(dto, info);
			try {
				usrInfoDao.insert(info);
				res.setRspCode("0000");
				res.setRspMsg("插入数据成功");
			} catch (Exception e) {
				logger.info("插入数据异常", e);
				res.setRspCode("9999");
				res.setRspMsg("插入数据异常");

			}
		}

		return res;
	}

	private BaseRsp validData(UsrDTO dto, BaseRsp res) {
		UsrInfoEntity info = new UsrInfoEntity();
		BeanUtils.copyProperties(dto, info);
		if (StringUtils.isEmpty(dto.getUsrName())) {
			logger.info("用户名为空");
			res.setRspCode("9999");
			res.setRspMsg("用户名为空，请重新录入");
			return res;
		}
		if (StringUtils.isEmpty(dto.getUsrPwd())) {
			logger.info("密码为空");
			res.setRspCode("9999");
			res.setRspMsg("密码为空，请重新录入");
			return res;
		}
		if (StringUtils.isEmpty(dto.getUsrPhone())) {
			logger.info("手机号为空");
			res.setRspCode("9999");
			res.setRspMsg("手机号为空，请重新录入");
			return res;
		}
		// 判断格式是否符合
		if (dto.getUsrName().length() > 50) {
			logger.info("字符串长度大于50" + dto.getUsrName());
			res.setRspCode("9999");
			res.setRspMsg("字符串长度大于50，请重新录入");
			return res;
		}
		if (!PhoneFormatCheckUtils.isPhoneLegal(dto.getUsrPhone())) {
			logger.info("手机号不符合规则");
			res.setRspCode("9999");
			res.setRspMsg("手机号不符合规则，请重新录入");
			return res;
		}
		if (!StringUtils.isEmpty(dto.getUsrPhone())) {
			if (!EmailFormatCheckUtil.isEmail(dto.getUsrEmail())) {
				logger.info("邮箱不符合规则:" + dto.getUsrEmail());
				res.setRspCode("9999");
				res.setRspMsg("邮箱不符合规则，请重新录入");
				return res;
			}
		}

		List<UsrInfoEntity> luserInfoN = usrInfoDao.getUsrInfoByUsrName(info);
		if (luserInfoN != null && luserInfoN.size() > 0) {
			logger.info("用户名已经存在");
			res.setRspCode("9999");
			res.setRspMsg("用户名已经存在，请重新录入");
			return res;
		}
		List<UsrInfoEntity> luserInfoP = usrInfoDao.getUsrInfoByUsrPhone(info);
		if (luserInfoP != null && luserInfoP.size() > 0) {
			logger.info("手机号已经存在");
			res.setRspCode("9999");
			res.setRspMsg("手机号已经存在，请重新录入");
			return res;
		}
		if (!StringUtils.isEmpty(dto.getUsrPhone())) {
			List<UsrInfoEntity> luserInfoE = usrInfoDao.getUsrInfoByUsrEmail(info);
			if (luserInfoE != null && luserInfoE.size() > 0) {
				logger.info("用户邮箱已经存在");
				res.setRspCode("9999");
				res.setRspMsg("用户邮箱已经存在，请重新录入");
				return res;
			}
		}

		return res;
	}

	@Override
	public BaseRsp findMember(UsrDTO dto) {
		BaseRsp res = new BaseRsp(RspCodeEnum.SUCCESS);
		String usrName = dto.getUsrName();
		String pwd = dto.getUsrPwd();
		// String phone = dto.getUsrPhone();
		if (StringUtils.isEmpty(usrName)) {
			res.setRspCode("9999");
			res.setRspMsg("请输入用户名或者手机号");
			return res;
		}
		if ((StringUtils.isEmpty(pwd))) {
			// 要前台传入加密的数据
			res.setRspCode("9999");
			res.setRspMsg("请输入密码");
			return res;
		}
		try {
			String pwdNew = CoderByMd5Util.EncoderByMd5(pwd);
			List<UsrInfoEntity> luserInfoN = usrInfoDao.getUsrInfoByUsrNameOrByPhone(usrName, pwdNew);
			if (luserInfoN == null || luserInfoN.size() == 0) {
				res.setRspCode("9999");
				res.setRspMsg("用户名或者密码错误，请重新录入");
				return res;
			} else {
				dto.setUsrId(luserInfoN.get(0).getUsrId());
				dto.setUsrEmail(luserInfoN.get(0).getUsrEmail());
				dto.setUsrPhone(luserInfoN.get(0).getUsrPhone());
				dto.setUsrStatus(luserInfoN.get(0).getUsrStatus());
			}
		} catch (Exception e) {
			logger.error("未知异常", e);
			res.setRspCode("9999");
			res.setRspMsg("未知异常");
		}

		return res;
	}

	@Override
	public BaseRsp updateMember(UsrDTO dto) {
		BaseRsp res = new BaseRsp(RspCodeEnum.SUCCESS);
		dto.setUsrPwd("111111");
		res =validData( dto,  res);
		if(RspCodeEnum.SUCCESS.getRspCode().equals(res.getRspCode())){
			UsrInfoEntity info = new UsrInfoEntity();
			BeanUtils.copyProperties(dto, info);
			usrInfoDao.updateMember(info);
		}
		return res;
	}
}
