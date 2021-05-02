public class RacingCar {

    String carName;
    Integer moveCnt;

    public RacingCar(String carName, Integer moveCnt) {
        this.carName = carName;
        this.moveCnt = moveCnt;
    }

    public String getCarName() {
        return this.carName;
    }

    public Integer getMoveCnt() {
        return this.moveCnt;
    }

    public void Movement() {
        this.moveCnt++;
    }
}
