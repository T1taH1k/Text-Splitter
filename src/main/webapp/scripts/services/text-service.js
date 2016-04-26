angular.module('sbAdminApp').factory('TextService', function ($http) {
    return {
        splitText: function (text) {
            return $http.post("split-text", text.toLowerCase()
            )
        }
    };
});