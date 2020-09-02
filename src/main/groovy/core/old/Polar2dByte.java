package core.old;

/**
 * Created by anonymous on 20.12.2018.
 */
public class Polar2dByte {
    public byte a;
    public byte r;

    public Polar2dByte(byte a, byte r) {
        this.a = a;
        this.r = r;
    }

    /**
     * rotate normalizedPolarPoint where whole circle is from 0 to 255 angle points
     * @param angle
     * @return
     */
    public Polar2dByte centralRotate(int angle){
        int newAngle = (this.a + 128 + angle) % 256;
        if(newAngle>=0) {
            this.a = (byte)(newAngle - 128);
        }else{
            this.a = (byte)(128 - newAngle);
        }
        return this;
    }


}
