package com.acme.app;

public class HelloWorldProxy {

  private HelloWorld helloWorld = new HelloWorld();

  public String say() {
    return helloWorld.say();
  }
  
}
