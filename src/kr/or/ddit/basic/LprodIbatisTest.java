package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class LprodIbatisTest {
	
	// ibatis를 이용하여 DB자료를 처리하는 순서 및 방법
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			// 1. iBatis의 환경 설정 파일(sqlMapConfig.xml)을 읽어와서 처리한다.
			// 1-1. 문자 인코딩 캐릭터 셋 설정
			Charset charset = Charset.forName("utf-8");
			Resources.setCharset(charset);
			
			// 1-2 환경 설정 파일을 읽어 올 스트림 객체 생성
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
			
			// 1-3. 생성된 스트림 객체를 이용하여 환경 설정 파일을 읽어와 환경 설정 내용을 처리한다.
			//		이 때 iBatis를 사용할 객체가 생성된다. (객체명 : SqlMapClient)
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			// 1-4. 스트림 닫기
			rd.close();
			//------------------------------------------------------------------------------
			
			// 2. 1-3에서 만들어진 SqlMapClient객체를 이용하여 실행할 SQL문을 호출하여 처리한다.
			
			/*
			// 2-1. insert연습
			System.out.println("insert 작업 시작...");
			
			System.out.print("Lprod_id 입력 >> ");
			int lprodId = scan.nextInt();
			
			System.out.print("Lprod_gu 입력 >> ");
			String lprodGu = scan.next();
			
			System.out.print("Lprod_nm 입력 >> ");
			String lprodNm = scan.next();
			
			// 1) 입력한 데이터를 VO객체에 담는다.
			LprodVO lvo = new LprodVO();
			lvo.setLprod_id(lprodId);
			lvo.setLprod_gu(lprodGu);
			lvo.setLprod_nm(lprodNm);
			
			// 2) SqlMapClient객체변수를 이용하여 처리할 쿼리문을 호출하여 실행한다.
			// 	형식) smc.insert("namespace속성값.id속성값", 파라미터값)
			//		반환값 : insert성공 : null, insert실패 : 오류객체
			Object obj = smc.insert("lprod.insertLprod", lvo);
			if(obj==null) {
				System.out.println("insert 작업 성공!!!");
			}else {
				System.out.println("insert 작업 실패~~~");
			}
			System.out.println("-------------------------------------------");
			*/
			
			/*
			// 2-2. update연습
			System.out.println("update 작업 시작...");
			
			System.out.print("수정할 Lprod_GU 입력 >> ");
			String lprodGu2 = scan.next();
			
			System.out.print("새로운 Lprod_id 입력 >> ");
			int newLprodId = scan.nextInt();
			
			System.out.print("새로운 Lprod_nm 입력 >> ");
			String newLprodNm = scan.next();
			
			// 입력한 값을 VO객체에 저장한다.
			LprodVO lvo2 = new LprodVO();
			lvo2.setLprod_gu(lprodGu2);
			lvo2.setLprod_id(newLprodId);
			lvo2.setLprod_nm(newLprodNm);
			
			// 2) 실행하기
			// 형식) smc.update("namespace속성값.id속성값",파라미터값);
			// 		반환값 : 작업에 성공한 레코드 수
			int cnt = smc.update("lprod.updateLprod", lvo2);
			
			if(cnt>0) {
				System.out.println("update 작업 성공!!!");
			}else {
				System.out.println("update 작업 실패~~~");
			}
			System.out.println("-------------------------------------------");
			*/
			
			// 2-3. delete연습
			/*
			System.out.println("delete 작업 시작...");
			System.out.print("삭제할 Lprod_gu 입력 >> ");
			String delLprodGu = scan.next();
	
			// 1) 실행하기
			// 형식) smc.delete("namespace속성값.id속성값", 파라미터값);
			//		반환값 : 작업에 성공한 레코드 수
			int cnt2 = smc.delete("lprod.deleteLprod", delLprodGu);
			
			if(cnt2>0) {
				System.out.println("delete 작업 성공!!!");
			}else {
				System.out.println("delete 작업 실패~~~");
			}
			System.out.println("-------------------------------------------");
			*/
			
			// 2-4. select 연습
			/*
			// 1) 응답 결과가 여러개인 경우
			System.out.println("select작업 시작(응답 결과가 여러개일 경우)...");
			// 응답 결과가 여러개일 경우에는 queryForList()메서드를 사용하는데
			// 이 메서드는 여러개의 레코드 각각을 VO객체에 담은 후 이 VO객체들을 
			// List에 추가해주는 작업을 자동으로 수행한다.
			// 형식) smc.queryForList("namespace속성값.id속성값", 파라미터클래스);
			//		반환값 : List객체
			
			List<LprodVO> lprodList = smc.queryForList("lprod.getAllLprod");
			
			for(LprodVO lvo3 : lprodList) {
				System.out.println("ID : " + lvo3.getLprod_id());
				System.out.println("GU : " + lvo3.getLprod_gu());
				System.out.println("NM : " + lvo3.getLprod_nm());
				System.out.println("-----------------------------");
			}
			System.out.println("출력 끝...");
			
			System.out.println("-----------------------------");
			*/
			
			// 2)응답 결과가 1개인 경우
			System.out.println("select작업 시작(응답 결과가 1개일 경우)...");
			
			System.out.print("검색할 Lprod_gu 입력 >> ");
			String searchLprodGu = scan.next();
			
			// 응답 결과가 1개가 확실할 경우에는 queryForObject()메서드를 사용한다.
			//  형식) smc.queryForObject("namespace속성값.id속성값", 파라미트클래스);
			//		반환값 : - 처리 결과가 여러개일 경우 => exception 리턴
			//		         - 처리 결과가 1개일 경우 ==> 해당 객체 리턴 (정상처리)
			//				 - 처리 결과가 없을 경우 ==> null 리턴
			
			LprodVO lvo4 = (LprodVO) smc.queryForObject("lprod.getLprod", searchLprodGu);
			
			if(lvo4==null) {
				System.out.println(searchLprodGu + "는 없는 상품 분류 코드 입니다...");
				return;
			}
			System.out.println("     == 검색 결과 ==");
			System.out.println("ID : " + lvo4.getLprod_id());
			System.out.println("GU : " + lvo4.getLprod_gu());
			System.out.println("NM : " + lvo4.getLprod_nm());
			
			System.out.println("-----------------------------");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
