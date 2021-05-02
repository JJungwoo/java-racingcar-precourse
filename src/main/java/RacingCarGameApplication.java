import java.util.*;

public class RacingCarGameApplication {

    static Random random = new Random();

    public static int getMovement() {
        return random.nextInt(9) + 1;
    }

    public static void main(String[] args) {

        List<RacingCar> racingcarList = new ArrayList<>();
        int gameLoop;
        String userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력해주세요.(이름은 쉼표(,) 기준으로 구분)");
        userInput = scanner.nextLine();
        System.out.println("시도할 횟수는 몇회인가요?");
        gameLoop = scanner.nextInt();

        System.out.println("실행 결과");

        String userInputList[] = userInput.split(",");

        for(int i=0;i<userInputList.length;i++) {
            racingcarList.add(new RacingCar(userInputList[i], 0));
        }
        while(gameLoop != 0) {
            for(RacingCar racingcar : racingcarList) {
                if(4 <= getMovement()) {
                    racingcar.Movement();
                }
                System.out.print(racingcar.getCarName() + " : ");
                for(int i=0;i<racingcar.moveCnt;i++) {
                    System.out.print("-");
                }
                System.out.println("");
            }
            System.out.println("");
            gameLoop--;
        }

        int maxMoveCnt = 0;
        for(RacingCar racingcar : racingcarList) {
            maxMoveCnt = Math.max(maxMoveCnt, racingcar.getMoveCnt());
        }

        StringBuilder result = new StringBuilder();

        for(RacingCar racingcar : racingcarList) {
            if(racingcar.getMoveCnt().equals(maxMoveCnt)) {
                result.append(racingcar.carName + ", ");
            }
        }
        result.deleteCharAt(result.lastIndexOf(" "));
        result.deleteCharAt(result.lastIndexOf(","));
        System.out.println(result + "가 최종 우승했습니다.");
    }

}
