package core.old;

// TODO: remove later
/**
 * Created by anonymous on 24.03.2018.
 */
public class Transformer {

    // ================================ TYPES CONVERSION ===============================================

//    /**
//     * NormalizedPolarPoint -> polarPoint where a value ={0..360}; r value = {0..255}
//     * @param in
//     * @param out
//     * @return
//     */
//    public static PolarPoint transform(NormalizedPolarPoint in, PolarPoint out){
//        double a = 360.0 / 255.0 * (in.a + 128);
//        double r = (in.r +128);
//        return new PolarPoint(a, r);
//    }

//    /**
//     * PolarPoint where a value ={0..360}; r value = {0..255} -> Point2d where x and y ={-128..+127}
//     * @param in
//     * @param out
//     * @return
//     */
//    public static Point2d transformPoints(PolarPoint in, Point2d out){
//        int x = (int) Math.floor( (in.r * Math.cos(in.a * Math.PI / 180))/2 );
//        int y = (int) Math.floor( (in.r * Math.sin(in.a * Math.PI / 180))/2 );
//        return new Point2d(x, y);
//    }

//    /**
//     * NormalizedPolarPoint -> PolarPoint -> Point2d
//     * @param in
//     * @param out
//     * @return
//     */
//    public static Point2d transformPoints(NormalizedPolarPoint in, Point2d out){
//        PolarPoint pp = null;
//        pp = Transformer.transformPoints(in, pp);
//        Point2d p2d = null;
//        p2d = Transformer.transformPoints(pp, p2d);
//        return p2d;
//    }

//    /**
//     * NormalizedPolarConture -> transformPoints to Matrix2dBoolean as picture
//     * @param in
//     * @param out
//     * @return
//     */
//    public static Matrix2dBoolean transformPoints(NormalizedPolarConture in, Matrix2dBoolean out) {
//        Matrix2dBoolean m2d = new Matrix2dBoolean(256, 256);
//        // draw contureLine in Matrix
//        NormalizedPolarPoint nppFirst, nppLast, npp1, npp2;
//        nppFirst = in.points.get(0);
//        nppLast = in.points.get(0);
//        npp1 = nppFirst;
//        Point2d p1 = null, p2 = null;
//        for (NormalizedPolarPoint npp: in.points){
//            npp2 = npp;
//            p1 = Transformer.transformPoints(npp1, p1);
//            p2 = Transformer.transformPoints(npp2, p2);
////            m2d.drawLine(p1.x+128, p1.y+128, p2.x+128, p2.y+128);
//            npp1 = npp2;
//            nppLast = npp2;
//        }
//        p1 = Transformer.transformPoints(nppFirst, p1);
//        p2 = Transformer.transformPoints(nppLast, p2);
////        m2d.drawLine(p1.x+128, p1.y+128, p2.x+128, p2.y+128);
//        return m2d;
//    }

    //    /**
//     * NormalizedPolarConture -> NormalizedPolarConture, where all cell under conture line are fullfilled
//     * @param in
//     * @param out
//     * @return
//     */
//    public static Matrix2dBoolean transformPoints(NormalizedPolarConture in, Matrix2dBoolean out) {
//        Matrix2dBoolean m2d = new Matrix2dBoolean(256, 256);
//        // draw contureLine in Matrix
//        NormalizedPolarPoint npp1, npp2;
//        npp1 = in.points.get(0);
//        for (NormalizedPolarPoint npp: in.points){
//            npp2 = npp;
//            if(Math.abs(npp1.a - npp2.a)>128){
//                // TODO: Make  it cicle from last coords to firstPoint of LinkedList
//            }
//            else{
//                m2d.drawLine(npp1.a+128, npp1.r+128, npp2.a+128, npp2.r+128);
//            }
//            npp1 = npp2;
//        }
//        // fulfill cells under conture line
//        boolean fill, prevValue, currValue;
//        for(int i=0; i<256; i++){
//            fill = false;
//            prevValue = m2d.getValue(i,255);
//            currValue = m2d.getValue(i,255);
//            for(int j=255; j>=0; j--) {
//                currValue = m2d.getValue(i,j);
//                if(prevValue == true && currValue == false) {
//                    fill = !fill;
//                }
//                if(currValue == false && fill == true){
//                    m2d.setBufferedImage(i, j, fill);
//                }
//                prevValue = currValue;
//            }
//        }
//        return m2d;
//    }

}