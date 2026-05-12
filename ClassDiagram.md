```mermaid
classDiagram
    class Add_Sungjuk_UI {
        <<boundary>>
        +처리결과출력(메시지: String) void
    }

    class 교수 {
        -교수id: String
        +교수체크(교수id: String) boolean
    }

    class 성적 {
        -학생id: String
        -자바: int
        -DB: int
        -보안: int
        -총점: int
        -평균: double
        +성적입력(교수id: String, 학생id: String, 자바: int, DB: int, 보안: int) void
        +학점조회(교수id: String) String
        -총점계산() int
        -평균계산() double
    }

    %% 관계 설정
    %% UI는 성적 클래스의 행위를 호출하므로 의존 관계
    Add_Sungjuk_UI ..> 성적 : 호출

    %% 성적 클래스는 교수체크를 위해 교수 클래스를 참조하므로 연관 관계
    성적 "1" --> "1" 교수 : 교수체크 참조