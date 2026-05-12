package sungjuk;

public class 성적 {
	private String 학생id;
	private int 자바;
	private int DB;
	private int 보안;
	private int 총점;
	private double 평균;

	// 행위명: 성적입력 (매개변수에 교수id 추가)
	public String 성적입력(String 교수id, String 학생id, int 자바, int DB, int 보안) {
		// 1. 함수 내부에서 교수체크 수행
		교수 prof = new 교수();
		if (!prof.교수체크(교수id)) {
			return "교수 인증 실패"; // 인증 실패 시 로직 중단 및 메시지 반환
		}

		// 2. 인증 성공 시 데이터 저장 및 계산
		this.학생id = 학생id;
		this.자바 = 자바;
		this.DB = DB;
		this.보안 = 보안;

		this.총점 = 자바 + DB + 보안;
		this.평균 = 총점 / 3.0;

		return "입력 성공 (학생ID: " + 학생id + ", 총점: " + 총점 + ", 평균: " + String.format("%.2f", 평균) + ")";
	}

	// 행위명: 학점조회 (매개변수에 교수id 추가)
	public String 학점조회(String 교수id, String 학생id) {
		// 1. 함수 내부에서 교수체크 수행
		교수 prof = new 교수();
		if (!prof.교수체크(교수id)) {
			return "교수 인증 실패";
		}

		// 2. 인증 성공 시 학점 판별
		String 학점;
		if (this.평균 >= 90) {
			학점 = "A";
		} else if (this.평균 >= 80) {
			학점 = "B";
		} else {
			학점 = "C";
		}
		return 학점; // "A", "B", "C" 또는 "교수 인증 실패"가 반환됨
	}
}