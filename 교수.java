package sungjuk;

public class 교수 {
	// 행위명: 교수체크
	public boolean 교수체크(String 교수id) {
		// 교수id는 "inha"인 경우만 true 반환
		return "inha".equals(교수id);
	}
}