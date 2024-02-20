public class Gun {
    int magazinCapacity;
    int magazinCount;
    int bullets;

    public Gun(int magazinCapacity, int magazinCount, int bullets) {
        this.magazinCapacity = magazinCapacity;
        this.magazinCount = magazinCount;
        this.bullets = bullets;
    }

    public int magazinReloading(int magazinCountFinished) {
        this.magazinCount = magazinCountFinished;
        while (this.magazinCount < magazinCapacity) {
            this.magazinCount = this.magazinCount + 1;
            bullets--;

        }
        if (this.magazinCount == magazinCapacity) {
            System.out.println("Salv on laetud");
        }
        if (bullets == 0) {
            System.out.println("I need more BULLETS!");
        }
        return this.magazinCount;
    }
    public int bulletSupply(int bulletsBrought) {
        bullets = bullets + bulletsBrought;
        return bullets;
    }
}
