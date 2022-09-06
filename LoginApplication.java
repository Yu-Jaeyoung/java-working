package working;

import java.util.Scanner;

public class LoginApplication {
    private static User[] userArray = new User[10];
    private static Scanner scanner = new Scanner(System.in);

    //main 메소드 1번 while문 활용
  /*  public static void main(String[] args) {
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println(" 1. Create Account 2. Login 3. Search 4. Resign 5. Exit");
            System.out.println("--------------------------------------------------------");
            System.out.println("Select > ");
            int selectNo = scanner.nextInt();
            if (selectNo == 1) {
                newAccount();
            } else if (selectNo == 2) {
                logIn();
            } else if (selectNo == 3) {
                search();
            } else if (selectNo == 4) {
                resign();
            } else if (selectNo == 5) {
                System.out.println("Program End");
                System.exit(0);
            }
        }
    }*/

    //main 메소드 2번 do-while문 활용
    public static void main(String[] args) {
        int selectNum;
        do {
            System.out.println("--------------------------------------------------------");
            System.out.println(" 1. Create Account 2. Login 3. Search 4. Resign 5. Exit");
            System.out.println("--------------------------------------------------------");
            System.out.println("Select > ");
            selectNum = scanner.nextInt();

            if (selectNum == 1) {
                newAccount();
            } else if (selectNum == 2) {
                logIn();
            } else if (selectNum == 3) {
                search();
            } else if (selectNum == 4) {
                resign();
            }
        }
        while (selectNum != 5);
        scanner.close();
        System.out.println("Program End");
    }

    //회원가입
    private static void newAccount() {
        //count 변수를 사용하여 배열이 가득찼는지 여부를 판단
        int count = -1;
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] == null) {
                break;
            } else {
                count++;
            }
        }

        if (count == userArray.length - 1) {
            System.out.println("Can't Create New Account");
            return;
            //10개의 계정이 가득 찬 상태
            //메소드 실행 강제 종료
        }

        System.out.println("--------------");
        System.out.println("Create Account");
        System.out.println("--------------");
        System.out.println("Id : ");
        String newId = scanner.next();

        //아이디 중복 여부 확인 추가
        boolean check;
        check = overlapIdCheck(newId);
        if (!check) {
            System.out.println("Overlap Id found");
            return;
        }


        System.out.println("Password : ");
        String newPassword = scanner.next();

        System.out.println("NickName : ");
        String newNickname = scanner.next();

        User newUser = new User(newId, newPassword, newNickname);


        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] == null) {
                userArray[i] = newUser;
                System.out.println("Create Success");
                break;
            }
        }
    }

    //로그인
    private static void logIn() {
        System.out.println(" ID > ");
        String id = scanner.next();
        System.out.println(" Password > ");
        String password = scanner.next();
        System.out.println();


        boolean check;
        check = matchUser(id, password);

        if (check) {
            System.out.println("Login succeed");
            System.out.println("Id : " + id);
            System.out.println("Nickname : " + userArray[userNum(id)].getNickname());
        } else {
            System.out.println("Login failed");
        }
    }

    //사용자 조회
    //향상된 for문 사용할 것 ???

    //향상된 for문으로 작성??
    private static void search() {
        System.out.println("--------------");
        System.out.println("Searching");
        System.out.println("--------------");
        System.out.println();

        for (User check : userArray) {
            if (check != null) {
                System.out.println(check.getNickname());
                System.out.println();
            }
        }
    }

    //탈퇴
    private static void resign() {

        System.out.println(" ID > ");
        String id = scanner.next();
        System.out.println(" Password > ");
        String password = scanner.next();
        System.out.println();

        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null) {
                if (userArray[i].getId().equals(id) && userArray[i].getPassword().equals(password)) {
                    userArray[i] = null;
                    System.out.println("Resign Succeed");
                    System.out.println();
                    return; //이 상황에선 탈퇴 메소드 종료
                }
            }
        }
        System.out.println("Resign failed");
    }

    //로그인용 메소드
    //userArray 배열에서 id,password 와 동일한 userArray 배열 찾기
    //findUser -> matchUser로 변경
    //int 타입에서 boolean 타입으로 변경
    private static boolean matchUser(String id, String password) {
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null) {
                String newId = userArray[i].getId();
                String newPassword = userArray[i].getPassword();
                // (수정 전)
                // if (newId.equals(id) && newPassword.equals(password)) {
                // 기존 id와 newId의 equals 리턴값과 newPassword와 password의 리턴값이 같으면 1을 반환하도록 한것을
                // id와 newId의 equals 리턴값(boolean값)이 true 인 경우에
                // newPassword와 password의 리턴값(boolean값)이 true인 경우 ture를 반환하도록 설정
                if (newId.equals(id)) {
                    if (newPassword.equals(password)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 아이디 중복 확인 메소드
    // 가입할때 활용
    // 아이디가 중복될 경우 false, 중복이 아닐경우 true를 반환하도록 설정
    private static boolean overlapIdCheck(String id) {
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null) {
                String newId = userArray[i].getId();
                if (newId.equals(id)) {
                    return false;
                }
            }
        }
        return true;
    }

    //아이디 저장위치 반환 메소드
    private static int userNum(String id) {
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null) {
                String newId = userArray[i].getId();
                if (newId.equals(id)) {
                    return i;
                }
            }
        }
        return 0;
    }

    //프로그램 종료 메소드
    private static boolean isExit() {
        return false;
    }

}
