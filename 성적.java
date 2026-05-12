package sungjuk;

import model.교수;

public class 성적 {
	private String 학생id;
	private int 자바;
	private int DB;
	private int 보안;
	private int 총점;
	private double 평균;

	// 행위명: 성적입력 (기존과 동일하되 내부 저장)
	public String 성적입력(String 교수id, String 학생id, int 자바, int DB, int 보안) {
		교수 prof = new 교수();
		if (!prof.교수체크(교수id)) {
			return "교수 인증 실패";
		}

		this.학생id = 학생id;
		this.자바 = 자바;
		this.DB = DB;
		this.보안 = 보안;
		this.총점 = 자바 + DB + 보안;
		this.평균 = 총점 / 3.0;

		return "입력 성공 (학생ID: " + 학생id + ")";
	}

	// 학점 판별을 위한 내부 보조 메서드
	private String 판별(double 점수) {
		if (점수 >= 90)
			return "A";
		if (점수 >= 80)
			return "B";
		return "C";
	}

	// 행위명: 학점조회 (각 과목 학점 및 평균 학점 포함)
	public String 학점조회(String 교수id, String 학생id) {
		교수 prof = new 교수();
		if (!prof.교수체크(교수id)) {
			return "교수 인증 실패";
		}

		// 각 과목 학점 계산
		String 자바학점 = 판별(this.자바);
		String DB학점 = 판별(this.DB);
		String 보안학점 = 판별(this.보안);
		String 평균학점 = 판별(this.평균);

		// 결과 문자열 조립
		return String.format(
				"자바: %s, DB: %s, 보안: %s | [평균 학점: %s]",
				자바학점, DB학점, 보안학점, 평균학점);
	}
}