package com.netcracker.shared.author;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Author_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getEmail(com.netcracker.shared.author.Author instance) /*-{
    return instance.@com.netcracker.shared.author.Author::email;
  }-*/;
  
  private static native void setEmail(com.netcracker.shared.author.Author instance, java.lang.String value) 
  /*-{
    instance.@com.netcracker.shared.author.Author::email = value;
  }-*/;
  
  private static native java.lang.String getGender(com.netcracker.shared.author.Author instance) /*-{
    return instance.@com.netcracker.shared.author.Author::gender;
  }-*/;
  
  private static native void setGender(com.netcracker.shared.author.Author instance, java.lang.String value) 
  /*-{
    instance.@com.netcracker.shared.author.Author::gender = value;
  }-*/;
  
  private static native java.lang.String getName(com.netcracker.shared.author.Author instance) /*-{
    return instance.@com.netcracker.shared.author.Author::name;
  }-*/;
  
  private static native void setName(com.netcracker.shared.author.Author instance, java.lang.String value) 
  /*-{
    instance.@com.netcracker.shared.author.Author::name = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.netcracker.shared.author.Author instance) throws SerializationException {
    setEmail(instance, streamReader.readString());
    setGender(instance, streamReader.readString());
    setName(instance, streamReader.readString());
    
  }
  
  public static com.netcracker.shared.author.Author instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.netcracker.shared.author.Author();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.netcracker.shared.author.Author instance) throws SerializationException {
    streamWriter.writeString(getEmail(instance));
    streamWriter.writeString(getGender(instance));
    streamWriter.writeString(getName(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.netcracker.shared.author.Author_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.netcracker.shared.author.Author_FieldSerializer.deserialize(reader, (com.netcracker.shared.author.Author)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.netcracker.shared.author.Author_FieldSerializer.serialize(writer, (com.netcracker.shared.author.Author)object);
  }
  
}
