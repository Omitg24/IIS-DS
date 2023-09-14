package mars;

public class Terrain 
{
    public Terrain() {
        rocks = new boolean[10][10];
        rocks[1][1] = true;
        rocks[3][3] = true;
        rocks[5][5] = true;
    }

    public boolean isThereObstacle(int x, int y) {
        return rocks[x][y];
    }

    private boolean[][] rocks;
}
