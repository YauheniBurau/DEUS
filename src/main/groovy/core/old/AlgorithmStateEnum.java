package core.old;

import javafx.scene.paint.Color;

public enum AlgorithmStateEnum {
    SUCCESS { // onProcess for algorithm return "true"
        public int value(){return 0;}
        public Color color(){
            return Color.LIGHTGREEN;
        }
    },
    EXCEPTION{ // algorithm thread got exception during runtime
        public int value(){return 1;}
        public Color color(){
            return Color.RED;
        }
    },
    FAIL{ // onProcess for algorithm return "false"
        public int value(){return 2;}
        public Color color(){
            return Color.YELLOW;
        }
    },
    NOT_PROCESSED{
        public int value(){return 3;}
        public Color color(){
            return Color.WHITE;
        }
    };

    public abstract int value();
    public abstract Color color();
}
