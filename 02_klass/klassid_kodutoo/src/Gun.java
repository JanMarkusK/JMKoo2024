public class Gun {
    int magazinCapacity;
    int magazinCount;
    int bullets;

    public Gun(int magazinCapacity, int magazinCount, int bullets) {
        this.magazinCapacity = magazinCapacity;
        this.magazinCount = magazinCount;
        this.bullets = bullets;
    }

    public void magazinReloading(int magazinCount) {
        while (magazinCount < magazinCapacity) {
            magazinCount++;
            bullets--;
        }
        if (magazinCount == magazinCapacity) {
            System.out.println("Salv on laetud");
        }
        if (bullets == 0) {
            System.out.println("I need more BULLETS!");
        }
    }
    public int bulletSupply(int bulletsBrought) {
        bullets = bullets + bulletsBrought;
        return bullets;
    }
}
