package com.netcracker.shared.book;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Book_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.netcracker.shared.author.Author getAuthor(com.netcracker.shared.book.Book instance) /*-{
    return instance.@com.netcracker.shared.book.Book::author;
  }-*/;
  
  private static native void setAuthor(com.netcracker.shared.book.Book instance, com.netcracker.shared.author.Author value) 
  /*-{
    instance.@com.netcracker.shared.book.Book::author = value;
  }-*/;
  
  private static native com.netcracker.shared.structures.Date getDateAdd(com.netcracker.shared.book.Book instance) /*-{
    return instance.@com.netcracker.shared.book.Book::dateAdd;
  }-*/;
  
  private static native void setDateAdd(com.netcracker.shared.book.Book instance, com.netcracker.shared.structures.Date value) 
  /*-{
    instance.@com.netcracker.shared.book.Book::dateAdd = value;
  }-*/;
  
  private static native com.netcracker.shared.structures.Date getDateIsd(com.netcracker.shared.book.Book instance) /*-{
    return instance.@com.netcracker.shared.book.Book::dateIsd;
  }-*/;
  
  private static native void setDateIsd(com.netcracker.shared.book.Book instance, com.netcracker.shared.structures.Date value) 
  /*-{
    instance.@com.netcracker.shared.book.Book::dateIsd = value;
  }-*/;
  
  private static native int getId(com.netcracker.shared.book.Book instance) /*-{
    return instance.@com.netcracker.shared.book.Book::id;
  }-*/;
  
  private static native void setId(com.netcracker.shared.book.Book instance, int value) 
  /*-{
    instance.@com.netcracker.shared.book.Book::id = value;
  }-*/;
  
  private static native int getKolStr(com.netcracker.shared.book.Book instance) /*-{
    return instance.@com.netcracker.shared.book.Book::kolStr;
  }-*/;
  
  private static native void setKolStr(com.netcracker.shared.book.Book instance, int value) 
  /*-{
    instance.@com.netcracker.shared.book.Book::kolStr = value;
  }-*/;
  
  private static native java.lang.String getName(com.netcracker.shared.book.Book instance) /*-{
    return instance.@com.netcracker.shared.book.Book::name;
  }-*/;
  
  private static native void setName(com.netcracker.shared.book.Book instance, java.lang.String value) 
  /*-{
    instance.@com.netcracker.shared.book.Book::name = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.netcracker.shared.book.Book instance) throws SerializationException {
    setAuthor(instance, (com.netcracker.shared.author.Author) streamReader.readObject());
    setDateAdd(instance, (com.netcracker.shared.structures.Date) streamReader.readObject());
    setDateIsd(instance, (com.netcracker.shared.structures.Date) streamReader.readObject());
    setId(instance, streamReader.readInt());
    setKolStr(instance, streamReader.readInt());
    setName(instance, streamReader.readString());
    
  }
  
  public static com.netcracker.shared.book.Book instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.netcracker.shared.book.Book();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.netcracker.shared.book.Book instance) throws SerializationException {
    streamWriter.writeObject(getAuthor(instance));
    streamWriter.writeObject(getDateAdd(instance));
    streamWriter.writeObject(getDateIsd(instance));
    streamWriter.writeInt(getId(instance));
    streamWriter.writeInt(getKolStr(instance));
    streamWriter.writeString(getName(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.netcracker.shared.book.Book_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.netcracker.shared.book.Book_FieldSerializer.deserialize(reader, (com.netcracker.shared.book.Book)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.netcracker.shared.book.Book_FieldSerializer.serialize(writer, (com.netcracker.shared.book.Book)object);
  }
  
}
