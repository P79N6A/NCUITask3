package com.netcracker.shared.structures;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Date_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native int getDay(com.netcracker.shared.structures.Date instance) /*-{
    return instance.@com.netcracker.shared.structures.Date::day;
  }-*/;
  
  private static native void setDay(com.netcracker.shared.structures.Date instance, int value) 
  /*-{
    instance.@com.netcracker.shared.structures.Date::day = value;
  }-*/;
  
  private static native int getMonth(com.netcracker.shared.structures.Date instance) /*-{
    return instance.@com.netcracker.shared.structures.Date::month;
  }-*/;
  
  private static native void setMonth(com.netcracker.shared.structures.Date instance, int value) 
  /*-{
    instance.@com.netcracker.shared.structures.Date::month = value;
  }-*/;
  
  private static native int getYear(com.netcracker.shared.structures.Date instance) /*-{
    return instance.@com.netcracker.shared.structures.Date::year;
  }-*/;
  
  private static native void setYear(com.netcracker.shared.structures.Date instance, int value) 
  /*-{
    instance.@com.netcracker.shared.structures.Date::year = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.netcracker.shared.structures.Date instance) throws SerializationException {
    setDay(instance, streamReader.readInt());
    setMonth(instance, streamReader.readInt());
    setYear(instance, streamReader.readInt());
    
  }
  
  public static com.netcracker.shared.structures.Date instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.netcracker.shared.structures.Date();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.netcracker.shared.structures.Date instance) throws SerializationException {
    streamWriter.writeInt(getDay(instance));
    streamWriter.writeInt(getMonth(instance));
    streamWriter.writeInt(getYear(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.netcracker.shared.structures.Date_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.netcracker.shared.structures.Date_FieldSerializer.deserialize(reader, (com.netcracker.shared.structures.Date)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.netcracker.shared.structures.Date_FieldSerializer.serialize(writer, (com.netcracker.shared.structures.Date)object);
  }
  
}
