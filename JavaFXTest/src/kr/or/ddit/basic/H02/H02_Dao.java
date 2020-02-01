package kr.or.ddit.basic.H02;

import java.util.List;

public interface H02_Dao {

	List<H02_ZipVO> searchDong(String txt);

	List<H02_ZipVO> searchZipcode(String txt);

}
