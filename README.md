# Java_working
<head>JAVA PROJECT 
- 로그인 프로그램 구현 프로젝트
</head>


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

22.09.06 -4
1. 배열이 비어있음에도 새로 회원가입을 할수 없는 문제 발생
- for 조건문을 추가하여 배열 전체적으로 확인하여 공간이 있는지 여부를 판단
  - count 변수를 선언하여 for문을 통해 배열을 전체적으로 확인할 수 있게 수정
  - (처음에는 count=0으로 선언하였으나, userArray[ ]에 값이 없는 초기에 프로그램이 종료되는 문제가 발생하여 count = -1으로 변수 선언)
  - 마지막에 count와 userArray.legnth의 크기를 비교하여 같을경우 회원가입이 불가능하게 설정
2. scanner.close 미사용/ 추가
- 입력을 사용할때 키보드를 통해 입력받는 경우도 있지만 파일등을 통해 입력을 받는 경우도 있다. 파일 작업의 순서는 사용하고자 하는 파일을 열고, 사용, 닫기 순서로, 닫지 않을경우 파일이 손상될 수 있으므로, 파일을 열어서 입력을 완료하였을때 닫아야 한다.
- System.in에서 in이 키보드 입력을 가리킨다.
3. Github history 기능 확인
- 주석처리된 내용 삭제
4. README 초입에 프로젝트 설명 추가
5. 미사용 setter 메소드 삭제
6. 탈퇴 메소드 로직 간소화 진행