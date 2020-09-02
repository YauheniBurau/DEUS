package newValueView

class ValueViewFxFactory {

    static IValueViewFx create(Class<?> type){
        IValueViewFx c
        switch (type){
            case [int.class, Integer.class] : c = new IntegerViewFx(); c.init((Integer)0); break
            case [double.class, Double.class] : c = new DoubleViewFx(); c.init((Double)0.0); break
            case [float.class, Float.class] : c = new FloatViewFx(); c.init((Float)0.0); break
            case [byte.class, Byte.class] : c = new ByteViewFx(); c.init((Byte)0); break
            case [char.class, Character.class] : c = new CharViewFx(); c.init((char)'C' ); break
            case [long.class, Long.class] : c = new LongViewFx(); c.init((Long)0); break
            case [boolean.class, Boolean.class] : c = new BoolViewFx(); c.init(true); break
            case String.class : c = new StringViewFx(); c.init(""); break
            case Class.class : c = new ClassViewFx(); c.init(Class.class); break
            case Object.class : c = new ObjectViewFx(); c.init(new Object()); break
            default: c = new DefaultViewFx(); c.init(new Object())
        }
        return c
    }
}
