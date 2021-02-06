package design_parking_system;

class ParkingSystem {

    private int space;

    public ParkingSystem(int big, int medium, int small) {
        this.space = (small << 20) | (medium << 10) | big;
    }

    public boolean addCar(int carType) {

        int shiftBits = (10 * (carType - 1));
        int left = (this.space >> shiftBits) & 1023;

        if (left <= 0) {
            return false;
        }

        int mask = left << shiftBits;

        left--;

        this.space = (this.space & ~mask) | (left << shiftBits);

        return true;
    }

    public static void main(String[] args) {
        ParkingSystem d = new ParkingSystem(1, 1, 0);
        System.out.println(d.addCar(1));
        System.out.println(d.addCar(2));
        System.out.println(d.addCar(3));
        System.out.println(d.addCar(1));
    }

}