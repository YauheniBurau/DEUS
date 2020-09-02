package core.old;

/**
 * Created by anonymous on 01.05.2017.
 */
public class ARGB{

    public int a;
    public int r;
    public int g;
    public int b;

    public ARGB(int alpha, int red, int green, int blue) {
        this.a = alpha;
        this.r = red;
        this.g = green;
        this.b = blue;
    }

    public ARGB(int red, int green, int blue) {
        this.a = 0xff;
        this.r = red;
        this.g = green;
        this.b = blue;
    }

    public ARGB(int integerArgb) {
        int alpha, red, green, blue;
        alpha = (integerArgb >>> 24) & 0xff;
        red = (integerArgb >>> 16) & 0xff;
        green = (integerArgb >>> 8) & 0xff;
        blue = (integerArgb >>> 0) & 0xff;
        this.a = alpha;
        this.r = red;
        this.g = green;
        this.b = blue;
    }

}
