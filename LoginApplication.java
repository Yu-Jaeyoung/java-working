package working;

import java.util.Scanner;

public class LoginApplication {
    private static User[] userArray = new User[10];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
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
                run = false;
            }
        }
        System.out.println("Program End");
    }

    //회원가입
    private static void newAccount() {
        System.out.println("--------------");
        System.out.println("Create Account");
        System.out.println("--------------");

        if (userArray[9] != null) {
            System.out.println("Can't Create New Account");
            return;
            //10개의 계정이 가득 찬 상태
            //메소드 실행 강제 종료
        }

        System.out.println("Id : ");
        String newId = scanner.next();

        System.out.println("Password : ");
        String newPassword = scanner.next();

        System.out.println("NickName : ");
        String newNickname = scanner.next();

        User newUser = new User(newId, newPassword, newNickname);


        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] == null) {
                userArray[i] = newUser;
                break;
            }
        }
        System.out.println("Create Success");
    }

    //로그인
    private static void logIn() {
        System.out.println(" ID > ");
        String id = scanner.next();
        System.out.println(" Password > ");
        String password = scanner.next();
        System.out.println();


        int count = 0;
        count = findUser(id, password);

        if (count == 1) {
            System.out.println("Login succeed");
            System.out.println("Id : " + id);
            System.out.println("Nickname : " + userNickname(id, password));
        }
        if (count == 0) {
            System.out.println("Login failed");
        }
    }

    //사용자 조회
    //toString(문자 열로 만들어 리턴)
    //향상된 for문 사용할 것 ???
    //향상된 for문 미사용으로 제작해본것
/*    private static void search() {
        System.out.println("--------------");
        System.out.println("Searching");
        System.out.println("--------------");
        System.out.println();

        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null) {
                String newNickname = userArray[i].getNickname();
                if (newNickname != null) {
                    System.out.println(newNickname);
                    System.out.println();
                }
            }
        }
    }*/

    //향상된 for문으로 작성??
    private static void search() {
        System.out.println("--------------");
        System.out.println("Searching");
        System.out.println("--------------");
        System.out.println();

        for (User Check : userArray) {
            if (Check != null) {
                System.out.println(Check.getNickname());
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
                String newId = userArray[i].getId();
                String newPassword = userArray[i].getPassword();
                if (newId.equals(id) && newPassword.equals(password)) {
                    userArray[i] = null;
                    return; //이 상황에선 탈퇴를 종료
                }
            }
        }
        System.out.println("Resign failed");
    }

    //userArray 배열에서 id,password 와 동일한 userArray 배열 찾기
    //id, password가 둘다 동일할 경우 "1"을 반환
    private static int findUser(String id, String password) {
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null) {
                String newId = userArray[i].getId();
                String newPassword = userArray[i].getPassword();
                if (newId.equals(id) && newPassword.equals(password)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    //nickname 반환 메소드
    private static String userNickname(String id, String password) {
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null) {
                String newId = userArray[i].getId();
                String newPassword = userArray[i].getPassword();
                String newNickname = userArray[i].getNickname();
                if (newId.equals(id) && newPassword.equals(password)) {
                    return newNickname;
                }
            }
        }
        return "default";
    }
}
