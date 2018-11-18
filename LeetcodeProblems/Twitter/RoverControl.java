package Twitter;

public class RoverControl {
    public int roverMove(int size, String[] cmds) {
        int i = 0, j = 0;
        for (String cmd: cmds) {
            switch (cmd){
                case "UP":
                    if (i > 0) {
                        i--;
                    } break;
                case "DOWN":
                    if (i < size - 1) {
                        i++;
                    } break;
                case "LEFT":
                    if (j > 0) {
                        j--;
                    } break;
                case "RIGHT":
                    if (j < size - 1) {
                        j++;
                    } break;
            }
        }
        return i * size + j;
    }

    public static void main(String[] args) {
        int size = 4;
        String[] cmds = {"RIGHT","DOWN","LEFT","LEFT","DOWN"};
        System.out.println(new RoverControl().roverMove(size, cmds));
    }
}
