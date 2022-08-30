# Java_working
수정한 내용

22.08.30 - 1

1. 중복확인 메소드 추가 생성
- overlapIdCheck
2. findUser 이름/메소드 타입 변경
- findUser -> matchUser
- 메소드 타입 boolean으로 수정
3. 아이디 중복 확인 메소드 이용
   회원가입시 확인하도록 수정

22.08.30 -2
1. nickname 반환 메소드 삭제
2. 아이디 위치 반환 메소드 추가
- userNum
3. 로그인 시 출력되는 닉네임 함수 변경
- userNickname(id, password) > userArray[userNum(id)].getNickname()
4. 종료 메소드 사용하여 프로그램 종료
5. main 메소드의 종류를 두가지 타입으로 작성
  - while문을 사용하고 종료 메소드를 활용 프로그램 종료
  - do while문을 사용, 종료 메소드를 활용 프로그램 종료

22.08.30 -3
1. login() 안 변수 count -> check 로 변경
2. if (count) ~ if (!count)~ 를 if (count) else {} ~로 수정
3. do-while 문 수정