describe("Hello World Proxy", function(){
  var subject, helloWorld, result;
  beforeEach(function(){
    helloWorld = { say: sinon.stub().returns("Something") };
    subject = new App.HelloWorldProxy(helloWorld);

    result = subject.say();
  });

  it("returns whatever helloWorld gives it", function(){
    expect(result).to.equal("Something");
  });
});
