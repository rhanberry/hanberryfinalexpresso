
function mockScriptsCalls() {
    inject(function($httpBackend) {
        $httpBackend.whenGET(/scripts\/.*/).respond({});
    });
}
