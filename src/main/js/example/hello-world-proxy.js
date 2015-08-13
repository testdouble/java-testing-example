window.App = window.App || {};

App.HelloWorldProxy = function(helloWorld){
  this.helloWorld = helloWorld;
};

App.HelloWorldProxy.prototype.say = function() {
  return this.helloWorld.say();
};
