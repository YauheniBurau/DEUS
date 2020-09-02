package core.old;

/**
 * Created by anonymous on 04.12.2018.
 */
public class ContourDecart2dToContourPolar2d {

//    /**
//     * PolarConture (absolute values) -> NormalizedPolarConture( values in range [-128 +127] )
//     * works only for 2d contour
//     * @param in
//     * @return
//     */
//    public static ContourPolar2d transform(ContourDecart2d in) {
//        // ContourDecart2dInt -> ContourPolar2dDouble
//        Decart2d contourCenter = in.countContourCenter();
//        ContourDecart2d contourDouble = new ContourDecart2d();
//        ContourPolar2d contourByte = new ContourPolar2d();
//        double dist, maxDistance, d, angle;
//        byte a, r;
//        // count max distance and find distance from center to points
//        for(Decart2d p: in.elements) {
//            angle = ContourDecart2dToContourPolar2d.countPolarAngle( contourCenter, p);
//            d = Math.sqrt((contourCenter.x - p.x)*(contourCenter.x - p.x) + (contourCenter.y - p.y)*(contourCenter.y - p.y));
//            contourDouble.elements.add( new Decart2d(angle, d) );
//        }
//        // ContourDecart2d (where x = a and y = r) -> ContourPolar2d
//        maxDistance = 0;
//        for(Decart2d p: contourDouble.elements) {
//            if (p.y > maxDistance) {
//                maxDistance = p.y;
//            }
//        }
//        for(Decart2d p: contourDouble.elements) {
//            dist = (p.y/maxDistance)*255;
//            r = UnsignedDoubleToSignedByte.transform(dist);
//            angle = p.x /360 * 255;
//            a = UnsignedDoubleToSignedByte.transform(angle);
//            contourByte.elements.add( new Polar2dByte(a, r) );
//        }
//        return contourByte;
//    }

    /**
     * find a of line by elements and center elements
     * a starts from -180 to 180
     *          0
     *          |
     *  -90 ----|---- 90
     *          |
     *     -180 | 180
     * @param center
     * @param point
     * @return a in grades
     */
//    public static double countPolarAngle(Decart2d center, Decart2d point){
//        double angle;
//        angle = Math.atan2( point.x - center.x, point.y - center.y );
//        angle = angle *180/Math.PI;
//        angle = angle + 270;
//        if(angle >=360) angle -=360;
//        if(angle>0) angle = Math.abs(angle-360);
//        return angle;
//    }

}
