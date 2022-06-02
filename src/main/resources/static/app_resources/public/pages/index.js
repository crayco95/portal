

(function() {
 
	var app = angular.module('portal', [])
		.controller
		('indexController', ['$http', '$scope', function($http, $scope) {

			$scope.students = [];
			$scope.getStudents = function() {

				var URL = "/colegio/api/students/all";

				$http({
					method: 'GET',
					url: URL
				}).then(
					function(success) {
						 // success
						$scope.students = success.data;
						console.log($scope.students);
					},
					function(error) { // error

					}
				);
			};
			$scope.getStudents();




		}]
		);
	

	

})();

