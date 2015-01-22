package himart.mobile.admin.dao;

import himart.mobile.admin.vo.UserInfoVO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * 하이마트 모바일서비스 관리자 시스템
 *
 * @description 사용자정보 조회
 * @author SeoJohoon
 */

@Repository
public class UserInfoDao extends SqlSessionDaoSupport {
	// 사용자정보조회
	public UserInfoVO getUserInfo(UserInfoVO vo) {
		return getSqlSession().selectOne("user.selectUserInfo", vo);
	}
}
