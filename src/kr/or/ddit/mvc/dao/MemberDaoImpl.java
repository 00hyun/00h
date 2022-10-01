package kr.or.ddit.mvc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class MemberDaoImpl implements IMemberDao {
	
	private SqlMapClient smc;	//SqlMapClient객체 변수 선언(ibatis 처리용 객체)
	
	// 싱글톤으로 만들기
	// 1번
	private static MemberDaoImpl dao;
	
	// 2번                            
	private MemberDaoImpl() {  
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	// 3번
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
				
		return dao;
		
	}
	
	Scanner scan = new Scanner(System.in);
	
	
	@Override
	public int insertMember(MemberVO memberVo) {
	
		int cnt = 0;	// 반환값이 저장될 변수
		
		try {
			
			cnt = (int) smc.insert("member.insertMember",memberVo);
		
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		
		int cnt = 0;
		
			try {

				cnt = smc.delete("member.deleteMember",memId);
				

					
				} catch (SQLException e) {
					cnt=0;
					e.printStackTrace();
				}
			return cnt;
	}

	@Override
	public int updateMember(MemberVO memberVo) {
		int cnt = 0;
		
		try {

			cnt = smc.update("member.updateMember",memberVo);
			
			MemberVO mvo = new MemberVO();
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		
		return cnt;
	}
	
	

	@Override
	public List<MemberVO> getAllMember() {
		
		List<MemberVO> memList = null; // 반환값이 저장될 변수
		
		try {
			memList = smc.queryForList("member.getAllMember");
				
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		} 
		return memList;
	}
	
	

	@Override
	public int getMemberCount(String memId) {
		int count = 0;	// 반환값이 저장될 변수
		
		try {

			count = (int) smc.queryForObject("memeber.getMemberCount",memId);
			
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	
	
	@Override
	public int updateMember2(Map<String, String> paramMap) {
		int cnt = 0;	// 반환값 변수
		
		try {

//			Map구조 : key값 ==> 회원ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)
			cnt = smc.update("member.updateMember2", paramMap);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}
	
}
