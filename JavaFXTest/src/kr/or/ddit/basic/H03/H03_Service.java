package kr.or.ddit.basic.H03;

import java.util.List;

public interface H03_Service {

	List<H03_LprodVO> getCombo1();

	List<H03_ProdVO> getCombo2(String name);

	List<H03_ProdVO> getRealVO(String prod_id);

}
