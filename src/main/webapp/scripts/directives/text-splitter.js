angular.module('sbAdminApp')
    .directive('textSplitter',['$location',function() {
        return {
            templateUrl:'scripts/directives/text-splitter.html',
            restrict: 'E',
            replace: true,
            scope: {
            },
            controller:function($scope, TextService){

                $scope.pie = {
                    labels: [],
                    data: []
                };

                $scope.text = "ProgForce, more than anything else, is a league of extraordinary talent" +
                    " - sought, refined, and dedicated to providing the most impeccableintelligence and" +
                    " service. Our team of professional software developersare specially chosen through a process" +
                    " of selection based not only ontraining, but conception and creative application." +
                    " Our people don't justplug in the numbers. Our people create custom solutions for custom needs.";

                $scope.split = function () {
                    if (angular.isDefined($scope.text)) {
                        splitAndShowChart($scope.text);

                    }
                };

                $scope.onFileChanged = function($files) {
                    var reader = new FileReader();

                    reader.onload = function(onLoadEvent) {
                        splitAndShowChart(onLoadEvent.target.result);
                    };

                    reader.readAsText($files[0]);
                };

                function splitAndShowChart(text) {
                    var response = TextService.splitText(text);
                    response.then(
                        function(result){
                            $scope.pie.labels = [];
                            $scope.pie.data = [];
                            angular.forEach(result.data, function(value, key) {
                                $scope.pie.labels.push(key);
                                $scope.pie.data.push(value);
                            });
                        },
                        function(response){
                            console.log(response);
                        })
                }
            }
        }
    }]);