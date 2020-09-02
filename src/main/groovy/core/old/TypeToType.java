package core.old;

import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

/**
 * Created by anonymous on 28.10.2018.
 */
public class TypeToType {

    public TypeToType(){

    }

    public TypeToType(double d){

    }


    public TypeToType(String str){

    }

    public TypeToType(int v1, String v2){

    }

    public void testVarFunc(long l, double d, int i, char ch, boolean b) {

    }

    /**
     * Matrix2d<Byte> -> EdgeDiff values  in new Matrix2d<Byte>
     * @param in
     * @return
     */
    public static Matrix2d<Byte> M2dByteToM2dByte_EdgeDiff(Matrix2d<Byte> in) {
        int newV, pi, pj, n, k, i, j, x, y;
        Byte v1, v2, v3, v4, v5, v6, v7, v8, v9, v;
        y = in.sizeY;
        x = in.sizeX;
        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null);
        for( j = 0; j<y; j++){
            for( i = 0; i<x; i++) {
                newV = 0;
                n = 0;
                pi = i;
                pj = j;
                v1 = in.getValue(pi, pj);
                v2 = in.getValue(pi, pj-1);
                v3 = in.getValue(pi+1, pj-1);
                v4 = in.getValue(pi+1, pj);
                v5 = in.getValue(pi+1, pj+1);
                v6 = in.getValue(pi, pj+1);
                v7 = in.getValue(pi-1, pj+1);
                v8 = in.getValue(pi-1, pj);
                v9 = in.getValue(pi-1, pj-1);
                if(v1!=null){
                    //if(v1!=null){ newV+=v1; n+=1; } // TODO: check
                    if(v2!=null){ newV+=v2; n+=1; }
                    if(v3!=null){ newV+=v3; n+=1; }
                    if(v4!=null){ newV+=v4; n+=1; }
                    if(v5!=null){ newV+=v5; n+=1; }
                    if(v6!=null){ newV+=v6; n+=1; }
                    if(v7!=null){ newV+=v7; n+=1; }
                    if(v8!=null){ newV+=v8; n+=1; }
                    if(v9!=null){ newV+=v9; n+=1; }
                    newV = (v1 - newV/n)/2;
                    v = SignedIntToSignedByte(newV);
                    out.setValue(pi, pj, v);
                }else{
                    out.setValue(pi, pj, null);
                }
            }
        }
        return out;
    }

    /**
     * transformPoints Matrix2d<Byte> -> Matrix2d<Boolean> as segment edges
     * @param in
     * @return
     */
    public static Matrix2d<Boolean> M2dByteToM2dBoolean_SegmentEdges(Matrix2d<Byte> in) {
        Byte p00, p01, p02, p10, p11, p12, p20, p21, p22;
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Matrix2d<Boolean> out = new Matrix2d<Boolean>(Boolean.class, x, y, null);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                p00 = in.getValue(i-1, j-1); if(p00 ==null) p00 = 0;
                p01 = in.getValue(i, j-1); if(p01 ==null) p01 = 0;
                p02 = in.getValue(i+1, j-1);  if(p02 ==null) p02 = 0;
                p10 = in.getValue(i-1, j);  if(p10 ==null) p10 = 0;
                p11 = in.getValue(i, j);  if(p11 ==null) p11 = 0;
                p12 = in.getValue(i+1, j);  if(p12 ==null) p12 = 0;
                p20 = in.getValue(i-1, j+1);  if(p20 ==null) p20 = 0;
                p21 = in.getValue(i, j+1);  if(p21 ==null) p21 = 0;
                p22 = in.getValue(i+1, j+1);  if(p22 ==null) p22 = 0;
                if( p11>p00 ){ out.setValue( i-1, j-1, true); }
                if( p11>p01 ){ out.setValue( i, j-1, true); }
                if( p11>p02 ){ out.setValue( i+1, j-1, true); }
                if( p11>p10 ){ out.setValue( i-1, j, true); }
                if( p11>p12 ){ out.setValue( i+1, j, true); }
                if( p11>p20 ){ out.setValue( i-1, j+1, true); }
                if( p11>p21 ){ out.setValue( i, j+1, true);}
                if( p11>p22 ){ out.setValue( i+1, j+1,true);}
            }
        }
        return out;
    }

    /**
     * Matrix2dArgb -> JavaFX ImageView
     * @param in
     * @param out
     * @return
     */
    public static ImageView M2dArgbToImageView(Matrix2d<ARGB> in, ImageView out) {
        WritableImage wi = new WritableImage(in.sizeX, in.sizeY);
        PixelWriter pw = wi.getPixelWriter();
        ARGB argb;
        Integer argbInt = null;
        for(int j = 0; j<in.sizeY; j++){
            for(int i = 0; i<in.sizeX; i++) {
                argb = in.getValue( i, j);
                argbInt = TypeToType.ArgbToIntegerArgb(argb);
                pw.setArgb(i, j, argbInt);
            }
        }
        out.setImage(wi);
        return out;
    }

    /**
     * Boolean -> ARGB
     * @param in
     * @return black color for boolean false, white color for boolean true
     */
    public static int BooleanToIntegerArgb(Boolean in){
        if(in == null){
            //throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        int v;
        if(in == false) v = 0xff000000;
        else v = 0xffffffff;
        return v;
    }

    /**
     * ARGB -> Integer argb
     * @param in
     * @return
     */
    public static int ArgbToIntegerArgb(ARGB in){
        int i = 0x00000000;
        i = i | in.a;
        i = i<<8 | in.r;
        i = i<<8 | in.g;
        i = i<<8 | in.b;
        return i;
    }

    /**
     * @param in Hex String in format 0x[0..1,a-f]+
     * @return Long Value
     */
    public static Long HexStringToLong(String in) {
        if( in == null ){
            //throw new InputParamException("input HexString must be not null");
        }
        return Long.decode(in);

    }

    /**
     * @param in Long Value
     * @return Hex String
     */
    public static String LongToHexString(Long in) {
        if( in == null ){
            //throw new InputParamException("input Long must be not null");
        }
        return Long.toHexString(in);
    }

    /**
     * transform Integer Argb -> ARGB
     * @param in Integer in format 0x[AA][rr][gg][bb]
     * @return
     */
    public static ARGB IntegerArgbToArgb(Integer in){
        int alpha, red, green, blue;
        alpha = (in >>> 24) & 0xff;
        red = (in >>> 16) & 0xff;
        green = (in >>> 8) & 0xff;
        blue = (in >>> 0) & 0xff;
        return new ARGB(alpha, red, green, blue);
    }

//    /**
//     * transformPoints signed Byte to Unsigned Int
//     * @param value
//     * @return
//     */
//    public static ARGB SignedByteToArgb(byte value){
//
//        return new ARGB(value+128, 0xff, 0xff, 0xff);
//    }

    /**
     * transform signed Byte to Unsigned Int
     * @param value
     * @return
     */
    public static int SignedByteToUnsignedInt(byte value){
        return(value+128);
    }

    /**
     * transform signed int -> signed Byte
     * @param value
     * @return
     */
    public static byte SignedIntToSignedByte(int value){
        if(value<-128 || value>127){
            //throw new InputParamException("input int must be in [-128..+127]");
        }
        return (byte)(value);
    }


    /**
     * transform unsigned Int [0..255] to signed Byte [-128, +127]
     * int must be in dipazon [0..255]
     * @param value
     * @return
     */
    public static byte UnsignedIntToSignedByte(int value){
        if(value>255 || value<0){
            //throw new InputParamException("input int must be in [0..255]");
        }
        return (byte)(value-128);
    }

    /**
     * transform Double to Byte
     * double must be in dipazon [0.0 .. 255.0]
     * @param value
     * @return
     */
    public static byte UnsignedDoubleToSignedByte(double value){
        if(value>255 || value<0){
            //throw new InputParamException("input int must be in [0..255]");
        }
        return (byte)(value-128);
    }

//    public static ElementImage matrix2dBooleanToImage(Matrix2dBoolean m2d){
//        ElementImage img = new ElementImage();
//        ArrayList<Point2d> points = new ArrayList<Point2d>();
//        ArrayList<Point2dByte> pointsByte = new ArrayList<Point2dByte>();
//        byte value = 127;
//        int size = m2d.size;
//        int sizeY = m2d.sizeY;
//        for (int j = 0; j < sizeY; j++) {
//            for (int i = 0; i < size; i++) {
//                if(m2d.getValue(i, j)==true) points.add( new Point2d(i,j) );
//            }
//        }
//        // здесь должно быть преобразование точек и поворот их, чтобы выровнять ось симметрии вертикеально
//
//        Point2d c = m2d.countCenterOfSymmetry();
//        int a = m2d.countAngleAxisOfSymmetry(c);
//        int l = c.x;
//        int r = c.x;
//        int u = c.y;
//        int d = c.y;
//        for(Point2d p : points){
//            if( p.x < l ) l = p.x;
//            if( p.x > r ) r = p.x;
//            if( p.y < u ) u = p.y;
//            if( p.y > d ) d = p.y;
//        }
//        double width = r - l;
//        double high = d - u;
//        double wStep = width/256;
//        double hStep = high/256;
//        Point2dByte pb;
//        byte x, y;
//        // преобразуем координаты точек в значения относительно центра от -128 до 127
//        for(Point2d p : points) {
//            x = (byte)(-128 + 255*(p.x - l)/width );
//            y = (byte)(-128 + 255*(p.y - u)/high);
//            pb = new Point2dByte(x, y, value);
//            img.setElement(pb);
//        }
//        return img;
//    }
//
//    public static ElementImage ArrayListPoint2dToImage(ArrayList<Point2d> points){
//        byte value = 127;
//        ElementImage img = new ElementImage();
//        ArrayList<Point2dByte> pointsByte = new ArrayList<Point2dByte>();
//        int l = points.get(0).x;
//        int r = points.get(0).x;
//        int u = points.get(0).y;
//        int d = points.get(0).y;
//        for(Point2d p : points){
//            if( p.x < l ) l = p.x;
//            if( p.x > r ) r = p.x;
//            if( p.y < u ) u = p.y;
//            if( p.y > d ) d = p.y;
//        }
//        double width = r - l;
//        double high = d - u;
//        // преобразуем координаты точек в значения относительно центра от -128 до 127
//        Point2dByte pb;
//        byte x, y;
//        for(Point2d p : points) {
//            x = (byte)(-128 + 255*(p.x - l)/width );
//            y = (byte)(-128 + 255*(p.y - u)/high);
//            pb = new Point2dByte(x, y, value);
//            img.setElement(pb);
//        }
//        return img;
//    }


//    public int[] countGistogramByValue(){
//        int v;
//        int gist[] = new int[256];
//        for(int l = 0; l<256; l++){
//            gist[l] = 0;
//        }
//        for(int j = 0; j<this.sizeY; j++){
//            for(int i = 0; i<this.sizeX; i++) {
//                v = this.getValue(i,j).v;
//                if(v>255) System.out.println("v=" + v);
//                gist[v]+=1;
//            }
//        }
//        return gist;
//    }

}
