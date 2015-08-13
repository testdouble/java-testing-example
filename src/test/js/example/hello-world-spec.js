describe("Hello World", function(){
  var subject, result;
  beforeEach(function(){
    subject = new App.HelloWorld();

    result = subject.say();
  });
  it("says hello", function(){
    expect(result).to.equal("Hello, World");
  });
});
