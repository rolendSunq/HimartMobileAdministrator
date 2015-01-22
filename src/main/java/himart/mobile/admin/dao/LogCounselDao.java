package himart.mobile.admin.dao;


import himart.mobile.admin.vo.LogCounselVO;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;


/**
 * 하이마트 모바일서비스 관리자 시스템
 *
 * @description 상담로그
 * @author SeoJohoon
 */

@Repository
public class LogCounselDao extends SqlSessionDaoSupport {
	/**
	 * 상담로그 총 건수 조회
	 * @param vo
	 * @return
	 */
	public int getLogCounselTotCount(LogCounselVO vo) {
		return getSqlSession().selectOne("log.selectLogCounselTotCount", vo);
	}

	/**
	 * 상담로그 화면용 목록 조회
	 * @param vo
	 * @return
	 */
	public List<LogCounselVO> getLogCounselViewList(LogCounselVO vo) {
		return getSqlSession().selectList("log.selectLogCounselViewList", vo);
	}

	/**
	 * 상담로그 엑셀용용 목록 조회
	 * @param vo
	 * @return
	 */
	public List<LogCounselVO> getLogCounselExcelList(LogCounselVO vo) {
		return getSqlSession().selectList("log.selectLogCounselExcelList", vo);
	}
}
