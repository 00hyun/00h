package kr.or.ddit.basic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;

// JdbcTest05.java를 iBatis용으로 변환해 보기

public class JdbcToIbatisTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SqlMapClient smc = null;
		
		try {
			/*
				Charset charset = Charset.forName("utf-8");
				Resources.setCharset(charset);
				
				Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
				
				smc = SqlMapClientBuilder.buildSqlMapClient(rd);
				
				rd.close();
				*/
			
				smc = SqlMapClientFactory.getSqlMapClient();
				//---------------------------------------------------------------------
				
				int maxNum = (int)smc.queryForObject("jdbc.getMaxId");
				int count = 0;
				String gu;
				
				do {
					System.out.print("상품 분류 코드 입력 >>");
					gu = scan.next();
					
					count = (int)smc.queryForObject("jdbc.getLprodCount", gu);
					if(count>0) {
						System.out.println("입력한 상품 분류코드 " + gu +  " 이미 등록된 코드입니다.");
						System.out.println("다시 입력하세요.");
					}
				}while(count>0);
				
				System.out.println();
				System.out.print("상품 분류명 입력 >> ");
				String nm = scan.next();
				
				LprodVO lvo = new LprodVO();
				lvo.setLprod_id(maxNum);
				lvo.setLprod_gu(gu);
				lvo.setLprod_nm(nm);
				
				Object obj = smc.insert("jdbc.insertLprod",lvo);
				
				if(obj==null) {
					System.out.println("등록 성공!!");
				}else {
					System.out.println("등록 실패~~");
				}
//		} catch (IOException e) {
//			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
