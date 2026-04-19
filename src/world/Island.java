package world;

public class Island {
    private Cell[][] grind = new Cell[30][50];

    public Island() {
        for(int i = 0; i < 30; ++i) {
            for(int j = 0; j < 50; ++j) {
                this.grind[i][j] = new Cell();
            }
        }

    }

    public Cell getCell(int x, int y) {
        return this.grind[x][y];
    }
}
