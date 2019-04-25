package com.netcracker.client;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class GenService_Proxy extends RemoteServiceProxy implements com.netcracker.client.GenServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.netcracker.client.GenService";
  private static final String SERIALIZATION_POLICY ="6E45CB1AE0B997C46FB3DB1A622FB603";
  private static final com.netcracker.client.GenService_TypeSerializer SERIALIZER = new com.netcracker.client.GenService_TypeSerializer();
  
  public GenService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "GenService", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void addRow(com.netcracker.shared.book.Book book, boolean kolStrSort, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GenService_Proxy", "addRow");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("com.netcracker.shared.book.Book/2760479099");
      streamWriter.writeString("Z");
      streamWriter.writeObject(book);
      streamWriter.writeBoolean(kolStrSort);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void changeBook(com.netcracker.shared.book.Book oldBook, com.netcracker.shared.book.Book newBook, boolean kolStrSort, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GenService_Proxy", "changeBook");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("com.netcracker.shared.book.Book/2760479099");
      streamWriter.writeString("com.netcracker.shared.book.Book/2760479099");
      streamWriter.writeString("Z");
      streamWriter.writeObject(oldBook);
      streamWriter.writeObject(newBook);
      streamWriter.writeBoolean(kolStrSort);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void deleteBook(com.netcracker.shared.book.Book book, boolean kolStrSort, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GenService_Proxy", "deleteBook");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("com.netcracker.shared.book.Book/2760479099");
      streamWriter.writeString("Z");
      streamWriter.writeObject(book);
      streamWriter.writeBoolean(kolStrSort);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void getBookArray(java.lang.Integer firstElem, java.lang.Integer size, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GenService_Proxy", "getBookArray");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeObject(firstElem);
      streamWriter.writeObject(size);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void goToFirstPage(int size, boolean kolStrSort, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GenService_Proxy", "goToFirstPage");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("I");
      streamWriter.writeString("Z");
      streamWriter.writeInt(size);
      streamWriter.writeBoolean(kolStrSort);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void goToLastPage(int size, boolean kolStrSort, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GenService_Proxy", "goToLastPage");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("I");
      streamWriter.writeString("Z");
      streamWriter.writeInt(size);
      streamWriter.writeBoolean(kolStrSort);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void goToPage(int page, int size, boolean kolStrSort, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GenService_Proxy", "goToPage");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 3);
      streamWriter.writeString("I");
      streamWriter.writeString("I");
      streamWriter.writeString("Z");
      streamWriter.writeInt(page);
      streamWriter.writeInt(size);
      streamWriter.writeBoolean(kolStrSort);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void reloadTable(java.lang.Integer size, boolean kolStrSort, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("GenService_Proxy", "reloadTable");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeString("Z");
      streamWriter.writeObject(size);
      streamWriter.writeBoolean(kolStrSort);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
