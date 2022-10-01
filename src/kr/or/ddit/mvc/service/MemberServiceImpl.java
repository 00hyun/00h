package kr.or.ddit.mvc.service;

import java.io.ObjectInputStream.GetField;
import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.dao.IMemberDao;
import kr.or.ddit.mvc.dao.MemberDaoImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {

	// 싱글톤
	// 1번
	private static MemberServiceImpl service;
	
	// Service객체가 사용할 DAO객체 변수를 선언한다.
	private IMemberDao dao;
	
	
	// 2번 생성자가 이미 있으면 public -> private 으로 변경
	// 생성자에서 DAO객체를 생성한다.
	private MemberServiceImpl() {
//		dao = new MemberDaoImpl();
		dao = MemberDaoImpl.getInstance();
	}
	
	// 3번
	public static MemberServiceImpl GetInstance() {
		if(service==null) service = new MemberServiceImpl();
		return service;
	}
	
	
	@Override
	public int insertMember(MemberVO memVo) {
		return dao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return dao.updateMember(memVo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public int getMemberCount(String memId) {
		return dao.getMemberCount(memId);
	}


	@Override
	public int updateMember2(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return dao.updateMember2(paramMap);
	}

}
