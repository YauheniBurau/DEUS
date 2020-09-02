package newWorkflowFx;

import java.io.Serializable;

public enum ShapeSvgPathEnum implements Serializable {
    SQUARE {
        public String value(){return "M 0 1 L 8 1 L 8 5 L 0 5 L 0 1";}
    },
    TRIANGLE_LEFT {
        public String value(){return "M 0 3 L 4 1 L 4 5 L 0 3";}
    },
    TRIANGLE_RIGHT {
        public String value(){return "M 4 1 L 8 3 L 4 5 L 4 1";}
    },
    TRIANGLE_UP {
        public String value(){return "M 0 5 L 2 1 L 4 5 L 0 5";}
    },
    TRIANGLE_DOWN {
        public String value(){return "M 0 1 L 4 1 L 2 5 L 0 1";}
    },
    OVAL {
        public String value(){return "M 4 1 Q 6 1 6 3 Q 6 5 4 5 Q 2 5 2 3 Q 2 1 4 1";}
    },
    ROMB {
        public String value(){return "M 4 1 L 8 3 L 4 5 L 0 3 L 4 1";}
    },
    RECTANGLE {
        public String value(){return "M 0 1 L 8 1 L 8 5 L 0 5 L 0 1";}
    },
    DIAGONAL_RECTANGLE {
        public String value(){return "M 0 2 L 1 1 L 7 1 L 8 2 L 8 4 L 7 5 L 1 5 L 0 4 L 0 2";}
    },
    ANGLE_ROUNDED_RECTANGLE {
        public String value(){return "M 0 2 Q 0 1 1 1 L 7 1 Q 8 1 8 2 L 8 4 Q 8 5 7 5 L 1 5 Q 0 5 0 4 L 0 2";}
    },
    ROMBIC_RECTANGLE {
        public String value(){return "M 0 3 L 1 1 L 7 1 L 8 3 L 7 5 L 1 5 L 0 3";}
    },
    ROUNDED_RECTANGLE {
        public String value(){return "M 20 10 L 60 10 A 5 5 0 1 1 60 50 L 20 50 A 5 5 0 1 1 20 10";}
    },
    CUSTOM {
        public String value(){return "";}
    };

    public abstract String value();
}
